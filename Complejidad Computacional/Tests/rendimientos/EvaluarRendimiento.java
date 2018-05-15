package rendimientos;

import polinomio.Polinomio;
import polinomio.BinomioDeNewtonEstatico;
import polinomio.BinomioDeNewtonDinamico;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class EvaluarRendimiento {

	public static void evaluarBinomioDeNewtonDinamico() {
		long tInicial = 0;
		long tTotal = 0;
		long tTotalIndividual = 0;
		BinomioDeNewtonDinamico newtonD;
		Random rand = new Random();
		for (int j = 0; j < 10; j++) {

			int potencia = 1;
			newtonD = new BinomioDeNewtonDinamico(rand.nextDouble() + rand.nextInt(100),
					rand.nextDouble() + rand.nextInt(100), potencia);

			tInicial = System.currentTimeMillis();
			for (int i = 0; i < 1000000; i++)
				newtonD.getKCoeficiente(Math.abs(rand.nextInt(potencia)));
			tTotalIndividual = System.currentTimeMillis() - tInicial;
			tTotal += tTotalIndividual;
		}
	}

	public void evaluarBinomioDeNewtonEstatico() {
		long tInicial = 0;
		long tTotal = 0;
		long tTotalIndividual = 0;
		BinomioDeNewtonEstatico newtonE;
		Random rand = new Random();

		for (int j = 0; j < 10; j++) {

			// creo el binomio a probar
			int potencia = 4;
			newtonE = new BinomioDeNewtonEstatico(rand.nextDouble() + rand.nextInt(10),
					rand.nextDouble() + rand.nextInt(10), potencia);

			tInicial = System.currentTimeMillis();
			for (int i = 0; i < 1000000; i++)
				newtonE.getKCoeficiente(Math.abs(rand.nextInt(potencia)));
			tTotalIndividual = System.currentTimeMillis() - tInicial;
			tTotal += tTotalIndividual;
			System.out.println("Tiempo de pasada " + (j + 1) + ": " + tTotalIndividual);
		}
		System.out.println("promedio " + tTotal / 10);
	}

	private static double evaluarHornerRendimiento(int size) {
		long tInicial = 0;
		long tTotal = 0;
		Random rand = new Random();
		double[] coeficientes = new double[size];
		Polinomio poli;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < coeficientes.length; j++)
				coeficientes[j] = rand.nextDouble() * rand.nextInt(100);
			poli = new Polinomio(coeficientes.length - 1, coeficientes);
			tInicial = System.currentTimeMillis();
			for (int k = 0; k < 1000000; k++)
				poli.evaluarHorner(rand.nextDouble() * rand.nextInt(100));
			tTotal += System.currentTimeMillis() - tInicial;
		}
		return tTotal / 10;
	}

	public static double evaluarPowRendimiento(int size) {
		long tInicial = 0;
		long tTotal = 0;
		Random rand = new Random();
		double[] coeficientes = new double[size];
		Polinomio poli;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < coeficientes.length; j++)
				coeficientes[j] = rand.nextDouble() * rand.nextInt(100);
			poli = new Polinomio(coeficientes.length - 1, coeficientes);

			tInicial = System.currentTimeMillis();
			for (int k = 0; k < 1000000; k++)
				poli.evaluarPow(rand.nextDouble() * rand.nextInt(100));
			tTotal += System.currentTimeMillis() - tInicial;
		}
		return tTotal / 10;
	}

	public static double evaluarMejoradaRendimiento(int size) {
		long tInicial = 0;
		long tTotal = 0;
		Random rand = new Random();
		double[] coeficientes = new double[size];
		Polinomio poli;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < coeficientes.length; j++)
				coeficientes[j] = rand.nextDouble() * rand.nextInt(100);
			poli = new Polinomio(coeficientes.length - 1, coeficientes);

			tInicial = System.currentTimeMillis();
			for (int k = 0; k < 1000000; k++)
				poli.evaluarMejorada(rand.nextDouble() * rand.nextInt(100));
			tTotal += System.currentTimeMillis() - tInicial;
		}
		return tTotal / 10;
	}

	public static double evaluarProgDinamicaRendimiento(int size) {
		long tInicial = 0;
		long tTotal = 0;
		Random rand = new Random();
		double[] coeficientes = new double[size];
		Polinomio poli;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < coeficientes.length; j++)
				coeficientes[j] = rand.nextDouble() * rand.nextInt(100);
			poli = new Polinomio(coeficientes.length - 1, coeficientes);

			tInicial = System.currentTimeMillis();
			for (int k = 0; k < 1000000; k++)
				poli.evaluarProgDinamica(rand.nextDouble() * rand.nextInt(100));
			tTotal += System.currentTimeMillis() - tInicial;
		}
		return tTotal / 10;
	}

	public static double evaluarRecursivaParRendimiento(int size) {
		long tInicial = 0;
		long tTotal = 0;
		Random rand = new Random();
		double[] coeficientes = new double[size];
		Polinomio poli;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < coeficientes.length; j++)
				coeficientes[j] = rand.nextDouble() * rand.nextInt(100);
			poli = new Polinomio(coeficientes.length - 1, coeficientes);

			tInicial = System.currentTimeMillis();
			for (int k = 0; k < 1000000; k++)
				poli.evaluarRecursivaPar(rand.nextDouble() * rand.nextInt(100));
			tTotal += System.currentTimeMillis() - tInicial;
		}
		return tTotal / 10;
	}

	public static double evaluarRecursivaRendimiento(int size) {
		long tInicial = 0;
		long tTotal = 0;
		Random rand = new Random();
		double[] coeficientes = new double[size];
		Polinomio poli;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < coeficientes.length; j++)
				coeficientes[j] = rand.nextDouble() * rand.nextInt(100);
			poli = new Polinomio(coeficientes.length - 1, coeficientes);

			tInicial = System.currentTimeMillis();
			for (int k = 0; k < 1000000; k++)
				poli.evaluarRecursiva(rand.nextDouble() * rand.nextInt(100));
			tTotal += System.currentTimeMillis() - tInicial;
		}
		return tTotal / 10;
	}

	public static double evaluarMSucesivasRendimiento(int size) {
		long tInicial = 0;
		long tTotal = 0;
		Random rand = new Random();
		double[] coeficientes = new double[size];
		Polinomio poli;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < coeficientes.length; j++)
				coeficientes[j] = rand.nextDouble() * rand.nextInt(100);
			poli = new Polinomio(coeficientes.length - 1, coeficientes);

			tInicial = System.currentTimeMillis();
			for (int k = 0; k < 1000000; k++)
				poli.evaluarMSucesivas(rand.nextDouble() * rand.nextInt(100));
			tTotal += System.currentTimeMillis() - tInicial;
		}
		return tTotal / 10;
	}

	public static void main(String args[]) { 
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("rendimientoAlgoritmos.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String elver = "Grado Polinomio,Horner,Mejorada,Multiplicacion,Pow,ProgDinamica,RecursivaPar,Recursiva\n";

		int gradoPoli;
		for (gradoPoli = 100; gradoPoli < 101; gradoPoli++) {
			System.out.println("Evaluando polinomios de grado " + gradoPoli);
			elver += gradoPoli + "," + evaluarHornerRendimiento(gradoPoli) + "," + evaluarMejoradaRendimiento(gradoPoli)
					+ "," + evaluarMSucesivasRendimiento(gradoPoli) + "," + evaluarPowRendimiento(gradoPoli) + ","
					+ evaluarProgDinamicaRendimiento(gradoPoli) + "," + evaluarRecursivaParRendimiento(gradoPoli) + ","
					+ evaluarRecursivaRendimiento(gradoPoli) + "\n";
		}

		writer.write(elver);
		writer.close();
	}
}