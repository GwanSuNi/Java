package Practice;

public class P308_1 {
	class A {
		private int a;

		public void set(int a) {
			this.a = a;
		}
	}

	class B extends A {
		protected int b, c;
	}

	class C extends B {
		public int d, e;
	}
 
	class D extends C {
		public void f() {
			//a = 1;
			set(10);
			b = 20;
			d = 30;
		}
	}
	
	public void main(String[] args) {
		A objA = new A(); // 교재에선 이걸 왜 new objA() ??? 클래스 명이 동일하지 않다 
	}
}
