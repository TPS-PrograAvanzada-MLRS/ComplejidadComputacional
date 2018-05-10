package polinomio;

import java.math.BigDecimal;
import java.util.Arrays;

public class BinomioDeNewtonDinamico {
	
	private int grado;
	private BigDecimal[] coeficientes;
	
	public BinomioDeNewtonDinamico(double a, double b, int n) {
		CombinatorioDinamico c = new CombinatorioDinamico(n);
		this.grado = n;
		this.coeficientes = new BigDecimal[grado+1];
		
		for (int i = 0; i < coeficientes.length; i++) {
			BigDecimal combinatorio = new BigDecimal(c.numero(n, i));
			this.coeficientes[i] = combinatorio.multiply(BigDecimal.valueOf(Math.pow(a, n-i) * Math.pow(b, i)));
		}
	}
	
	public BigDecimal[] getCoeficientes() {
		return this.coeficientes;
	}
	
	public BigDecimal getKCoeficiente(int k) {
		return this.coeficientes[this.grado-k];
	}
	
	public int getGrado() {
		return this.grado;
	}

	public static void main(String[] args) {
		
		int n = 200;
		double a = 2, b = 3;
		long tini, tfin;
		
		tini = System.nanoTime();
		BinomioDeNewtonDinamico binomio = new BinomioDeNewtonDinamico(a, b, n);
		tfin = System.nanoTime();
		System.out.println("timeBDN = " + (tfin-tini));
		
		for( int i = 0 ; i <= n ; i++ )
			System.out.println("Coeficiente del termino " + i + " (x^" + i + ")" + " es " + binomio.getKCoeficiente(i));
		System.out.println("Vector de coeficientes: " + Arrays.toString(binomio.getCoeficientes()));

	}

}
