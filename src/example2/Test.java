package example2;

import java.util.Scanner;

public class Test {

	
	public static void main(String args[]) throws Exception{
		LinQueue carQueue=new LinQueue();
		Scanner scanner=new Scanner(System.in);
		int n,m;
		System.out.print("������ͳ���");
		n=scanner.nextInt();
		System.out.print("�����뿨����");
		m=scanner.nextInt();
		for (int i = 0; i < n; i++) {
			carQueue.append(new String("car"+i));
		}

		LinQueue truckQueue=new LinQueue();
		for (int i = 0; i < m; i++) {
			truckQueue.append(new String("truck"+i));
		}
		
	
		

		int flag=0;
		int flag1=1;
		System.out.print("��"+flag1+"�ο����� ");
		while(carQueue.count>0||truckQueue.count>0){
			for (int i = 0; i < 4; i++) {
				if(carQueue.count==0){
					if(truckQueue.count==0) break;
					System.out.print(truckQueue.getFront()+"\t");
					flag++;
					if(flag==10){
						flag1++;
						System.out.print("\n��"+flag1+"�ο����� ");
						flag=0;
					}
				}else{
					System.out.print(carQueue.getFront()+"\t");
					flag++;
					if(flag==10){
						flag1++;
						System.out.print("\n��"+flag1+"�ο����� ");
						flag=0;
					}
				}
			}
			for (int i = 0; i < 1; i++) {
				if(truckQueue.count==0){
					if(carQueue.count==0) break;
					System.out.print(carQueue.getFront()+"\t");
					flag++;
					if(flag==10){
						flag1++;
						System.out.print("\n��"+flag1+"�ο����� ");
						flag=0;
					}
				}else{
					System.out.print(truckQueue.getFront()+"\t");
					flag++;
					if(flag==10){
						flag1++;
						System.out.print("\n��"+flag1+"�ο����� ");
						flag=0;
					}
				}
			}
			
		}
	}
}
