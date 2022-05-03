import javax.swing.JOptionPane;

public class CalculoEstatistico {

	public static void main(String[] args) 
	{
		//inicialização
		int num = Integer.parseInt(JOptionPane.showInputDialog("Informe aquantidade de pares de amostras:"));
		float x[] = new float[num], y[] = new float [num];
		
		//Atribuição
		int controle, ctrl2 = 0;
		for (controle = 0; controle < num; controle++)
		{
			ctrl2++;
			x[controle] = Float.parseFloat(JOptionPane.showInputDialog("Informe X" + ctrl2 + ": "));
			y[controle] = Float.parseFloat(JOptionPane.showInputDialog("Informe Y" + ctrl2 + ": "));
		}
		
		//Cálculo
		float somaX = 0, somaY = 0, somaXY = 0, somaXQuadrado = 0, divisao1, divisao2, a, b;
		for (controle = 0; controle < num; controle++)
		{
			somaX = x[controle] + somaX;
		}
		for (controle = 0; controle < num; controle++)
		{
			somaY = y[controle] + somaY;
		}
		for (controle = 0; controle < num; controle++)
		{
			somaXY = x[controle] * y[controle] + somaXY;
		}
		for (controle = 0; controle < num; controle++)
		{
			somaXQuadrado = (float)Math.pow(x[controle], 2) + somaXQuadrado;
		}
		divisao1 = (somaXY*num)-(somaX*somaY);
		divisao2 = (somaXQuadrado*num)-((float)Math.pow(somaX, 2));
		a = divisao1/divisao2;
		b = (somaY/num)-(a*(somaX/num));
		
		//Instanciação de x para calcular f(x) ou f(X)-¹
		float fX;
		int nCase;
		controle = 0;
		while (controle == 0)
		{
			nCase = Integer.parseInt(JOptionPane.showInputDialog("Irá calcular f(X) ou f(X)-¹? \nInsira 1 para f(X) \nInsira 0 para F(X)-¹"));
			switch (nCase)
			{
				case 1:
					fX = Float.parseFloat(JOptionPane.showInputDialog("Informe X para calcularf(X): "));
					fX = (fX*a)+ b;
					JOptionPane.showMessageDialog(null, "f(X) é = " + fX);
					break;
				case 0:
					fX = Float.parseFloat(JOptionPane.showInputDialog("Informe Y para calcularf(X)-¹: "));
					fX = (fX-b)/ a;
					JOptionPane.showMessageDialog(null, "f(X)-¹ é = " + fX);
					break;
			}
			nCase = Integer.parseInt(JOptionPane.showInputDialog("Pretende fazer um novo cálculo? \nInsira 1 para 'Sim' \nInsira 0 para 'Não':"));
			if (nCase == 0)
			{
				controle++;
			}
		}
	}
}
