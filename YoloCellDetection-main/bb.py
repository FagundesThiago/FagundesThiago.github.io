import cv2

def desenhaBoundingBox(rotulosParaTreinamentoYolo, pastaDeDestinoDasImagens, imagemDoFundo, arquivoDoFundo):
    imagemBoundingBox = imagemDoFundo.copy()
    for rotulo in rotulosParaTreinamentoYolo:
        larguraBox = int(rotulo[3] * imagemDoFundo.shape[1])
        alturaBox = int(rotulo[4] * imagemDoFundo.shape[0])
        posicaoXbox = int((rotulo[1] * imagemDoFundo.shape[1]) - (larguraBox / 2))
        posicaoYbox = int((rotulo[2] * imagemDoFundo.shape[0]) - (alturaBox / 2))
        if (rotulo[0] == "0"):
            cor = (255,0,0)
        elif (rotulo[0] == "1"):
            cor = (0,255,0)
        elif (rotulo[0] == "2"):
            cor = (0,0,255)
        elif (rotulo[0] == "3"):
            cor = (255,255,0)
        elif (rotulo[0] == "4"):
            cor = (0,255,255)
        elif (rotulo[0] == "5"):
            cor = (255,255,255)
        cv2.rectangle(imagemBoundingBox, (posicaoXbox, posicaoYbox), (posicaoXbox + larguraBox, posicaoYbox + alturaBox), cor, 1)
    cv2.imwrite(pastaDeDestinoDasImagens + "BOX" + arquivoDoFundo, imagemBoundingBox)