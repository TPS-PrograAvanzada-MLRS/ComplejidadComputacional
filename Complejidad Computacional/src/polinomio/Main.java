package polinomio;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//PRUEBA DE LOS METODOS DEL PUNTO 1
		double[] c = {2,4,-1,-1,1,-1};
		Polinomio p1 = new Polinomio(5, c);
		double x = 12;
		
		long iniMSucesivas, finMSucesivas;
		long iniRecursiva, finRecursiva;
		long iniRecursivaPar, finRecursivaPar;
		long iniDinamica, finDinamica;
		long iniMejorada, finMejorada;
		long iniPow, finPow;
		long iniHorner, finHorner;
		
		System.out.println("RESULTADOS:");
		System.out.println(p1.evaluarMSucesivas(x));
		System.out.println(p1.evaluarRecursiva(x));
		System.out.println(p1.evaluarRecursivaPar(x));
		System.out.println(p1.evaluarProgDinamica(x));
		System.out.println(p1.evaluarMejorada(x));
		System.out.println(p1.evaluarPow(x));
		System.out.println(p1.evaluarHorner(x));
		System.out.println();
		
		iniMSucesivas = System.nanoTime();
		p1.evaluarMSucesivas(x);
		finMSucesivas = System.nanoTime();
		
		iniRecursiva = System.nanoTime();
		p1.evaluarRecursiva(x);
		finRecursiva = System.nanoTime();
		
		iniRecursivaPar = System.nanoTime();
		p1.evaluarRecursivaPar(x);
		finRecursivaPar = System.nanoTime();
		
		iniDinamica = System.nanoTime();
		p1.evaluarProgDinamica(x);
		finDinamica = System.nanoTime();
		
		iniMejorada = System.nanoTime();
		p1.evaluarMejorada(x);
		finMejorada = System.nanoTime();
		
		iniPow = System.nanoTime();
		p1.evaluarPow(x);
		finPow = System.nanoTime();
		
		iniHorner = System.nanoTime();
		p1.evaluarHorner(x);
		finHorner = System.nanoTime();
		
		System.out.println("Tiempo MSucesivas: " + (finMSucesivas-iniMSucesivas));
		System.out.println("Tiempo Recursiva: " + (finRecursiva-iniRecursiva));
		System.out.println("Tiempo RecursivaPar: " + (finRecursivaPar-iniRecursivaPar));
		System.out.println("Tiempo Dinamica: " + (finDinamica-iniDinamica));
		System.out.println("Tiempo Mejorada: " + (finMejorada-iniMejorada));
		System.out.println("Tiempo Pow: " + (finPow-iniPow));
		System.out.println("Tiempo Horner: " + (finHorner-iniHorner));
		
		//PRUEBA BINOMIO DE NEWTON
		System.out.println();
		int a = 1, b = 2, n = 3;
		BinomioDeNewtonEstatico binomio = new BinomioDeNewtonEstatico(a, b, n);
		
		double[] coeficientes = binomio.getCoeficientes();
		
		for( int i = 0 ; i <= n ; i++ )
			System.out.println("Coeficiente del termino " + i + " es " + binomio.getKCoeficiente(i) + " (x^" + i + ")");
		System.out.println("Vector de coeficientes: " + Arrays.toString(coeficientes));

	}

}
