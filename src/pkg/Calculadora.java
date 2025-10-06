package pkg;

public class Calculadora {
	
	public static int sumar(int a, int b) {
		return a + b;
	}

	public static int restar(int a, int b) {
		return a - b;
	}

	public static int multiplicar(int a, int b) {
		return a * b;
	}

	public static int divide(int a, int b) {
		if (b == 0) {
			return -1;
		} else {
			return a / b;
		}
	}
}
