package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WeightedGraph {
	private ArrayList<Edge> graph;

	// Edge를 표현하는 내부 클래스
	class Edge implements Comparable<Edge> { // compareTo()에 대응되는 인터페이스
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public WeightedGraph(String fileName) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		graph = new ArrayList<Edge>();
		String str;
		while ((str = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(str, ",");
			if (tokenizer.countTokens() == 3) { // 토큰 개수가 3개이면 -> edge의 시작, 끝, 가중치가 모두 정상적으로 있을 때
				int from = Integer.parseInt(tokenizer.nextToken());
				int to = Integer.parseInt(tokenizer.nextToken());
				int weight = Integer.parseInt(tokenizer.nextToken());
				graph.add(new Edge(from, to, weight)); // 얻은 토큰들을 Edge 타입으로 그래프에 추가
			} else { // 완전한 가중치 edge가 아닐 시
				throw new IOException();
			}
		}
		reader.close();
	}

	// 노드 개수 반환하는 메서드
	public int getNodeCount() {
		int n = 0;
		for (Edge edge : graph) {
			// 노드는 1부터 자연수이기 때문에 from과 to 중 큰 숫자가 노드의 개수임
			n = Math.max(Math.max(n, edge.from), Math.max(n, edge.to));
		}
		return n;
	}

	// bellman ford 알고리즘 메서드
	public void bellman_ford(int v) {
		final int INF = Integer.MAX_VALUE;
		int n = getNodeCount();

		// 최소 비용 초기화
		int[] dist = new int[n + 1]; // 0 인덱스는 사용 안함
		Arrays.fill(dist, INF); // dist 배열의 모든 값을 INF로 초기화
		// 시작 노드의 비용을 0으로 설정
		dist[v] = 0;

		// 노드 개수만큼 반복 실행
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < graph.size(); j++) {
				int from = graph.get(j).from;
				int to = graph.get(j).to;
				int weight = graph.get(j).weight;

				// from까지 갈 수 없으면 갱신하지 않음
				if (dist[from] == INF) // 아직 방문하지 않았을 경우
					continue;

				// to까지 가는 비용보다 (from까지 가는 비용 + from에서 to까지 가는 비용)이 더 저렴하다면 갱신
				if (dist[to] > dist[from] + weight) {
					// v번째 횟수에 갱신된다면 음의 사이클이 존재하기 때문에 최단 경로를 구할 수 없음
					if (i == n) {
						System.out.println("음의 사이클");
						return;
					}
					dist[to] = dist[from] + weight;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			// 알고리즘이 아직 도달하지 않은 곳은 INF로 찍어줘야하기 때문
			System.out.printf("노드%d -> 노드%d 의 최소비용: %d\n", v, i, dist[i] == INF ? INF : dist[i]);
		}
	}

	public void dijkstra(int v) {
		final int INF = Integer.MAX_VALUE;
		int N = getNodeCount();
		// 최단 경로 저장할 배열
		int[] dist = new int[N + 1];
		// 초기 비용 저장, 시작 노드를 제외한 나머지는 INF로 세팅
		Arrays.fill(dist, INF);
		dist[v] = 0;

		// edge 리스트 생성
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] edgeList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			edgeList[i] = new ArrayList<Edge>();
		}
		System.out.println(edgeList.length);

		for (Edge edge : graph) {
			System.out.printf("(%d,%d,%d)\n", edge.from, edge.to, edge.weight);
			edgeList[edge.from].add(new Edge(edge.from, edge.to, edge.weight));
			edgeList[edge.to].add(new Edge(edge.to, edge.from, edge.weight));
		}

		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>();
		pQueue.offer(new Edge(v, v, 0));

		// 우선순위 큐가 빈다면 더 이상 갱신이 가능한 정점이 없다.
		while (!pQueue.isEmpty()) {
			int to = pQueue.peek().to;
			int weight = pQueue.poll().weight;

			// v -> to보다 현재 Edge의 비용이 더 비싸면 갱신할 필요가 없음
			if (dist[to] < weight)
				continue;

			for (int i = 0; i < edgeList[to].size(); i++) {
				Edge edge = edgeList[to].get(i);

				// v -> to 보다 v -> to -> n.to로 가는 비용이 더 싸면
				if (dist[edge.to] > edge.weight + weight) {
					dist[edge.to] = edge.weight + weight;
					pQueue.offer(new Edge(0, edge.to, dist[edge.to]));
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(dist[i] + " ");
		}
	}

	// 플로이드 워셜 알고리즘
	public void floyd_warshall(int v) {
		final int INF = Integer.MAX_VALUE;
		int N = getNodeCount();

		// 최단거리 배열 (2차원 배열 dist[시작][끝], 인접행렬의 형태로 표현) 만들기
		int[][] dist = new int[N + 1][N + 1]; // 0은 사용 안할 것임

		// 최단거리 배열 초기화 : 자신의 노드에서 자신으로 가는 비용은 0, 나머지는 초기에 INF임
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], INF); // 모두 INF
			dist[i][i] = 0; // 인접행렬에서 자기 자신은 0
		}

		// 그래프의 내용을 반영해 최단거리 배열 비용 초기화
		for (Edge edge : graph) {
			dist[edge.from][edge.to] = edge.weight;
		}

		// 최단거리 배열 내용 확인해보기
		for (int s = 1; s <= N; s++) {
			for (int e = 1; e <= N; e++) {
				System.out.printf("\t%3s", (dist[s][e] == INF ? "INF" : String.format("%d", dist[s][e])));
			}
			System.out.println();
		}

		// floyd_warshall 알고리즘 시작
		// (s -- e) 가 최소 경로일 때 (s -- k -- e) 와 같고 (s -- k) 와 (k -- e) 각자 최소 경로임
		for (int k = 1; k <= N; k++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if (dist[s][k] == INF || dist[k][e] == INF) // 음의 사이클 방지
						continue;
					dist[s][e] = Math.min(dist[s][e], dist[s][k] + dist[k][e]);
				}
			}
		}

		// 최단거리 배열 갱신된 내용 확인해보기
		System.out.println();
		for (int s = 1; s <= N; s++) {
			for (int e = 1; e <= N; e++) {
				System.out.printf("\t%3s", (dist[s][e] == INF ? "INF" : String.format("%d", dist[s][e])));
			}
			System.out.println();
		}

	}

	public void find_degrees() {
		int N = getNodeCount();
		final int IN_DEG = 0;
		final int OUT_DEG = 1;

		// 각 노드에 대한 indegree와 outdegree 저장 공간 생성 및 초기화
		int[][] degrees = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(degrees[i], IN_DEG);
		}

		// 엣지 별로 from은 outdegree 증가, to는 indegree 증가
		for (Edge edge : graph) {
			degrees[edge.from][OUT_DEG]++;
			degrees[edge.to][IN_DEG]++;
		}

		for (int i = 1; i <= N; i++) {
				System.out.printf("\t%3d : %3d %3d \n", i, degrees[i][IN_DEG], degrees[i][OUT_DEG]); 
			}

	}

	// 그래프 출력
	public void printGraph() {
		for (Edge edge : graph) {
			System.out.printf("(%d,%d,%d)\n", edge.from, edge.to, edge.weight);
		}
	}

}
