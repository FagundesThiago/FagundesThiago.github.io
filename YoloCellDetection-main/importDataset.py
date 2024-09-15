# set up environment
import os
from roboflow import Roboflow

os.environ["DATASET_DIRECTORY"] = "yolov5\datasets"

rf = Roboflow(api_key="5H9DQvIPCeOjoLdHuz1q")
project = rf.workspace("iff").project("cell-counting-vyzdn")
dataset = project.version(1).download("yolov5")