package backjoon_step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class BJ_2739 {
	public static void main(String[] args) throws IOException {
		int a;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		a = Integer.parseInt(reader.readLine());
		for (int i = 1; i < 10; i++) {
			writer.write(a + " * " + i + " = " + a * i + "\n");
		}
		writer.flush();
	}
}
