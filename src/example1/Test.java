package example1;

import java.util.Scanner;

public class Test {
public static void main(String args[]) throws Exception{
	CycleLinList list=new CycleLinList();
	int n;
	int m;
	Scanner scanner=new Scanner(System.in);
	System.out.println("��������n: ");
	n=scanner.nextInt();
	System.out.println("���뱨��ֵm: ");
	m=scanner.nextInt();
	for (int i = n; i >0; i--) {
		list.insertNode(0, new Integer(i));
	}
	System.out.println("�����ȣ� "+list.size);
	System.out.println("����: "+m);
	list.outprint();
	while(list.size>1){
		list.deleteAfterN(m);
	}
	System.out.println("ʤ����");
	list.outprint();
}
}
