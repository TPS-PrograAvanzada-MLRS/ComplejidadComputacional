package polinomio;

public class Pascal {

	private int[][] vector;

	public Pascal(int n) {
		vector = new int[n + 1][];

		for (int i = 0; i < vector.length; i++) {
			vector[i] = new int[i + 1];
			vector[i][0] = vector[i][i] = 1;
		}

		for (int i = 2; i < vector.length; i++) {
			vector[i][1] = vector[i][i - 1] = i;

			if (i % 2 == 0)
				vector[i][i / 2] = vector[i - 1][i / 2 - 1] + vector[i - 1][i / 2];

			for (int j = 2; j <= i / 2; j++)
				vector[i][j] = vector[i][i - j] = vector[i - 1][j - 1] + vector[i - 1][j];
		}
	}

	public int[] numeros(int n) {
		return vector[n];
	}

	public int numero(int n, int k) {
		return vector[n][k];
	}

	public void mostrar() {
		for (int i = 0; i < vector.length; i++) {
			System.out.print("" + (i / 10) + (i % 10) + ": ");
			for (int j = 0; j < vector[i].length; j++)
				System.out.print(vector[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Pascal p = new Pascal(10);

		p.mostrar();

		System.out.println(p.numero(8, 3));

		for (int i = 0; i < 10; i++) {
			System.out.println();
			for (int j = 0; j < i + 1; j++)
				System.out.println("C(" + i + "," + j + ") = " + p.numero(i, j));
		}

	}

}
