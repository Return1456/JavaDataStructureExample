package example9;

import java.util.Scanner;

public class Test {
public static void main(String args[]) throws Exception{
	int size=127;
	HashTable myhHashTable=new HashTable(size);
	
	float[][] a =new float[100][100];
	int count=0;
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < a.length; j++) {
			a[i][j]=0;
		}
	}
	System.out.println("row\tcol\tval\thad");
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < a.length; j++) {
			if(count<110){
				a[i][j]=Math.round(Math.random()*100);
				System.out.print(i+"\t"+j+"\t"+a[i][j]+"\t");
				count++;
				Data data=new Data(i,j,a[i][j]);
				System.out.println(myhHashTable.insert(data));
			}
		}
	}
	System.out.println("\ncurrentSize: "+myhHashTable.getCurrentSize());
	
	Scanner scanner=new Scanner(System.in);
	System.out.println("请输入哈希地址来查找");
	int n=scanner.nextInt();
	System.out.println(myhHashTable.getVal(n).row+"\t"+myhHashTable.getVal(n).col+"\t"+myhHashTable.getVal(n).val);
	
	System.out.println("请输入行列和数据来查找哈希地址");
	int m1=scanner.nextInt();
	int m2=scanner.nextInt();
	float f=scanner.nextFloat();
	Data data=new Data(m1, m2, f);
	System.out.println(myhHashTable.find(data));
}
}