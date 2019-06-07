package example8;

public class HaffmanTree {
static final int maxValue=10000;
private int nodeNum;

public HaffmanTree(int n){
	nodeNum=n;
}

public void haffman(int[] weight,HaffNode[] node) {
	int m1,m2,x1,x2;
	int n=nodeNum;
	
	for (int i = 0; i < 2*n-1; i++) {
		HaffNode temp=new HaffNode();
		if (i<n) {
			temp.weight=weight[i];	
		}else{
			temp.weight=0;
		}
		temp.parent=0;
		temp.flag=0;
		temp.leftchild=-1;
		temp.rightchild=-1;
		node[i]=temp;
	}
	for (int i = 0; i < n-1; i++) {
		m1=m2=maxValue;
		x1=x2=0;
		for (int j = 0; j < n+i; j++) {
			if (node[j].weight<m1&&node[j].flag==0) {
				m2=m1;
				x2=x1;
				m1=node[j].weight;
				x1=j;
			}else if(node[j].weight<m2&&node[j].flag==0){
				m2=node[j].weight;
				x2=j;
			}
		}
		node[x1].parent=n+i;
		node[x2].parent=n+i;
		node[x1].flag=1;
		node[x2].flag=1;
		node[n+i].weight=node[x1].weight+node[x2].weight;
		node[n+i].leftchild=x1;
		node[n+i].rightchild=x2;
		
	}
		
}

public void haffmanCode(HaffNode[] node,Code[] haffCode) {
	int n=nodeNum;
	Code cd=new Code(n);
	int child,parent;
	for (int i = 0; i < n; i++) {
		cd.start=n-1;
		cd.weight=node[i].weight;
		child=i;
		parent=node[child].parent;
	
	while(parent!=0){
		if (node[parent].leftchild==child) {
			cd.bit[cd.start]=0;
		}else{
			cd.bit[cd.start]=1;
		}
		cd.start--;
		child=parent;
		parent=node[child].parent;
	}
	
	Code tempCode=new Code(n);
	
	for (int j = cd.start+1; j < n ; j++) {
		tempCode.bit=cd.bit;
	}
	tempCode.start=cd.start;
	tempCode.weight=cd.weight;
	haffCode[i]=tempCode;
	
	
	}
	
	
	
	
}




}
