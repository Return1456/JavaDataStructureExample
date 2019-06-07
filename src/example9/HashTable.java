package example9;

public class HashTable {
private HashItem[] htHashItems;
private int tableSize;
private int currentSize;

public HashTable(int m) {
	tableSize=m;
	htHashItems=new HashItem[tableSize];
	currentSize=0;
}

public boolean isIn(Data x) {
int i=find(x);
if(i>=0) return true;
else return false;
}

public Data getVal(int i) {
	return htHashItems[i].getData();
}
public int  getInfo(int i) {
	return htHashItems[i].info;
}

public int find(Data x) {
	int i=(13*x.row+17*x.col) % tableSize;
	int j=i;
	if(htHashItems[j]==null) htHashItems[j]=new HashItem(0);
	while(htHashItems[j].info==1&&(htHashItems[j].data.col!=x.col||htHashItems[j].data.row!=x.row||htHashItems[j].data.val!=x.val)){
		j=(j+1)%tableSize;
		if(htHashItems[j]==null) htHashItems[j]=new HashItem(0);//没有这代码会空指针
		if(j==i)return -tableSize;
	}
	if(htHashItems[j].info==1){
		return j;
	}else{
		return -j;
	}
}

public int getCurrentSize() {
	return currentSize;
}

public void setCurrentSize(int currentSize) {
	this.currentSize = currentSize;
}

public int insert(Data x) throws Exception  {
	int i=find(x);
	
	if(i>0){
		throw new Exception("该数据已存在");
	}else if(i!=-tableSize){
		htHashItems[-i]=new HashItem(x,1);
		currentSize++;
		return -i;
	}
	
	else{
		throw new Exception("哈希表已满无法插入");
	}
}

public void delete(Data x) throws Exception {
	int i=find(x);
	
	if(i>=0){
		htHashItems[i].info=0;
		currentSize--;
	}
	else{
		throw new Exception("该数据不存在");
	}
}
}
