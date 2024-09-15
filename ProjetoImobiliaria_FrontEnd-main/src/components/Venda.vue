<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <template>
          <v-data-table :headers="headers" :items="vendas" :items-per-page="10" class="elevation-1">
            <template v-slot:top>
              <v-toolbar flat>
                <v-toolbar-title>Vendas</v-toolbar-title>
                <v-divider class="mx-4" inset vertical></v-divider>
                <input v-model.number="iptId" placeholder="Pesquise pelo id" @keyup.enter="getById" />
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
                            <v-text-field v-model="editedItem.id" label="Contrato"></v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="8">
                            <v-text-field v-model="editedItem.dataContrato" label="Data do Contrato">
                            </v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.valor" label="Valor">
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
  name: 'Venda',

  data: () => ({
    dialog: false,
    iptId: '',
    headers: [
      { text: 'Contrato', value: 'id' },
      { text: 'Data do Contrato', value: 'dataContrato' },
      { text: 'Valor', value: 'valor' },
      { text: 'Ações', value: 'actions' },
    ],
    vendas: [],
    editedIndex: -1,
    editedItem: {
      id: 0,
      dataContrato: "",
      valor: "",
    },
    defaultItem: {
      id: 0,
      dataContrato: "",
      valor: "",
    },

  }),
  methods: {
    inicializa() {
      axios("http://localhost:3000/vendas")
        .then((response) => {
          this.vendas = response.data
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
            "http://localhost:3000/vendas/" + this.iptId
          )
          .then((response) => {
            console.log(response);
            this.vendas = [response.data];
          })
          .catch((error) => console.log(error));
      } else {
        this.getAll();
      }
    },
    getAll() {
      axios
        .get(
          "http://localhost:3000/vendas"
        )
        .then((response) => {
          console.log(response);
          this.vendas = response.data;
        })
        .catch((error) => console.log(error));
    },
    save() {
      if (this.editedIndex > -1) {
        axios
          .put(
            "http://localhost:3000/vendas/" + this.editedItem.id,
            this.editedItem
          )
          .then((response) => {
            console.log(response);
            Object.assign(this.vendas[this.editedIndex], this.editedItem);
            this.close();
          })
          .catch((error) => console.log(error));
      } else {
        axios
          .post("http://localhost:3000/vendas", this.editedItem)
          .then((response) => {
            console.log(response);
            this.vendas.push(this.editedItem);
            this.close();
          })
          .catch((error) => console.log(error));
      }
    },
    editItem(item) {
      this.editedIndex = this.vendas.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },
    deleteItem(item) {
      const index = this.vendas.indexOf(item);
      confirm("Deseja apagar este item?") &&
        axios
          .delete("http://localhost:3000/vendas/" + item.id)
          .then((response) => {
            console.log(response.data);
            this.vendas.splice(index, 1);
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
