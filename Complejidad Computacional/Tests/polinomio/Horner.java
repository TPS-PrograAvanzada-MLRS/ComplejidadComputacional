package polinomio;
import org.junit.Assert;
import org.junit.Test;

import polinomio.Polinomio;

public class Horner {
	
	@Test
	public void Grado0() {
		double[]coeficientes = {2};
		Polinomio polinomio = new Polinomio(0, coeficientes);
		Assert.assertEquals(2, polinomio.evaluarHorner(2), 0);
	}
	
	@Test
	public void Grado1() {
		double[]coeficientes = {3,2};
		Polinomio polinomio = new Polinomio(1, coeficientes);
		Assert.assertEquals(8, polinomio.evaluarHorner(2), 0);
	}
	
	@Test
	public void Grado3() {
		double[]coeficientes = {-2,7,3,2};
		Polinomio polinomio = new Polinomio(3, coeficientes);
		Assert.assertEquals(20, polinomio.evaluarHorner(2), 0);
	}
	
	@Test
	public void Grado6() {
		double[]coeficientes = {-5,-3,0,-2,7,3,2};
		Polinomio polinomio = new Polinomio(6, coeficientes);
		Assert.assertEquals(-396, polinomio.evaluarHorner(2), 0);
	}
	
	@Test
	public void Grado20() {
		double[]coeficientes = {7,3,1,-4,10,-3,-2,5,-2,6,
								-5,8,-5,0,-5,-3,0,-2,7,3,
								2};
		Polinomio polinomio = new Polinomio(20, coeficientes);
		Assert.assertEquals(9217396, polinomio.evaluarHorner(2), 0);
	}
	
	@Test
	public void Grado30() {
		double[]coeficientes = {4,4,-2,-7,-5,0,-6,-2,-4,7,
								7,3,1,-4,10,-3,-2,5,-2,6,
								-5,8,-5,0,-5,-3,0,-2,7,3,
								2};
		Polinomio polinomio = new Polinomio(30, coeficientes);
		Assert.assertEquals(4.5201913480E9, polinomio.evaluarHorner(2), 0);
	}
	
	@Test
	public void Grado40() {
		double[]coeficientes = {3,1,4,5,0,-2,4,-5,-9,1,
								4,4,-2,-7,-5,0,-6,-2,-4,7,
								7,3,1,-4,10,-3,-2,5,-2,6,
								-5,8,-5,0,-5,-3,0,-2,7,3,
								2};
		Polinomio polinomio = new Polinomio(40, coeficientes);
		Assert.assertEquals(5.560060388724E12, polinomio.evaluarHorner(2), 0);
	}
	
	@Test
	public void Grado50() {
		double[]coeficientes = {1,2,-4,0,6,-3,-2,-6,-5,1,
								3,1,4,5,0,-2,4,-5,-9,1,
								4,4,-2,-7,-5,0,-6,-2,-4,7,
								7,3,1,-4,10,-3,-2,5,-2,6,
								-5,8,-5,0,-5,-3,0,-2,7,3,
								2};
		Polinomio polinomio = new Polinomio(50, coeficientes);
		Assert.assertEquals(1.340367176508788E15, polinomio.evaluarHorner(2), 0);
	}

}
