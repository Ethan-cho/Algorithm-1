import java.util.*;

/**
 * 
 * @author Ming
 * 2105. [���� SW �����׽�Ʈ] ����Ʈ ī��
 */
public class SW_2105 {

	static int dx[] = { -1, -1, 1, 1 };
	static int dy[] = { -1, 1, -1, 1 };
	static int n;
	static int[][] map;
	static boolean[] visit;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			map = new int[n + 1][n + 1];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			ans = -1;
			// �簢�� Ž��
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visit = new boolean[101];
					visit[map[i][j]] = true;
					findRoute(i, j, i, j, 0, 0, 0);
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	// findRoute(ó�� ���� x��, ó�� ���� y��, ���� x��, ���� y��, ���� ����, ������� turn ���� Ƚ��, ���� ����Ʈ ��)
	private static void findRoute(int sx, int sy, int x, int y, int dir, int turn, int dept) {

		if (turn > 3) {
			return;
		}

		for (int k = 0; k < 4; k++) {

			// ���� ����� ���� �������� ���ư��� ���
			if (dir == 0 && k == 3) {
				continue;
			} else if (dir == 1 && k == 2) {
				continue;
			} else if (dir == 2 && k == 1) {
				continue;
			} else if (dir == 3 && k == 0) {
				continue;
			}

			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}

			// �簢�� ������� ���
			if (sx == nx && sy == ny && turn == 3) {
				ans = Math.max(ans, dept + 1);
				return;
			}

			if (visit[map[nx][ny]]) {
				continue;
			}

			visit[map[nx][ny]] = true;
			
			if (dir == k) {
				findRoute(sx, sy, nx, ny, k, turn, dept + 1);
			} else {
				findRoute(sx, sy, nx, ny, k, turn + 1, dept + 1);
			}

			visit[map[nx][ny]] = false;

		}

	}

}
