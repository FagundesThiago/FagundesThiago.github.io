#clone YOLOv5 and
import os
os.system('git clone https://github.com/ultralytics/yolov5') # clone repo
os.chdir('yolov5')
os.system('pip install -qr requirements.txt') # install dependencies
os.system('pip install -q roboflow')

import torch
from IPython.display import Image, clear_output  # to display images

print(f"Setup complete. Using torch {torch.__version__} ({torch.cuda.get_device_properties(0).name if torch.cuda.is_available() else 'CPU'})")