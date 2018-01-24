import java.util.Scanner;

/**
 * 
 * @author Ming
 * 1952. [���� SW �����׽�Ʈ] ������
 */

public class SW_1952 {

	static int[] day;
	static int[] month;
	static int[] plan;
	static int[] d;
	static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int k = 0;

		while (k++ < t) {

			// �� ���
			int cday = sc.nextInt();
			int cmonth = sc.nextInt();
			int cthree = sc.nextInt();
			int cyear = sc.nextInt();

			// �̿�� �迭
			plan = new int[13];
			day = new int[13];
			month = new int[13];
			d = new int[13];

			// �̿� ��ȹ
			for (int i = 1; i <= 12; i++) {
				plan[i] = sc.nextInt();
			}

			// �̿�� ���
			for (int i = 1; i <= 12; i++) {
				if (plan[i] != 0) {
					month[i] = cmonth;
				}
				day[i] = plan[i] * cday;
				day[i] = Math.min(month[i], day[i]);
			}

			// �ּ� ��� ���
			for (int i = 1; i <= 2; i++) {
				d[i] = d[i - 1] + day[i];
			}

			for (int i = 3; i <= 12; i++) {
				d[i] = Math.min(d[i - 1] + day[i], cthree + d[i - 3]);
			}

			// year�� ��
			ans = Math.min(d[12], cyear);
			System.out.println("#" + k + " " + ans);
		}
	}

}
