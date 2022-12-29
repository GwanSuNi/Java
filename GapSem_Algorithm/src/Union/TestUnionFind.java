package Union;

import java.io.IOException;
import java.util.Scanner;

public class TestUnionFind {

	public static void main(String[] args) throws IOException {
		// 집합다루기();
		여행계획짜기();
	}

	public static void 집합다루기() {
		UnionFind set;
		Scanner scanner = new Scanner(System.in);
		/*
		 * 집합 다루기 입력 형태: X a b , union if X == 0, find if X == 1
		 */
		set = new UnionFind(7);
		set.print();
		int m = 8; // 몇 번 돌지 횟수 지정
		for (int i = 0; i < m; i++) {
			int input = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			if (input == 0) { // a, b를 같은 집합으로 만들기
				set.union(a, b);
			} else { // 같은 집합의 원소인지 확인하기
				if (set.isSameSet(a, b)) {
					System.out.println("같은 집합");
				} else {
					System.out.println("다른 집합");
				}
			}
			set.print();
		}
		scanner.close();
	}

	public static void 여행계획짜기() {
		/*
		 * 도시가 N개 있고 임의의 두 도시 사이에 길이 있거나, 없을 수도 있음 (단일 그래프이거나 서브 그래프가 있을 수 있음)
		 * 
		 * 경민이가 여행을 하려할 때 가고 싶은 도시들을 선정하면 여행이 가능한 지 아닌 지 알아보는 프로그램
		 */
		int N; // 도시의 수
		int M; // 여행 계획에 속한 도시의 수

		// 도시 연결하는 데이터 만들기
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();

		int[][] city = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				city[i][j] = scanner.nextInt(); // 도시끼리 연결된 도로망 저장 (그래프 만들기)
			}
		}

		// 여행할 도시 정보 저장
		int[] route = new int[M + 1]; // 경로를 저장하기 위한 배열
		for (int i = 1; i <= M; i++) {
			route[i] = scanner.nextInt();
		}
		scanner.close();

		UnionFind set = new UnionFind(N); // 도시 N개로 집합 만들기

		// 인접행렬에서 도시 연결되었는 지 확인해서 연결되어 있으면 union() 실행
		// 결국 경로를 압축해놓음 --> set에 대표 도시를 설정
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (city[i][j] == 1) {
					set.union(i, j);
				}
			}
		}

		// 여행 계획 (route) 상에 있는 도시들이 모두 같은 대표 도시로 연결돼 있는 지 확인
		// 여행 가능한 경우 - 대표 도시들이 동일 (모두 동일)
		// 여행 불가능한 경우 - 대표 도시들이 다름 (하나라도 다름)
		int index = set.find(route[1]); // 배열 0번은 안쓰기 때문에 1부터 검사
		for (int i = 2; i < route.length; i++) {
			if (index != set.find(route[i])) { // 2번부터 다른게 하나라도 있으면 여행 불가능
				System.out.println("여행 불가능");
				return;
			}
		}
		// 위에서 다 통과 했다면
		System.out.println("여행 가능");

	}

}
