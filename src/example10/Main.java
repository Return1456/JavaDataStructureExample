package example10;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ������� ���ԣ�4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
		int n = sc.nextInt();
		int m = sc.nextInt();
		int p = sc.nextInt();
		int[][] mi = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mi[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(mi[i][j]+" ");
			}
			System.out.println();
		}
		
		flag = new boolean[n][m];
		List result = new ArrayList<>();
		List tempList = new ArrayList<>();
		// ���ü��㷽����������������result.
		cc(0, 0, mi, result, tempList);
		// �Ƚ����ľ������ٵ�
		int shortestNum = 0;
		List temp = (List) result.get(0);
		int min = (int) temp.get(temp.size() - 1);
		if (result.size() > 1) {
			for (int i = 1; i < result.size(); i++) {
				temp = (List) result.get(i);
				int tempMin = (int) temp.get(temp.size() - 1);
				if (tempMin < min) {
					min = tempMin;
					shortestNum = i;
				}
			}
		}
		List r = (List) result.get(shortestNum);
		r.remove(r.size() - 1);
		for(int i=0; i<r.size() ;i++){
			System.out.print(r.get(i)+",");
		}
		System.out.println("[0,3]");		
	}

	// ��������ľ�̬����
	static boolean[][] flag; // Ϊ����ÿ��Ԫ�����ñ�־�������ظ�����ĳ����ɶ�μ������ѭ��
	static int pu; // pUsed ÿ���ɹ�������ڵ����м������ĵ�����ֵ

	/*

	 * �����Թ�·����������Ҫʹ�õݹ����ÿ���ڵ���������ҡ��������ҽڵ��ֿ��Ե��������������ҡ� ����������������������λ�ã�����˳��Ϊ�ϡ��ҡ��¡���

	 * ����������βΣ������ñ�������ַ���䣬��ָ��ĵ�ַ��ֵ���Ա仯.

	 */
	public static void cc(int i, int j, int[][] mi, List result, List tempList) {
		// flag[i][j] = true;
		// //�����ǿ������·������ͬ·��֮�������һ���ظ���Ӧʹ��list.contains()�ж��Ƿ��Ѱ����˽ڵ㡣
		// ���ܴ�����·���˳��ڣ��½�list��������������pu
		if (i == 0 && j == mi[0].length - 1) {
			tempList.add(pu);
			result.add(new ArrayList<>(tempList));
			tempList.remove((Integer) pu);
		}
		/*
		 * up���ӵ�ǰ�ڵ㣬�������ϡ�����ϸ��ڵ�����û��ʹ�ã����ϸ��ڵ���Ϊ�������뷽��������ͬ��
		 * ����ǰ�ڵ���Ϣ(x,y)����list�������귽���Ƴ��������ǳ���Ҫ�������ģ���
		 * ��Ϊ�����Ƿ񵽴���ڣ���˵���Ѿ�̽���������ڵ������·���ˣ�Ӧ���Ƴ�������ԴӴ˽ڵ��ϸ��ڵ����̽����
		 * �����˳��ڣ��Ѿ������ˣ����Ƴ���û������·��ͨ���Ƴ��� ��������Ӧ��ʹ��stack����ʹ�ò������list�����ˡ�
		 */
		if (i > 0 && mi[i - 1][j] == 1
				&& !tempList.contains("[" + (i - 1) + "," + j + "]")) {
			tempList.add("[" + i + "," + j + "]");
			pu += 3;
			cc(i - 1, j, mi, result, tempList);
			tempList.remove("[" + i + "," + j + "]");
			pu -= 3;
		}
		// right
		if (j < mi[0].length - 1 && mi[i][j + 1] == 1
				&& !tempList.contains("[" + i + "," + (j + 1) + "]")) {
			tempList.add("[" + i + "," + j + "]");
			pu += 1;
			cc(i, j + 1, mi, result, tempList);
			tempList.remove("[" + i + "," + j + "]");
			pu -= 1;
		}
		// down
		if (i < mi.length - 1 && mi[i + 1][j] == 1
				&& !tempList.contains("[" + (i + 1) + "," + j + "]")) {
			tempList.add("[" + i + "," + j + "]");
			cc(i + 1, j, mi, result, tempList);
			tempList.remove("[" + i + "," + j + "]");
		}
		// left
		if (j > 0 && mi[i][j - 1] == 1
				&& !tempList.contains("[" + i + "," + (j - 1) + "]")) {
			tempList.add("[" + i + "," + j + "]");
			pu += 1;
			cc(i, j - 1, mi, result, tempList);
			tempList.remove("[" + i + "," + j + "]");
			pu -= 1;
		}
	}
}