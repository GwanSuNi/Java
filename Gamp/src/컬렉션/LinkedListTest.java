package 컬렉션;

import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListTest {

	public static void main(String[] args) throws Exception {
		// 기본 경로는 프로젝트 최상위
		Scanner scanner = new Scanner(new FileReader("name.txt"));
		LinkedList<String> list = new LinkedList<String>();

		while (scanner.hasNext()) {
			String name = scanner.nextLine();
//			System.out.println(name);
			list.add(name);
		}
		scanner.close();
		
		printListItems(list);
	}
	
	public static void printListItems(LinkedList<String> list) {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
