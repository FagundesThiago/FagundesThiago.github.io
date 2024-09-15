import os

os.chdir('yolov5')
#os.system('python detect.py --line-thickness 2 --hide-labels --hide-conf --weights runs/train/exp/weights/best.pt --source ../test')
os.system('python detect.py --line-thickness 2 --weights runs/train/exp/weights/best.pt --source datasets/Cell-counting-1/test/images --conf-thres 0.6 --save-txt')

