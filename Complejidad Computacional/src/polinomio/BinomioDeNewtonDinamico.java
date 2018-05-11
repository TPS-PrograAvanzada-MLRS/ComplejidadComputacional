package polinomio;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class BinomioDeNewtonDinamico {

	private int grado;
	private BigDecimal[] coeficientes;

	public BinomioDeNewtonDinamico(double a, double b, int n) {
		PascalBigInteger c = new PascalBigInteger(n);
		this.grado = n;
		this.coeficientes = new BigDecimal[n + 1];

		BigInteger[] combinatorios = c.numeros(n);
		BigDecimal[] potenciasDeA = new BigDecimal[n + 1];
		BigDecimal[] potenciasDeB = new BigDecimal[n + 1];

		potenciasDeB[0] = potenciasDeA[n] = BigDecimal.valueOf(1);

		for (int i = 0; i < n; i++) {
			potenciasDeA[n - i - 1] = potenciasDeA[n - i].multiply(BigDecimal.valueOf(a));
			potenciasDeB[i + 1] = potenciasDeB[i].multiply(BigDecimal.valueOf(b));
		}

		for (int i = 0; i < coeficientes.length; i++)
			this.coeficientes[i] = ( new BigDecimal(combinatorios[i]) ).multiply( potenciasDeA[i].multiply(potenciasDeB[i]) );
	}

	public BigDecimal[] getCoeficientes() {
		return this.coeficientes;
	}

	public BigDecimal getKCoeficiente(int k) {
		return this.coeficientes[this.grado - k];
	}

	public int getGrado() {
		return this.grado;
	}

	public static void main(String[] args) {

		int n = 100;
		double a = 0.2, b = 1.07;

		long tini = System.currentTimeMillis();
		BinomioDeNewtonDinamico binomio = new BinomioDeNewtonDinamico(a, b, n);
		long tfin = System.currentTimeMillis();

		for (int i = 0; i <= n; i++)
			System.out.println(" x^" + i + " * " + binomio.getKCoeficiente(i));
		System.out.println("\n Vector de coeficientesC: " + Arrays.toString(binomio.getCoeficientes()));
		System.out.println("\n Time = " + (tfin - tini));

	}

}
