<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <template>
          <v-data-table :headers="headers" :items="corretores" :items-per-page="10" class="elevation-1">
            <template v-slot:top>
              <v-toolbar flat>
                <v-toolbar-title>Corretores</v-toolbar-title>
                <v-divider class="mx-4" inset vertical></v-divider>
                <input v-model.number="iptId" placeholder="Pesquise pelo ID" @keyup.enter="getById" />
                <v-spacer></v-spacer>
                <v-dialog v-model="dialog" max-width="700px">
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
                      Novo Item
                    </v-btn>
                  </template>
                  <v-card>
                    <v-card-title>
                      <span class="headline">{{ formTitle }}</span>
                    </v-card-title>

                    <v-card-text>
                      <v-container>
                        <v-row>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.id" label="Id"></v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="8">
                            <v-text-field v-model="editedItem.nome" label="Nome">
                            </v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.cpf" label="CPF">
                            </v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.telefone" label="Telefone">
                            </v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.email" label="Email">
                            </v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.dataAdmissao" label="Data de Admissão">
                            </v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.gerenteId" label="Id do Gerente">
                            </v-text-field>
                          </v-col>
                        </v-row>
                      </v-container>
                    </v-card-text>

                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn color="red darken-1" text @click="close"> Cancel </v-btn>
                      <v-btn color="red darken-1" text @click="save"> Save </v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </v-toolbar>
            </template>
            <template v-slot:item.actions="{ item }">
              <v-icon small class="mr-2" @click="editItem(item)"> mdi-pencil </v-icon>
              <v-icon small @click="deleteItem(item)"> mdi-delete </v-icon>
            </template>
            <template v-slot:no-data>
              <v-btn color="primary" @click="inicializa"> Reset </v-btn>
            </template>

          </v-data-table>
        </template>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  name: 'Corretor',

  data: () => ({
    dialog: false,
    iptId: '',
    headers: [
      { text: 'ID', value: 'id' },
      { text: 'Nome', value: 'nome' },
      { text: 'CPF', value: 'cpf' },
      { text: 'Telefone', value: 'telefone' },
      { text: 'Email', value: 'email' },
      { text: 'Data de Admissão', value: 'dataAdmissao' },
      { text: 'Id do Gerente', value: 'gerenteId' },
      { text: 'Ações', value: 'actions' },
    ],
    corretores: [],
    editedIndex: -1,
    editedItem: {
      id: 0,
      nome: "",
      cpf: "",
      telefone: "",
      email: "",
      dataAdmissao: "",
      gerenteId: "",
    },
    defaultItem: {
      id: 0,
      nome: "",
      cpf: "",
      telefone: "",
      email: "",
      dataAdmissao: "",
      gerenteId: "",
    },

  }),
  methods: {
    inicializa() {
      axios("http://localhost:3000/corretores")
        .then((response) => {
          this.corretores = response.data
        })
        .catch((error) => console.log(error));
    },
    close() {
      this.dialog = false;
      setTimeout(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      }, 300);
    },
    getById() {
      if (this.iptId != 0) {
        axios
          .get(
            "http://localhost:3000/corretores/" + this.iptId
          )
          .then((response) => {
            console.log(response);
            this.corretores = [response.data];
          })
          .catch((error) => console.log(error));
      } else {
        this.getAll();
      }
    },
    getAll() {
      axios
        .get(
          "http://localhost:3000/corretores"
        )
        .then((response) => {
          console.log(response);
          this.corretores = response.data;
        })
        .catch((error) => console.log(error));
    },
    save() {
      if (this.editedIndex > -1) {
        axios
          .put(
            "http://localhost:3000/corretores/" + this.editedItem.id,
            this.editedItem
          )
          .then((response) => {
            console.log(response);
            Object.assign(this.corretores[this.editedIndex], this.editedItem);
            this.close();
          })
          .catch((error) => console.log(error));
      } else {
        axios
          .post("http://localhost:3000/corretores", this.editedItem)
          .then((response) => {
            console.log(response);
            this.corretores.push(this.editedItem);
            this.close();
          })
          .catch((error) => console.log(error));
      }
    },
    editItem(item) {
      this.editedIndex = this.corretores.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },
    deleteItem(item) {
      const index = this.corretores.indexOf(item);
      confirm("Deseja apagar este item?") &&
        axios
          .delete("http://localhost:3000/corretores/" + item.id)
          .then((response) => {
            console.log(response.data);
            this.corretores.splice(index, 1);
          })
          .catch((error) => console.log(error));
    },
  },
  computed: {
    formTitle() {
      return this.editedIndex === -1 ? "Novo Item" : "Editar Item";
    },
  },
  watch: {
    dialog(val) {
      val || this.close();
    },
    dialogDelete(val) {
      val || this.closeDelete();
    },
  },
  created() {
    this.inicializa();
  }
}
</script>
