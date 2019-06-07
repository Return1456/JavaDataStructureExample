package example1;

import java.util.Scanner;

public class Test {
public static void main(String args[]) throws Exception{
	CycleLinList list=new CycleLinList();
	int n;
	int m;
	Scanner scanner=new Scanner(System.in);
	System.out.println("输入人数n: ");
	n=scanner.nextInt();
	System.out.println("输入报数值m: ");
	m=scanner.nextInt();
	for (int i = n; i >0; i--) {
		list.insertNode(0, new Integer(i));
	}
	System.out.println("链表长度： "+list.size);
	System.out.println("步长: "+m);
	list.outprint();
	while(list.size>1){
		list.deleteAfterN(m);
	}
	System.out.println("胜利者");
	list.outprint();
}
}
