package Union;

/*
 * 그래프를 이용해 집합을 표현하는 방법
 */
public class UnionFind {
	int[] parent;

	public UnionFind(int n) {
		// 집합 만들고 초기화
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}

	// 같은 집합으로 합치기
	// 원소 a, b를 같은 같은 집합에 소속되게 만들기
	// a와 a가 저장된 인덱스(집합)가 같으면 b를 a가 저장된 인덱스로 바꿈
	public void union(int a, int b) {
		a = find(a); // 대표 원소 찾기, 원소 a가 속한 집합이 어디인지 찾기
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}

	// 대표 원소 찾기
	public int find(int a) {
		if (a == parent[a])
			return a;
		else
			return parent[a] = find(parent[a]);
	}

	// 같은 대표 원소 찾기 : 같은 대표 집합인가 확인
	public boolean isSameSet(int a, int b) {
		return find(a) == find(b);
	}

	public void print() {
		// 인덱스 표시
		for (int i = 1; i < parent.length; i++)
			System.out.printf("\t%d", i);
		System.out.println();

		for (int i = 1; i < parent.length; i++)
			System.out.printf("\t%d", parent[i]);
		System.out.println();
	}
}
