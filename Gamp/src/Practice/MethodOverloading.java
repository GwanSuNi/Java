package Practice;

public class MethodOverloading {

	static void add(int a, int b) {
		System.out.println("int");
	}

	static void add(long a, long b) {
		System.out.println("long");
	}

	public static void main(String[] args) {
		add(3, 3);
		add(3, 3l);
		add(3l, 3);
	}

}
