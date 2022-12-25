package backjoon_step2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BJ_2884 {
	// BJ_2884_1 Scanner 사용과 비교
	// Scanner 18_548 KB 232ms 378 B
	// Buffer  16_128 KB 152ms 842 B
	public static void main(String[] args) throws IOException {
		int hour, min;
		String input;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		input = reader.readLine();
		StringTokenizer tokenizer = new StringTokenizer(input);
		hour = Integer.parseInt(tokenizer.nextToken());
		min = Integer.parseInt(tokenizer.nextToken());
		
		if (min < 45) {
			if (hour == 0) {
				hour = 23;
			} else {
				--hour;
			}
			min = 60 - (45 - min);
		} else {
			min -= 45;
		}
		writer.write(hour + " " + min);
		writer.flush();
	}

}
