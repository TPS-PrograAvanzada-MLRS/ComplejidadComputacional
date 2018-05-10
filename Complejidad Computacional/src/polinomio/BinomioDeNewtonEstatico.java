package polinomio;

import java.util.Arrays;

public class BinomioDeNewtonEstatico{
	
	private int grado;
	private double[] coeficientes;
	
	public BinomioDeNewtonEstatico(double a, double b, int n) {
		CombinatorioEstatico combinatorio = new CombinatorioEstatico(n);
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
	
	public int getGrado() {
		return this.grado;
	}

	public static void main(String[] args) {
		
		int n = 4;
		double a = 1, b = 1;
		long tini, tfin;
		
		tini = System.nanoTime();
		BinomioDeNewtonEstatico binomio = new BinomioDeNewtonEstatico(a, b, n);
		tfin = System.nanoTime();
		System.out.println("timeBDN = " + (tfin-tini));
		
		for( int i = 0 ; i <= n ; i++ )
			System.out.println("Coeficiente del termino " + i + " (x^" + i + ")" + " es " + binomio.getKCoeficiente(i) );
		System.out.println("Vector de coeficientes: " + Arrays.toString(binomio.getCoeficientes()));
		
		Polinomio polinomio = new Polinomio(binomio.getGrado(), binomio.getCoeficientes());
		
		double x = 5;
		double resultado;
		
		tini = System.nanoTime();
		resultado = polinomio.evaluarMSucesivas(x);
		tfin = System.nanoTime();
		System.out.println("p(" + x + ") = " + resultado + " timeMSucesivas = " + (tfin-tini));
		
		tini = System.nanoTime();
		resultado = polinomio.evaluarRecursiva(x);
		tfin = System.nanoTime();
		System.out.println("p(" + x + ") = " + resultado + " timeRecursiva = " + (tfin-tini));
		
		tini = System.nanoTime();
		resultado = polinomio.evaluarRecursivaPar(x);
		tfin = System.nanoTime();
		System.out.println("p(" + x + ") = " + resultado + " timeRecursivaPar = " + (tfin-tini));
		
		tini = System.nanoTime();
		resultado = polinomio.evaluarProgDinamica(x);
		tfin = System.nanoTime();
		System.out.println("p(" + x + ") = " + resultado + " timeProgDinamica = " + (tfin-tini));
		
		tini = System.nanoTime();
		resultado = polinomio.evaluarMejorada(x);
		tfin = System.nanoTime();
		System.out.println("p(" + x + ") = " + resultado + " timeMejorada = " + (tfin-tini));
		
		tini = System.nanoTime();
		resultado = polinomio.evaluarPow(x);
		tfin = System.nanoTime();
		System.out.println("p(" + x + ") = " + resultado + " timePow = " + (tfin-tini));
		
		tini = System.nanoTime();
		resultado = polinomio.evaluarHorner(x);
		tfin = System.nanoTime();
		System.out.println("p(" + x + ") = " + resultado + " timeHorner = " + (tfin-tini));
	}
}