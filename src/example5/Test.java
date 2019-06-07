package example5;

import java.util.ArrayList;
import java.util.List;

public class Test {
public static void main(String args[]){
		int n=4;
		int e=12;
		AdjMWGraph g=new AdjMWGraph(n);
		Character[] a={
				new Character('a'),
				new Character('b'),
				new Character('c'),
				new Character('d')
		};
		RowColWeight[] rcw={
				new RowColWeight(0, 1,1),
				new RowColWeight(1, 0,1),
				new RowColWeight(0, 2,13),
				new RowColWeight(2, 0,13),
				new RowColWeight(0, 3,4),
				new RowColWeight(3,0,4),
				new RowColWeight(1, 2,9),
				new RowColWeight(2,1,9),
				new RowColWeight(1, 3,2),
				new RowColWeight(3, 1,2),
				new RowColWeight(2,3,8),
				new RowColWeight(3, 2,8)
				
		};
		
		try {
			RowColWeight.createGraph(g, a, n, rcw, e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		int[][] A=g.getEdge();				//获得建图后的邻接矩阵
		
		for (int i = 0; i < n; i++) {		//弗洛伊德算法
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if(A[j][j2]>(A[j][i]+A[i][j2])) A[j][j2]=A[j][i]+A[i][j2];		
				}
			}
		}
		
		for (int i = 0; i < n; i++) {		//输出调用弗洛伊德算法的邻接矩阵
			for (int j = 0; j < n; j++) {
				System.out.print(A[i][j]+"\t");
			}
			System.out.println();
		}
		
		List<Integer> list=new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			int x1=0;
			for (int j = 0; j < n; j++) {
				if(A[i][j]>0&&A[i][j]>x1){
					x1=A[i][j];
				}
				if(j==n-1&&x1!=0){
					list.add(new Integer(x1));
				}
			}
		}
		
		System.out.println("\n每个顶点到其他点的最长路径分别为：");
		int min=(int)list.get(0);
		for(Integer x:list){
			if((int)x<min)min=(int)x;
			System.out.print(x+" ");
		}

		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			if((int)list.get(i)==min) System.out.println("\n故应选"+i);
		}
		
	
}
}
