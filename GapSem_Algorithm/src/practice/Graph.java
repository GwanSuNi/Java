package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph {
	private ArrayList<ArrayList<Integer>> graph;

	// 객체 생성 시 파일 이름을 받아와서 읽고 ArrayList 생성
	// 파일 I/O 시 내부에서 처리하지 않고 예외 던져주기만 할 것임
	public Graph(String fileName) throws IOException {
		// 받아온 파일 이름을 통해 파일을 읽음
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		graph = new ArrayList<ArrayList<Integer>>();
		String str;
		while ((str = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(str, ",");
			ArrayList<Integer> adjVertex = new ArrayList<Integer>();
			while (tokenizer.hasMoreTokens()) {
				adjVertex.add(Integer.parseInt(tokenizer.nextToken()));
			}
			graph.add(adjVertex);
		}
		reader.close();
	}

	// 외부에서 호출하는 dfs
	public String dfs(int vertex) {
		boolean[] visited = new boolean[graph.size() + 1]; // 0번째 인덱스는 사용하지 않을 것이기 때문
		String result = _dfs(vertex, visited);
		return result.substring(0, result.length() - 2); // "->" 없애는 용도로 substring()에서 -2 한것
	}

	// 내부적으로 사용하는 dfs
	private String _dfs(int vertex, boolean[] visited) {
		String path = "";
		if (visited[vertex]) // 해당 노드를 방문 했다면
			return "";
		// 처음 방문한 노드에 대한 처리
		visited[vertex] = true;
		path += String.format("%d->", vertex); // 경로 추가
		for (Integer v : graph.get(vertex - 1)) {
			path += _dfs(v, visited);
		}
		return path;
	}

	// 넓이 우선 탐색
	public String bfs(int vertex) {
		boolean[] visited = new boolean[graph.size() + 1];
		int[] distance = new int[graph.size() + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		String path = "";

		// 시작 노드 세팅
		// 시작 지점 방문 여부와 거리 설정
		visited[vertex] = true;
		distance[vertex] = 0;
		queue.add(vertex);

		while (!queue.isEmpty()) { // 큐가 비어있지 않다면
			int s = queue.poll();
			path += String.format("%d->", s);
			for (Integer v : graph.get(s - 1)) {
				if (visited[v])
					continue;
				visited[v] = true;
				distance[v] += 1;
				queue.offer(v);
			}
		}
		return path.substring(0, path.length() - 2);
	}

	// 그래프 출력
	public void printGraph() {
		int n = 0;
		for (ArrayList<Integer> adjVertex : graph) {
			System.out.printf("%d - ", ++n);
			for (int vertex : adjVertex) {
				System.out.printf(" %d ", vertex);
			}
			System.out.println();
		}
	}
}
