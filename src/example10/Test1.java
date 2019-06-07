package example10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test1 {
	static int n=6;
	static int m=6;
	static int[][] maze=new int[n][m];
	static int[][] mark=new int[n][m];
	static double f=0.5;
public static void main(String args[]) throws Exception {
	Scanner scanner=new Scanner(System.in);
	System.out.println("请输入迷宫行数(5~8)");
	String s1=scanner.nextLine();
	if(!s1.equals("")){
		n=Integer.parseInt(s1);
	}else{
		System.err.println("未输入值，设置默认值6");
		System.out.println();
	}
	System.out.println("请输入迷宫列数(5~8)");
	String s2=scanner.nextLine();
	if(!s1.equals("")){
		n=Integer.parseInt(s2);
	}else{
		System.err.println("未输入值，设置默认值6");
	}
	System.out.println("请输入墙率0~1，越大墙越多");
	String s3=scanner.nextLine();
	if(!s1.equals("")){
		f=Double.parseDouble(s3);
	}else{
		System.err.println("未输入值，设置默认值0.5");
	}
	maze=new int[n][m];
	mark=new int[n][m];
for (int i = 0; i < mark.length; i++) {
	for (int j = 0; j < mark[0].length; j++) {
		if(i==0||j==0||i==n-1||j==m-1){
			maze[i][j]=1;
			mark[i][j]=1;
		}else{
			if(Math.random()>f) maze[i][j]=0;	//越大墙越多
			else maze[i][j]=1;
			
			mark[i][j]=maze[i][j];
		}
	}
}

maze[1][1]=0;
maze[n-2][m-2]=0;
mark[1][1]=0;
mark[n-2][m-2]=0;

for (int i = 0; i < n; i++) {
	for (int j = 0; j < m; j++) {
		System.out.print(maze[i][j]+" ");
	}
	System.out.println();
}
System.out.println();

List result = new ArrayList<>();
List tempList = new ArrayList<>();

getAllRoad(1, 1, result, tempList);

int min=11111;
int index=0,flag=0;
for(Object l:result){
	List list=(List)l;
	System.out.print(list);
	System.out.print("-->["+(n-2)+","+(m-2)+"]\n");
	
	if(list.size()<min){
		min=list.size() ;
		flag=index;
	}
	index++;
}

if(result.size()>0){
	System.out.println("共有"+result.size()+"条路");
	System.out.println("最短路径为");
	System.out.print((List)result.get(flag));
	System.out.print("-->["+(n-2)+","+(m-2)+"]");
}else{
	System.out.println("THERE IS NO PATH IN MAZE.");
}

}



public static void  getAllRoad(int x,int y,List result,List tempList) {
	if(x==n-2&&y==m-2){
		result.add(new ArrayList<>(tempList));
	}
	
	if(mark[x-1][y-1]!=1&&!tempList.contains("[" +(x-1) + "," + (y-1)+ "]")){
		tempList.add("[" +x + "," + y+ "]");
		getAllRoad(x-1, y-1, result, tempList);
		tempList.remove("[" +x + "," + y+ "]");
	}
	
	if(mark[x-1][y]!=1&&!tempList.contains("[" +(x-1) + "," + (y)+ "]")){
		tempList.add("[" +x + "," + y+ "]");
		getAllRoad(x-1, y, result, tempList);
		tempList.remove("[" +x + "," + y+ "]");
	}
	
	if(mark[x-1][y+1]!=1&&!tempList.contains("[" +(x-1) + "," + (y+1)+ "]")){
		tempList.add("[" +x + "," + y+ "]");
		getAllRoad(x-1, y+1, result, tempList);
		tempList.remove("[" +x + "," +y+ "]");
	}
	
	if(mark[x][y+1]!=1&&!tempList.contains("[" +(x) + "," + (y+1)+ "]")){
		tempList.add("[" +x + "," + y+ "]");
		getAllRoad(x, y+1, result, tempList);
		tempList.remove("[" +(x) + "," + (y)+ "]");
	}
	
	if(mark[x+1][y+1]!=1&&!tempList.contains("[" +(x+1) + "," + (y+1)+ "]")){
		tempList.add("[" +x + "," + y+ "]");
		getAllRoad(x+1, y+1, result, tempList);
		tempList.remove("[" +(x) + "," + (y)+ "]");
	}
	
	if(mark[x+1][y]!=1&&!tempList.contains("[" +(x+1) + "," + (y)+ "]")){
		tempList.add("[" +x + "," + y+ "]");
		getAllRoad(x+1, y, result, tempList);
		tempList.remove("[" +(x) + "," + (y)+ "]");
	}
	
	if(mark[x+1][y-1]!=1&&!tempList.contains("[" +(x+1) + "," + (y-1)+ "]")){
		tempList.add("[" +x + "," + y+ "]");
		getAllRoad(x+1, y-1, result, tempList);
		tempList.remove("[" +(x) + "," + (y)+ "]");
	}
	
	if(mark[x][y-1]!=1&&!tempList.contains("[" +(x) + "," + (y-1)+ "]")){
		tempList.add("[" +x + "," + y+ "]");
		getAllRoad(x, y-1, result, tempList);
		tempList.remove("[" +x + "," + y+ "]");
	}
	
}

}
