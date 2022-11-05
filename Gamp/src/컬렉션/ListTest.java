package 컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTest {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		ArrayList<String> arrayList = null;
				
		//	일반적인 방법으로 초기화
		arrayList = new ArrayList<String>();
		arrayList.add("햄버거");
		arrayList.add("피자");
		arrayList.add("도넛");
		arrayList.add("핫도그");
		System.out.println(arrayList);
		
		//	Arrays.asList()로 초기화
		arrayList = new ArrayList<String>(Arrays.asList("햄버거", "피자", "도넛", "핫도그"));
		System.out.println(arrayList);
		
		//	Multi Brace Initialization을 이용해 초가화
		arrayList = new ArrayList<String>() {{
			add("햄버거");
			add("피자");
			add("도넛");
			add("핫도그");
		}};
		System.out.println(arrayList);
		
		//	Stream으로 초기화
		String[] arr = new String[] {"햄버거", "피자", "도넛", "핫도그"};
		arrayList = new ArrayList<String>(Stream.of(arr).collect(Collectors.toList()));
		System.out.println(arrayList);
		
		System.out.println(arrayList.size());
		
	}
}
