package backjoon_step2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.io.OutputStreamWriter;

class BJ_14681 {

	public static void main(String[] args) throws IOException {
		int x, y, result;
//		Scanner scanner = new Scanner(System.in);
//		x = scanner.nextInt();
//		y = scanner.nextInt();
//		scanner.close();
//		
//		if (x >= 0) {
//			if (y >= 0)
//				result = 1;
//			else
//				result = 4;
//		} else {
//			if (y >= 0)
//				result = 2;
//			else
//				result = 3;
//		}
//		System.out.println(result);
		
		// 실행속도 개선
		// Scanner 사용 시 메모리 17_660 KB 실행시간 204ms 코드 길이 370 B
		// Buffer 사용 시 메모리 14_624 KB 실행시간 144ms 코드 길이 695 B
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		x = Integer.parseInt(reader.readLine());
		y = Integer.parseInt(reader.readLine());
		
		if (x >= 0) {
			if (y >= 0)
				result = 1;
			else
				result = 4;
		} else {
			if (y >= 0)
				result = 2;
			else
				result = 3;
		}
		writer.write(result + "\n");
		writer.flush();
	}
}
