package example10;


public class Test {
public static void main(String args[]) throws Exception {
	Direction[] directions=new Direction[8];
	directions[0]=new Direction(-1, 0);
	directions[1]=new Direction(-1, 1);
	directions[2]=new Direction(0, 1);
	directions[3]=new Direction(1, 1);
	directions[4]=new Direction(1, 0);
	directions[5]=new Direction(1,-1);
	directions[6]=new Direction(0, -1);
	directions[7]=new Direction(-1,-1);
	
	int n=6,m=6;
int[][] maze=new int[n][m];
int[][] mark=new int[n][m];

for (int i = 0; i < mark.length; i++) {
	for (int j = 0; j < mark.length; j++) {
		if(i==0||j==0||i==n-1||j==m-1){
			maze[i][j]=1;
			mark[i][j]=1;
		}else{
			if(Math.random()>0.5) maze[i][j]=0;
			else maze[i][j]=1;
			
			mark[i][j]=maze[i][j];
		}
	}
}

maze[1][1]=0;
maze[n-2][m-2]=0;
mark[1][1]=0;
mark[n-2][m-2]=0;



for (int i = 0; i < mark.length; i++) {
	for (int j = 0; j < mark.length; j++) {
		System.out.print(maze[i][j]+" ");
	}
	System.out.println();
}


int x=1,y=1,flag=0;
SeqStack stack=new SeqStack(30);
while(mark[n-2][m-2]!=1&&flag<1000){
	if(mark[x+1][y+1]!=1){			
		stack.push(new Trace(x, y, 3));
		mark[x+1][y+1]=1;
		if(x+1==n-2&&y+1==m-2)break;
		x=x+1;
		y++;
	}else if(mark[x-1][y+1]!=1){
		stack.push(new Trace(x, y,1));
		mark[x-1][y+1]=1;
		x=x-1;
		y=y+1;
	}else if(mark[x][y+1]!=1){
		stack.push(new Trace(x, y, 2));
		mark[x][y+1]=1;
		if(x==n-2&&y+1==m-2)break;
		y=y+1;
	}else if(mark[x-1][y]!=1){
		stack.push(new Trace(x, y,0));
		mark[x-1][y]=1;
		x=x-1;
	}else if(mark[x+1][y]!=1){
		stack.push(new Trace(x, y, 4));
		mark[x+1][y]=1;
		if(x+1==n-2&&y==m-2)break;
		x++;
	}else if(mark[x+1][y-1]!=1){
		stack.push(new Trace(x, y, 5));
		mark[x+1][y-1]=1;
		x++;
		y--;
	}else if(mark[x][y-1]!=1){
		stack.push(new Trace(x, y, 6));
		mark[x][y-1]=1;
		y--;
	}else if(mark[x-1][y-1]!=1){
		stack.push(new Trace(x, y, 7));
		mark[x-1][y-1]=1;
		x--;
		y--;
	}else{
		if(stack.notEmpty()){
			Trace trace=(Trace)stack.pop();
			x=trace.x;
			y=trace.y;
		}
	}
	flag++;
}

System.out.println();
for (int i = 0; i < mark.length; i++) {
	for (int j = 0; j < mark.length; j++) {
		System.out.print(mark[i][j]+" ");
	}
	System.out.println();
}

if(mark[n-2][m-2]==0){
	System.out.println("THERE IS NO PATH IN MAZE.");
}else{
System.out.println("Â·¾¶Îª");
Trace trace=(Trace)stack.pop();
System.out.print(trace.dir);
while(stack.notEmpty()){
	Trace trace1=(Trace)stack.pop();
	System.out.print("<"+trace1.dir);
}




}


}


}
