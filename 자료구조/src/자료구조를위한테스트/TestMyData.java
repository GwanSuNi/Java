package 자료구조를위한테스트;

public class TestMyData {

	public static void main(String[] args) {
		// <클래스타입만 가능>
		MyData<Integer> myData1 = new MyData<Integer>(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		MyData<String> myData2 = new MyData<String>(new String[] { "Apple", "Mango", "Peach" });
		
		myData1.printData();
		myData2.printData();
	}

}
