package polinomio;

public class Polinomio {
	private int grado;
	private double[] coeficientes;

	public Polinomio(int g, double[] c) {
		this.grado = g;
		this.coeficientes = c;
	}

	public double evaluarMSucesivas(double x) {

		if (this.grado < 2)
			return this.grado == 0 ? this.coeficientes[0] : x * this.coeficientes[0] + this.coeficientes[1];

		double resultado = 0;
		int cantMult = this.grado;

		double independiente = this.coeficientes[this.grado];
		double lineal = x * this.coeficientes[this.grado - 1];

		for (int i = 0; i < this.grado - 1; i++, cantMult--) {
			double multSucesiva = x;
			for (int j = 1; j < cantMult; j++)
				multSucesiva *= x;
			resultado += multSucesiva * this.coeficientes[i];

		}

		resultado += lineal + independiente;

		return resultado;
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

		double resultado = x * this.coeficientes[this.coeficientes.length - 2]
				+ this.coeficientes[this.coeficientes.length - 1];
		double potencia = x * x;

		for (int i = this.grado - 2; 0 <= i; i--, potencia *= x)
			resultado += potencia * this.coeficientes[i];

		return resultado;
	}

	public double evaluarPow(double x) {

		if (this.grado < 2)
			return this.grado == 0 ? this.coeficientes[0] : x * this.coeficientes[0] + this.coeficientes[1];

		double resultado = 0;
		double independiente = this.coeficientes[this.grado];
		double lineal = x * this.coeficientes[this.grado - 1];

		for (int i = 0, gradoK = this.grado; i < this.grado - 1; i++, gradoK--)
			resultado += Math.pow(x, gradoK) * this.coeficientes[i];

		resultado += lineal + independiente;

		return resultado;
	}

	public double evaluarHorner(double x) {
		double resultado = this.coeficientes[0];

		for (int i = 1; i < this.coeficientes.length; i++) {
			resultado *= x;
			resultado += this.coeficientes[i];
		}

		return resultado;
	}

}
