package polinomio;

public class Polinomio {
	private int grado;
	private double[] coeficientes;

	public Polinomio(int g, double[] c) {
		this.grado = g;
		this.coeficientes = new double[c.length];
		
		for (int i = 0; i < c.length; i++)
			coeficientes[i] = c[i];
	}

	public double evaluarMSucesivas(double x) {

		if (this.grado < 2)
			return this.grado == 0 ? this.coeficientes[0] : x * this.coeficientes[0] + this.coeficientes[1];

		double resultado = 0;
		int multiplicaciones = this.grado;

		for (int i = 0; i < this.grado; i++, multiplicaciones--) {
			double multiplicacion = x;
			for (int j = 1; j < multiplicaciones; j++)
				multiplicacion *= x;
			resultado += multiplicacion * this.coeficientes[i];
		}

		return resultado + this.coeficientes[this.grado];
	}

	public double evaluarRecursiva(double x) {

		double resultado = 0;

		for (int i = 0; i <= this.grado; i++)
			resultado += potencia(x, i) * this.coeficientes[grado - i];

		return resultado;
	}

	private double potencia(double x, int n) {
		if (n == 0)
			return 1;

		return x * potencia(x, n - 1);
	}

	public double evaluarRecursivaPar(double x) {

		double resultado = 0;

		for (int i = 0; i <= this.grado; i++)
			resultado += potenciaParImpar(x, i) * this.coeficientes[grado - i];

		return resultado;
	}

	private double potenciaParImpar(double x, int n) {
		if (n == 0)
			return 1;

		if (n % 2 == 0)
			return potenciaParImpar(x * x, n / 2);

		return x * potenciaParImpar(x, n - 1);
	}

	public double evaluarProgDinamica(double x) {

		if (this.grado < 2)
			return this.grado == 0 ? this.coeficientes[0] : x * this.coeficientes[0] + this.coeficientes[1];

		double resultado = 0;
		double[] vector = new double[this.grado + 1];
		vector[this.grado] = 1;

		for (int i = vector.length - 2; -1 < i; i--)
			vector[i] = x * vector[i + 1];

		for (int i = this.grado; -1 < i; i--)
			resultado += this.coeficientes[i] * vector[i];

		return resultado;
	}

	public double evaluarMejorada(double x) {

		if (this.grado < 2)
			return this.grado == 0 ? this.coeficientes[0] : x * this.coeficientes[0] + this.coeficientes[1];

		double resultado = this.coeficientes[this.coeficientes.length - 1];
		double potencia = x;

		for (int i = this.grado - 1; 0 <= i; i--, potencia *= x)
			resultado += potencia * this.coeficientes[i];

		return resultado;
	}

	public double evaluarPow(double x) {

		if (this.grado < 2)
			return this.grado == 0 ? this.coeficientes[0] : x * this.coeficientes[0] + this.coeficientes[1];

		double resultado = 0;

		for (int i = 0, gradoK = this.grado; i < this.grado - 1; i++, gradoK--)
			resultado += Math.pow(x, gradoK) * this.coeficientes[i];

		return resultado + x * this.coeficientes[this.grado - 1] + this.coeficientes[this.grado];
	}

	public double evaluarHorner(double x) {
		double resultado = this.coeficientes[0];

		for (int i = 1; i < this.coeficientes.length; i++)
			resultado = resultado * x + this.coeficientes[i];

		return resultado;
	}

}
