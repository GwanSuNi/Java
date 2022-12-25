package backjoon_step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ_2480 {

	public static void main(String[] args) throws IOException {
		int a, b, c;
		int reward = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
		a = Integer.parseInt(tokenizer.nextToken());
		b = Integer.parseInt(tokenizer.nextToken());
		c = Integer.parseInt(tokenizer.nextToken());

		if (a == b && b == c && a == c)
			reward = 10_000 + a * 1_000;
		else if (a == b)
			reward = 1_000 + a * 100;
		else if (a == c)
			reward = 1_000 + a * 100;
		else if (b == c)
			reward = 1_000 + b * 100;
		else {
			int max = Math.max(Math.max(a, b), c);
			reward = max * 100;
		}
		System.out.println(reward);
	}

}
