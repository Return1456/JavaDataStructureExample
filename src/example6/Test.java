package example6;

import java.util.Scanner;

import sun.tools.jar.resources.jar;


public class Test {
public static void main(String args[]){
	Scanner scanner=new Scanner(System.in);
	System.out.println("�����뾰������");
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
	
	System.out.println("ԭʼ�ٽ����");
	for (int i = 0; i < A.length; i++) {
		for (int j = 0; j < A.length; j++) {
			System.out.print(A[i][j].weight+"\t");
		}
		System.out.println();
	}
	
	for (int i = 0; i < A.length; i++) {		//���ø��������㷨
		for (int j = 0; j < A.length; j++) {
			for (int j2 = 0; j2 < A.length; j2++) {
				if(A[j][j2].weight>A[j][i].weight+A[i][j2].weight) {
					A[j][j2].weight=A[j][i].weight+A[i][j2].weight;
					A[j][j2].list.add(new Integer(i));
				}
			}
		}
	}
	
	System.out.println("\n�����ľ���");
	for (int i = 0; i < A.length; i++) {
		for (int j = 0; j < A.length; j++) {
			System.out.print(A[i][j].weight+"\t");
		}
		System.out.println();
	}
	

	System.out.println("\n���������ڵľ����");
	int d1=scanner.nextInt();
	System.out.println("������ȥ���ľ����");
	int d2=scanner.nextInt();
	System.out.println();
	System.out.println("��̾��� ��"+A[d1][d2].weight);
	System.out.println();
	System.out.print("·��"+d1+"-->");
	for(Integer x:A[d1][d2].list){
		System.out.print(x+"-->");
	}
	System.out.print(d2);
}
}
