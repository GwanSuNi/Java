package com.java.ex;

import java.util.Random;

public class VoteThread implements Runnable {

	int target = 100;
	int sum = 0;
	Random rd = new Random();

	@Override
	public void run() {
		StringBuffer sb = new StringBuffer();

		while (true) {
			sum = sum + rd.nextInt(10);
			sb.delete(0, sb.toString().length());

			if (sum >= target) {
				sum = 100;
				for (int i = 0; i < sum; i++) {
					sb.append('*');
				}
				System.out.println(Thread.currentThread().getName() + "개표율: " + sum + "%\t: " + sb + "\t1위: 박남일");
				break;
			} else {
				for (int i = 0; i < sum; i++) {
					sb.append('*');
				}
				System.out.println(Thread.currentThread().getName() + "개표율: " + sum + "%\t: " + sb);
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
