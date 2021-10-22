package wyklad._07wyjatki;
class Exc5 {
	public static void main(String[] args) {
		try {
			int a = 5;
			System.out.println("a = " + a);
			int b = 2 / a;
			int c[] = { 1, 2 };
			c[b] = 99;
		} catch (ArithmeticException e) {
			System.out.println("Dzielenie przez 0: " + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Indeks tablicy poza zakresem: " + e);
		}
		System.out.println("Poza try/catch");
	}
}

