import identifyCropped as id

txt = id.identify("C:/Users/Tigor/OneDrive/Área de Trabalho/Thiago/EMBRAPII/Leveduras - 15 Jul. 22_Croped/Processadas v2/labels/20220715160748-croped.txt", 1225, 1204)

for line in txt:
    print(line)