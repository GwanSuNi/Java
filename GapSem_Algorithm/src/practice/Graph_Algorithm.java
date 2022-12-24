package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 그래프 표현
 * - 인접행렬 (adjacent matrix)
 * - 인접리스트 (adjacent list)
 * - java 언어 사용하는 경우 2차원 배열로
 */
public class Graph_Algorithm {
	static ArrayList<ArrayList<Integer>> graph;

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		// 인접리스트로 그래프 만들기
		/*
		 * 1 - 2, 3, 4 
		 * 2 - 1, 4, 5 
		 * 3 - 1, 4 
		 * 4 - 1, 2, 3, 5 
		 * 5 - 2, 4
		 */
		graph = new ArrayList<ArrayList<Integer>>();

		graph.add(new ArrayList<Integer>(Arrays.asList(2, 3, 4)));

		graph.add(new ArrayList<Integer>() {
			{
				add(1);
				add(4);
				add(5);
			}
		});
		graph.add(new ArrayList<Integer>() {
			{
				add(1);
				add(4);
			}
		});
		graph.add(new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(5);
			}
		});
		graph.add(new ArrayList<Integer>() {
			{
				add(2);
				add(4);
			}
		});

		// 그래프 출력하기
		printGraph(graph);

		// DFS로 방문해보기
//		System.out.println("DFS로 방문");
		visited = new boolean[graph.size() + 1]; // vertex 개수만큼 초기화 (편의를 위해 0번 무시하고 인덱스 통일)
		graphDFS(1);

		// BFS로 방문해보기
		System.out.println("BFS로 방문");
		graphBFS(1);
	}

	public static boolean[] visited;

	public static void graphDFS(int vertex) {
		// 깊이 우선 탐색 (DFS, Depth First Search)
		/*
		 * 전제조건 : - 스택을 사용해야 함 : Stack<E> 또는 call stack을 사용 (재귀호출) - Vertex 방문 기록 관리해야 함
		 * : 그래프에 포함된 vertex를 방문했는 지 여부 (boolean)
		 */
		if (visited[vertex]) { // 방문 했던 vertex라면
			return;
		} else { // 방문한 적 없다면
			visited[vertex] = true;
			for (Integer v : graph.get(vertex - 1)) { // graph[0]부터 시작해야함
				graphDFS(v);
			}
		}
	}

	public static void graphBFS(int start) {
		// 넓이 우선 탐색 (BFS, Breadth First Search)
		/*
		 * 전제조건 : - 큐를 사용해야함 : 한 레벨을 모두 탐색 - Vertex 방문 기록 관리해야 함 : 그래프에 포함된 vertex를 방문했는
		 * 지 여부 (boolean)
		 */
		boolean[] visited = new boolean[graph.size() + 1]; // 방문 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] distance = new int[graph.size() + 1]; // 정수로 거리 계산

		visited[start] = true;
		distance[start] = 0;
		queue.offer(start);
		while (!queue.isEmpty()) {
			int s = queue.poll(); // 반환하고 삭제
			System.out.printf("%3d", s);
			for (Integer v : graph.get(s - 1)) { // 각 요소 검사
				if (visited[v]) { // 방문 한 적 있으면
					continue;
				} else { // 방문 한 적 없으면
					visited[v] = true;
					distance[v] = distance[s] + 1; // 사이클이 발생하지 않게 더 큰 쪽으로 유도
					queue.offer(v);
				}
			}
		}
		System.out.println();
		// vertex 거리 찍어보기
		for (int i : distance) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}

	// 그래프 출력하는 메서드
	public static void printGraph(ArrayList<ArrayList<Integer>> graph) {
		int i = 1;
		for (ArrayList<Integer> alist : graph) {
			System.out.println(i++ + " - " + alist);
		}
	}

}
