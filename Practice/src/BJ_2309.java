import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;

class BJ_2309 {
	public static void main(String[] args) throws IOException {
		int sum = 0;
		Vector<Integer> inputs = new Vector<Integer>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			inputs.add(Integer.parseInt(reader.readLine()));
			sum += inputs.get(i);
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (inputs.get(i) + inputs.get(j) == sum - 100) {
					inputs.remove(j);
					inputs.remove(i);
					Object[] outputs = inputs.toArray();
					Arrays.sort(outputs);
					for (int k = 0; k < 7; k++) {
						System.out.println(outputs[k]);
					}
					return;
				}
			}
		}
	}
}

//		Vector<Integer> inputs = new Vector<Integer>();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//		for (int i = 0; i < 9; i++) {
//			inputs.add(Integer.parseInt(reader.readLine()));
//		}
//		Object[] outputs = inputs.toArray();
//		Arrays.sort(outputs);
//		
//		
//		Vector<Integer> vector = new Vector<Integer>();
//		for (int i = 0; i < 9; i++) {
//			vector.add((Integer) outputs[i]);
//		}
//
//		for (int i = 0; i < 8; i++) {
//			for (int j = i + 1; j < 9; j++) {
//				if (vector.get(i) + vector.get(j) == 40) {
//					vector.remove(j);
//					vector.remove(i);
//					for (int k = 0; k < 7; k++) {
//						System.out.println(vector.get(k));
//					}
//					return;
//				}
//			}
//		}

// 윤우식 풀이
//public static void main(String[] args) throws IOException {
//	Queue<Integer> queue = new LinkedList<Integer>();
//	Stack<Integer> stack = new Stack<Integer>();
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//	for (int i = 0; i < 9; i++) {
//		queue.offer(Integer.parseInt(br.readLine()));
//	}
//
//	for (int i = 0; i < queue.size(); i++) {
//		stack.push(queue.poll());
//		stack.push(queue.poll());
//
//		for (int j = 0; j < queue.size(); j++) {
//			int sum = 0;
//			for (int item : queue)
//				sum += item;
//
//			if (sum == 100) {
//				Collections.sort((LinkedList<Integer>) queue);
//				for (int item : queue) {
//					bw.write(Integer.toString(item));
//					bw.newLine();
//					bw.flush();
//				}
//
//				br.close();
//				bw.close();
//				return;
//			}
//
//			queue.offer(stack.pop());
//			stack.push(queue.poll());
//		}
//
//		queue.offer(stack.pop());
//		queue.offer(stack.pop());
//	}
//	
//	br.close();
//	bw.close();
//}