package example6;

import java.util.Scanner;

import sun.tools.jar.resources.jar;


public class Test {
public static void main(String args[]){
	Scanner scanner=new Scanner(System.in);
	System.out.println("请输入景点数量");
	int n=4;
	n=scanner.nextInt();
	Edge[][] A=new Edge[n][n];
	
	for (int i = 0; i < A.length; i++) {
		for (int j = 0; j < A.length; j++) {
			if(i==j){
				Edge edge=new Edge();
				edge.weight=0;
				A[i][j]=edge;
			}else{
				Edge edge=new Edge();
				edge.weight=10000;
				A[i][j]=edge;
			}
			
		}
	}
	
	
	for (int i = 0; i < n; i++) {
		for (int j = i; j < n; j++) {
			if(i==j){
				A[i][j].weight=0;
			}
			else{ 
				A[i][j].weight=(int) Math.round(Math.random()*100);
			}
		}
	}

	for (int i = 0; i < A.length; i++) {
		for (int j = 0; j < A.length; j++) {
			if(i>j)A[i][j]=A[j][i];
		}
	}
	
	System.out.println("原始临界矩阵");
	for (int i = 0; i < A.length; i++) {
		for (int j = 0; j < A.length; j++) {
			System.out.print(A[i][j].weight+"\t");
		}
		System.out.println();
	}
	
	for (int i = 0; i < A.length; i++) {		//调用弗洛伊德算法
		for (int j = 0; j < A.length; j++) {
			for (int j2 = 0; j2 < A.length; j2++) {
				if(A[j][j2].weight>A[j][i].weight+A[i][j2].weight) {
					A[j][j2].weight=A[j][i].weight+A[i][j2].weight;
					A[j][j2].list.add(new Integer(i));
				}
			}
		}
	}
	
	System.out.println("\n处理后的矩阵");
	for (int i = 0; i < A.length; i++) {
		for (int j = 0; j < A.length; j++) {
			System.out.print(A[i][j].weight+"\t");
		}
		System.out.println();
	}
	

	System.out.println("\n请输入现在的景点号");
	int d1=scanner.nextInt();
	System.out.println("请输入去往的景点号");
	int d2=scanner.nextInt();
	System.out.println();
	System.out.println("最短距离 ："+A[d1][d2].weight);
	System.out.println();
	System.out.print("路线"+d1+"-->");
	for(Integer x:A[d1][d2].list){
		System.out.print(x+"-->");
	}
	System.out.print(d2);
}
}
