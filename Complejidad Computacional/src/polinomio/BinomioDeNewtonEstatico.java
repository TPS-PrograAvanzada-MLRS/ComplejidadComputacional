package polinomio;

import java.util.Arrays;

public class BinomioDeNewtonEstatico {
	
	private int grado;
	private double[] coeficientes;
	
	public BinomioDeNewtonEstatico(int a, int b, int n) {
		CombinatorioEstatico combinatorio = new CombinatorioEstatico();
		this.grado = n;
		this.coeficientes = new double[grado + 1];
		
		for (int i = 0; i < this.coeficientes.length; i++)
			this.coeficientes[i] = combinatorio.numero(n, i) * Math.pow(a, n-i) * Math.pow(b, i);
	}
	
	public double[] getCoeficientes() {
		return this.coeficientes;
	}
	
	public double getKCoeficiente(int k) {
		return this.coeficientes[this.grado-k];
	}

	public static void main(String[] args) {
		
		int a = 1, b = 2, n = 3;
		BinomioDeNewtonEstatico binomio = new BinomioDeNewtonEstatico(a, b, n);
		
		double[] coeficientes = binomio.getCoeficientes();
		
		for( int i = 0 ; i <= n ; i++ )
			System.out.println("Coeficiente del termino " + i + " es " + binomio.getKCoeficiente(i) + " (x^" + i + ")");
		System.out.println("Vector de coeficientes: " + Arrays.toString(coeficientes));
		
	}
}