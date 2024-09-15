import os

os.chdir('yolov5')
os.system('python train.py --img 416 --batch 16 --epochs 1500 --data \datasets\Cell-counting-1\data.yaml --weights yolov5l.pt --cache')
