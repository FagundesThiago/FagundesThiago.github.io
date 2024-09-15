from pathlib import Path

def identify(path, width, height):
    # read txt in path
    instances = Path(path).read_text().splitlines()
    results = list()
    for instance in instances:
        instance = instance.split(" ")
        instance[0] = touchWitchSide(instance, width, height)
        results.append(instanceToStr(instance))
    return results
    
def touchWitchSide (instance, width, height):
    typeClass = instance[0]
    x = float(instance[1]) * int(width)
    y = float(instance[2]) * int(height)
    instanceWidth = float(instance[3]) * int(width)
    instanceHeight = float(instance[4]) * int(height)
    right = touchRight(x, instanceWidth, width)
    left = touchLeft(x, instanceWidth, width)
    up = touchUp(y, instanceHeight, height)
    down = touchDown(y, instanceHeight, height)
    
    if (right):
        if (up):
            return (8 * int(typeClass)) + 9
        else:
            if(down):
                return (8 * int(typeClass)) + 3
            else:
                return (8 * int(typeClass)) + 2

    if (down):
        if (left):
            return (8 * int(typeClass)) + 5
        else:
            return (8 * int(typeClass)) + 4
    
    if (left):
        if (up):
            return (8 * int(typeClass)) + 7
        else:
            return (8 * int(typeClass)) + 6
    
    if (up):
        return (8 * int(typeClass)) + 8

    return typeClass
    
def touchRight(x, instanceWidth, width):
    if ((float(x) + float(instanceWidth)/2) >= width * 0.99):
        return True
    else:
        return False

def touchDown(y, instanceHeight, heigth):
    if ((float(y) + float(instanceHeight)/2) >= heigth * 0.99):
        return True
    else:
        return False
        
def touchLeft(x, instanceWidth, width):
    if ((float(x) - float(instanceWidth)/2) <= width * 0.01):
        return True
    else:
        return False

def touchUp(y, instanceHeight, height):
    if ((float(y) - float(instanceHeight)/2) <= height * 0.01):
        return True
    else:
        return False

def instanceToStr(instance):
    return str(instance[0]) + " " + instance[1] + " " + instance[2] + " " + instance[3] + " " + instance[4]
