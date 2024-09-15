import os
from pathlib import Path
from PIL import Image, ImageDraw

def enumerate(path, ext):
    labels = path + "/labels"
    labelList = os.listdir(labels)
    for label in labelList:
        enumerateByImage(path + "/" + label.replace(".txt", ext), labels + "/" + label)

def enumerateByImage(image, label):
    txt = Path(label).read_text()
    content = txt.splitlines()
    img = Image.open(image)
    enumerate = 1
    num = image.split("/")
    num = len(num[len(num)-1])
    for line in content:
        line = line.split(" ")
        x = float(line[1])
        y = float(line[2])
        di = ImageDraw.Draw(img)
        di.text((x*img.width, y*img.height), str(enumerate), fill =(255, 255, 255))
        enumerate = enumerate + 1
    if (os.path.exists(image[:-int(num)] + "/enumerated") == False):
        os.makedirs(image[:-int(num)] + "/enumerated")
    img.save(image[:-int(num)] + "/enumerated/" + label[-int(num)::].replace(".txt", ".png"))
