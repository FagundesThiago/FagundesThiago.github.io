from tkinter import filedialog
from tkinter import *
import os
import shutil
from yolov5 import detect

root = Tk()
root.withdraw()
folder_selected = filedialog.askdirectory()
caminho = folder_selected.replace("\\", "/")

processadas = caminho + '/Processadas'
if (os.path.exists(processadas)):
    shutil.rmtree(processadas)
shutil.copytree(caminho, 'C:/Users/Tigor/source/yoloCellCounting/yolov5/temp')

if (os.path.exists('C:/Users/Tigor/source/yoloCellCounting/yolov5/runs/detect/exp')):
    shutil.rmtree('C:/Users/Tigor/source/yoloCellCounting/yolov5/runs/detect/exp')
#os.chdir('yolov5')
#os.system('python detect.py --line-thickness 2 --hide-labels --hide-conf --weights runs/train/exp/weights/bestv2.pt --source temp --conf-thres 0.6 --save-txt')
#detect.run(line_thickness = 2, hide_labels = True, hide_conf = True, weights = 'C:/Users/Tigor/source/yoloCellCounting/yolov5/runs/train/exp/weights/bestv2.pt', source = 'C:/Users/Tigor/source/yoloCellCounting/yolov5/temp', conf_thres = 0.6, save_txt = True)
detect.run(line_thickness = 2, hide_labels = False, hide_conf = True, weights = 'C:/Users/Tigor/source/yoloCellCounting/yolov5/runs/train/exp/weights/best w cropped.pt', source = 'C:/Users/Tigor/source/yoloCellCounting/yolov5/temp', conf_thres = 0.6, save_txt = True)

shutil.copytree('C:/Users/Tigor/source/yoloCellCounting/yolov5/runs/detect/exp', processadas)
shutil.rmtree('C:/Users/Tigor/source/yoloCellCounting/yolov5/temp')