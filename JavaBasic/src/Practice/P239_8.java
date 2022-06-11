package Practice;

class Power {
	private int kick; // 생성자 사용할 때 디폴트? setter 사용하면 private
	private int punch;
	
	Power() {
		this(0, 0);
	}
	Power(int kick) {
		this(kick, 0);
	}
	Power(int kick, int punch) {
		this.kick = kick;
		this.punch = punch;
		System.out.printf("%d %d\n", this.kick, this.punch);
	}
}

public class P239_8 {
	public static void main(String[] args) {
		Power robot = new Power(10, 20);
		// setter 사용했을 때
		// setKick(10); setPunch(20);
	}
}
