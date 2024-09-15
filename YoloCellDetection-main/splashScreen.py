import time
from PIL import Image

def splashScreen():
    splash1 = "\nYeast Analyzer v1.0\n"
    splash2 = "Colaboration:\n  IF Fluminense\n  EMBRAPII\n  Polo de Inovações\n\n"
    splash3 = "by: Fabio Duncan, Fernando Carvalho, Vitor Bernardo, Thiago Fagundes \[T']/\n\n"

    print(splash1)
    time.sleep(1)
    print(splash2)
    time.sleep(1)
    print(splash3)
    time.sleep(3)

def splash():
#    img = Image.open('splash.png')
#    img.show()
#    time.sleep(5)
#    img.close()
    import sys # to access the system
    import cv2
    img = cv2.imread("splash.png", cv2.IMREAD_ANYCOLOR)
    
    while True:
        cv2.imshow("Have a nice day!", img)
        cv2.waitKey(0)
        sys.exit() # to exit from all the processes
    
    cv2.destroyAllWindows() # destroy all windows
