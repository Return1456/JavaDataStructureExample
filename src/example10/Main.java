package example10;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 输入参数 测试：4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
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
		// 调用计算方法，传入参数。获得result.
		cc(0, 0, mi, result, tempList);
		// 比较消耗精力最少的
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

	// 辅助计算的静态变量
	static boolean[][] flag; // 为数组每个元素设置标志，避免重复到达某点造成多次计算或死循环
	static int pu; // pUsed 每个成功到达出口的序列计算消耗的体力值

	/*

	 * 计算迷宫路径方法，主要使用递归调用每个节点的上下左右。上下左右节点又可以调用它的上下左右。 按消耗体力的数量及出口位置，优先顺序为上、右、下、左

	 * 传入参数，形参，即引用变量，地址不变，但指向的地址的值可以变化.

	 */
	public static void cc(int i, int j, int[][] mi, List result, List tempList) {
		// flag[i][j] = true;
		// //本题是考察最短路径，不同路径之间可以有一段重复。应使用list.contains()判断是否已包含此节点。
		// 不管从哪条路到了出口，新建list存入结果，并保存pu
		if (i == 0 && j == mi[0].length - 1) {
			tempList.add(pu);
			result.add(new ArrayList<>(tempList));
			tempList.remove((Integer) pu);
		}
		/*
		 * up，从当前节点，考虑向上。如果上个节点有且没有使用，将上个节点作为参数传入方法。其他同理。
		 * 将当前节点信息(x,y)存入list，调用完方法移除！！！非常重要！！核心！！
		 * 因为不管是否到达出口，都说明已经探索完从这个节点伸出的路径了，应当移除，则可以从此节点上个节点继续探索。
		 * 到达了出口，已经保存了，该移除；没到，此路不通，移除。 根据需求应当使用stack，我使用不多就用list代替了。
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