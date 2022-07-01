package 문자열클래스만들기;

public class MyStringTest {

	public static void main(String[] args) {
		char compare[] = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd' , '!'};
		char text[] = { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd' , '!'};
		MyString myString = new MyString(text);
		MyString compareString = new MyString(compare);
		
		System.out.print("mystring.toCharArray() : ");
		System.out.println(myString.toCharArray());
		
		System.out.print("mystring.toCharArray()[0] : ");
		System.out.println(myString.toCharArray()[0]);
		
		System.out.print("mystring.length() : ");
		System.out.println(myString.length());
		
		System.out.print("mystring.subString() : ");
		System.out.println(myString.subString(6, 11).toCharArray());
		
		System.out.print("mystring.charAt() : ");
		System.out.println(myString.charAt(0));
		System.out.print("mystring.charAt() : ");
		System.out.println(myString.charAt(1));
		
		//myString 클래스의 equals 메소드는 MyString 타입의 문자형 배열을 비교할 수 있음
		System.out.print("mystring.equals() : ");
		System.out.println(myString.equals(compareString)); 
		
	}
}
