from tkinter import filedialog
from tkinter import *
import enumerate
import enumeratev2

root = Tk()
root.withdraw()
folder_selected = filedialog.askdirectory()
caminho = folder_selected.replace("\\", "/")
enumeratev2.enumerate(caminho, ".tif")
