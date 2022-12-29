package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * 그래프가 다음과 같이 주어졌을 때 출발점 s에서 도착점 e까지 갈 수 있는 경로의 개수를 구하라
 * graph 구성
 * 1 - 2, 3
 * 2 - 5
 * 3 - 4
 * 4 - 2, 5
 */
public class 경로경우의수구하기 {
	static ArrayList<ArrayList<Integer>> graph;
	static int pathCount = 0;

	public static void main(String[] args) {
		int from = 1, to = 5;
		buildGraph();
		printGraph(graph);
		findAllPath(from, to);
		System.out.printf("%d -> %d 로 가는 경우의 수: %d", from, to, pathCount);
	}

	public static void buildGraph() {
		graph = new ArrayList<ArrayList<Integer>>();
		graph.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
		graph.add(new ArrayList<Integer>(Arrays.asList(5)));
		graph.add(new ArrayList<Integer>(Arrays.asList(4)));
		graph.add(new ArrayList<Integer>(Arrays.asList(2, 5)));
	}

	// 그래프 출력하는 메서드
	public static void printGraph(ArrayList<ArrayList<Integer>> graph) {
		int i = 1;
		for (ArrayList<Integer> alist : graph) {
			System.out.println(i++ + " - " + alist);
		}
	}

	private static Stack<Integer> stack = new Stack<Integer>();

	// 일종의 DFS로 동작
	public static void findAllPath(int s, int e) {
		// dfs로 노드를 방문하면 일단 저장
		stack.push(s);
		for (int node : graph.get(s - 1)) {
			if (node == e) {
				pathCount++;
				stack.push(e);
				printStack();
			} else {
				findAllPath(node, e);
				if (!stack.empty())
					stack.pop(); // 끝까지 다 간 경우
			}
		}
		if (!stack.empty())
			stack.pop(); // 완전히 끝났으면 현재 방문 노드 s를 제거
	}

	public static void printStack() {
		for (int i = 0; i < stack.size(); i++) {
			System.out.printf("%3d", stack.elementAt(i));
		}
		System.out.println();
	}
}
