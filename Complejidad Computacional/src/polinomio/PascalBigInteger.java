package polinomio;

import java.math.BigInteger;
import java.util.Arrays;

public class PascalBigInteger {

	private BigInteger[][] vector;

	public PascalBigInteger(int n) {
		vector = new BigInteger[n + 1][];

		for (int i = 0; i < vector.length; i++) {
			vector[i] = new BigInteger[i + 1];
			vector[i][0] = vector[i][i] = BigInteger.valueOf(1);
		}

		for (int i = 2; i < vector.length; i++) {
			vector[i][1] = vector[i][i - 1] = BigInteger.valueOf(i);

			if (i % 2 == 0)
				vector[i][i / 2] = vector[i - 1][i / 2 - 1].add( vector[i - 1][i / 2] );

			for (int j = 2; j <= i / 2; j++)
				vector[i][j] = vector[i][i - j] = vector[i - 1][j - 1].add( vector[i - 1][j] );
		} 
	}

	public BigInteger[] numeros(int n) {
		return vector[n];
	}

	public BigInteger numero(int n, int k) {
		return vector[n][k];
	}

	public void mostrar() {
		for (int i = 0; i < vector.length; i++) {
			System.out.print("" + i + ": ");
			for (int j = 0; j < vector[i].length; j++)
				System.out.print(vector[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int cant = 3;
		PascalBigInteger p = new PascalBigInteger(cant);

//		p.mostrar();

		for (int i = 0; i < cant+1; i++)
			System.out.println(Arrays.toString(p.numeros(i)));
		
//		for (int i = 0; i < cant+1; i++) {
//			System.out.println();
//			for (int j = 0; j < i + 1; j++)
//				System.out.println("C(" + i + "," + j + ") = " + p.numero(i, j));
//		}

	}

}
