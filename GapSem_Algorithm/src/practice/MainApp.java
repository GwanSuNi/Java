package practice;

import java.io.IOException;

public class MainApp {

	public static void main(String[] args) throws IOException {
		Graph g;
		
		g = new Graph("test_dfs.graph");
		g.printGraph();
		
		// dfs로 방문하기
		System.out.println("dfs: " + g.dfs(1));

		// bfs로 방문하기
		System.out.println("bfs: " + g.bfs(1));
		
		// 최단 경로 구하기
		WeightedGraph wg = new WeightedGraph("test_weighted.graph");
		wg.printGraph();
		wg.bellman_ford(1);
		wg.dijkstra(1);
		
		System.out.println();
		wg = new WeightedGraph("test_floyd_warshall.graph");
		wg.floyd_warshall(1);
		
		/*
		 * 그래프가 주어졌을 때 각 노드의 indegree와 outdegree를 구하는 프로그램을 작성하라.
		 */
		wg = new WeightedGraph("test_find_degrees.graph");
		wg.find_degrees();
 	}

}
