package backjoon_step2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BJ_2525 {
	public static void main(String[] args) throws IOException {
		int hour, min, time, total;
		String input;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		input = reader.readLine();
		time = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(input);
		hour = Integer.parseInt(tokenizer.nextToken());
		min = Integer.parseInt(tokenizer.nextToken());
		total = min + time;
		if (total >= 60) { // 총 분이 60을 넘어갔을 시
			int h = total / 60;
			hour += h;
			min = total - 60 * h;
		} else { // 총 시간이 60분을 넘지 않으면 소요시간을 바로 더하면 됨
			min += time;
		}
		if (hour >= 24) // 24시 순환
			hour = hour % 24;
		writer.write(hour + " " + min);
		writer.flush();
	}
}

/* 더 짧은 풀이법 16_000 KB 148ms 551 B 
 * 내 풀이는     16_244 KB 144ms 932 B
 * 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int h = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(br.readLine()); 
    
    h += (m+c)/60;
    m = (m+c)%60;

    h = h%24;
    System.out.println(h +" "+ m);

	}
}
*/
