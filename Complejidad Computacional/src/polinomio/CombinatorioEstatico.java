package polinomio;

public class CombinatorioEstatico {
	
	private long[][] matriz;
	
	public CombinatorioEstatico(int n) {
		this.matriz = new long[n+1][n+1];
		this.matriz[0][0] = 1;
	}
	
	public CombinatorioEstatico() {
		this(33);
	}
	
	public long numero(int n, int k) {
		
		if ( k > n ) return 0;

		if( n >= 0 && k == 0 || n == k )
			matriz[n][0] = matriz[0][n] = 1;
		
		if( matriz[n-k][k] == 0 )
			matriz[n-k][k] = matriz[k][n-k] = numero(n-1,k-1) + numero(n-1,k);
		
		return matriz[n-k][k];
	}
	
	public long last() {
//		System.out.println("C(" + 2*(matriz.length-1) + "," + (matriz.length-1)+ ")");
		return numero(2*(matriz.length-1),matriz.length-1);
	}
	
	public void mostrar() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++)
				System.out.print(matriz[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {

		CombinatorioEstatico c = new CombinatorioEstatico();

		System.out.println(c.last());
		c.mostrar();
		
	}

}
