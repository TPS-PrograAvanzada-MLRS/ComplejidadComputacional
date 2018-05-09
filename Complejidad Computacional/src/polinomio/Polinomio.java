package polinomio;

public class Polinomio {
	private int grado;
	private double[] coeficientes;
		
	public Polinomio(int g, double[] c) {
		this.grado = g;
		this.coeficientes = c;
	}
	
	public double evaluarMSucesivas(double x) {
		double resultado = 0;
		int cantMult = this.grado;	
		
		double independiente = this.coeficientes[this.grado];
		if(this.grado == 0)
			return independiente;
		
		double lineal = x * this.coeficientes[this.grado-1];
		if(this.grado == 1)
			return lineal + independiente;
		
		for(int i = 0; i < this.grado-1; i++, cantMult--) {
			double multSucesiva = x;
			for(int j = 1; j < cantMult; j++) 
				multSucesiva *= x;
			resultado += multSucesiva*this.coeficientes[i];
			
		}
		
		resultado += lineal + independiente;
		
		return resultado;
	}
	
	 public double evaluarRecursiva (double x) {
		 
		 double result = 0;
		 
		 for (int i = 0; i <= this.grado; i++)
			result += potencia(x, i) * this.coeficientes[grado - i];
		 
		 return result;
	 }
	 
	 private double potencia(double x, int n) {
		 if( n == 0 ) return 1;
		 
		 return x * potencia(x, n - 1);
	 }

	 public double evaluarRecursivaPar(double x) {

		 double result = 0;
		 
		 for (int i = 0; i <= this.grado; i++)
			 result +=  potenciaParImpar(x, i) * this.coeficientes[grado - i];
		 
		 return result;
	 }
	 
	 private double potenciaParImpar(double x, int n) {
		 if( n == 0 ) return 1;
		 
		 if( n % 2 == 0 ) return potenciaParImpar(x * x, n / 2);
		 
		 return x * potenciaParImpar( x, n - 1);
	 }

	
	public double evaluarProgDinamica(double x) {
		double resultado = 0;
		double potencia = 0;
		
		if(this.grado == 0)
			return this.coeficientes[0];
		
		if(this.grado == 1)
			return this.coeficientes[0]*x + this.coeficientes[1];
		
		//Evaluo desde el final del polinomio. El primer termino lo sumo directamente, el resto lo multiplico guardando el valor del termino elevado.
		for(int i = this.grado; i >= 0; i--) {
			if(potencia == 0) {
				resultado += this.coeficientes[this.coeficientes.length - 1];
				potencia++;
			}
			else {
				potencia *= x;
				resultado += potencia*this.coeficientes[i];
			}
		}
		return resultado;
	}
	
	public double evaluarMejorada(double x) {
		
		if( this.grado < 2 ) return  this.grado == 0 ? this.coeficientes[0] : x * this.coeficientes[0] + this.coeficientes[1];
		
		double resultado = x * this.coeficientes[this.coeficientes.length - 2] + this.coeficientes[this.coeficientes.length - 1];
		double potencia = x;
		
		for(int i = this.grado-2; i >= 0; i--) 
			resultado += ( potencia *= x )*this.coeficientes[i];
		
		return resultado;
	}
	
	public double evaluarPow(double x) {		//Adapto la primer funcion de sumas sucesivas
		double res = 0;
		int gradoK = this.grado;				//La utilizo para iterar en cada potencia.		
		
		if(this.grado == 0)
			return this.coeficientes[0];
		
		if(this.grado == 1)
			return this.coeficientes[0]*x + this.coeficientes[1];
		
		//Itero por cada potencia termino elevado al cuadrado o mayor en los cuales realizo multiplicaciones sucesivas.
		for(int i = 0; i < this.grado-1; i++) {
			double multSucesiva = Math.pow(x, gradoK);
			res += multSucesiva*this.coeficientes[i];
			gradoK--;
		}
		
		//Una vez que tengo calculados todos los terminos elevados, le sumo el termino lineal multiplicado por el punto a analizar, mas el termino independiente.
		res += (x*this.coeficientes[this.coeficientes.length - 2] + this.coeficientes[this.coeficientes.length - 1]);
		
		return res;
	}

	public double evaluarHorner(double x) {
		double res = this.coeficientes[0];
		
		for(int i = 1; i < this.coeficientes.length; i++) {
			res *= x;
			res += this.coeficientes[i];
		}
		
		return res;
	}


}
