import os
import shutil
from pathlib import Path
import cv2

def enumerate(path, ext):
    temp = 'C:/Users/Tigor/source/yoloCellCounting/temp'
    if os.path.exists(temp):
        shutil.rmtree(temp)
    shutil.copytree(path, temp)
    labels = temp + "/labels"
    labelList = os.listdir(labels)
    for label in labelList:
        enumerateByImage(temp + "/" + label.replace(".txt", ext), labels + "/" + label)
    if os.path.exists(path + "/enumerated"):
        shutil.rmtree(path + "/enumerated")
    shutil.copytree(temp + "/enumerated", path + "/enumerated")
    shutil.rmtree(temp)

def enumerateByImage(image, label):
    txt = Path(label).read_text()
    content = txt.splitlines()
    path = str(image)
    img = cv2.imread(path)
    height, width, channels = img.shape
    enumerate = 1
    num = image.split("/")
    num = len(num[len(num)-1])
    for line in content:
        line = line.split(" ")
        x = float(line[1])
        y = float(line[2])
        font = cv2.FONT_HERSHEY_SIMPLEX
        org = (int(x*width), int(y*height))
        fontScale = 0.70
        color = (0, 0, 255)
        thickness = 1
        img = cv2.putText(img, str(enumerate), org, font, 
                        fontScale, color, thickness, cv2.LINE_AA)
        enumerate = enumerate + 1
    if (os.path.exists(image[:-int(num)] + "/enumerated") == False):
        os.makedirs(image[:-int(num)] + "/enumerated")
    cv2.imwrite(image[:-int(num)] + "/enumerated/" + label[-int(num)::].replace(".txt", ".png"), img)
