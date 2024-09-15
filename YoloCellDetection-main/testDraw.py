import os
from PIL import Image
import identifyCropped as id
import bb

# em processo, mas inacabado por enquanto

imagePath = "C:/Users/Tigor/OneDrive/Área de Trabalho/Thiago/EMBRAPII/Leveduras - 15 Jul. 22_Croped"
labelPath = "C:/Users/Tigor/OneDrive/Área de Trabalho/Thiago/EMBRAPII/Leveduras - 15 Jul. 22_Croped/Processadas v2/labels"
images = os.listdir(imagePath)
images = images[3::]
labels = os.listdir(labelPath)

for label in labels:
    img = Image.open(imagePath + "/" + label[0:-3] + "tif")
    width = img.width
    height = img.height

    newLabel = id.identify(labelPath + "/" + label, width, height)
    txt = open("C:/Users/Tigor/Downloads/label/" + label, "w")
    for line in newLabel:
        txt.write(line)
        txt.write("\n")
    txt.close

drawBox.drawBox(imagePath, "C:/Users/Tigor/Downloads/label", "C:/Users/Tigor/Downloads/label/result")
