package example5;

public class SeqList {
int maxsize;
int size=0;
Object[] ListArray;

public SeqList(int i) {
	maxsize=i;
	ListArray=new Object[i];
}
public SeqList() {
	maxsize=10;
	ListArray=new Object[10];
}

public static int index(SeqList list,Object obj) {
	for(int i=0;i<list.size;i++) {
		if ((int)list.ListArray[i]==(int)obj) {
			return i;
		}
	}
	return -1;
}
public void insert(int i,Object obj) throws Exception {
	if(i<-1||i>size -1) {
 
	}
	if (i<0||i>size) {
		throw new Exception("参数错误！");
	}
	for(int j=size;j>i;j--) {
		ListArray[j]=ListArray[j-1];
	}
	ListArray[i]=obj;
	size++;
}


public Object delete(int i) throws Exception {
	if (i<0||i>size) {
		throw new Exception("参数错误！");
	}
   Object aaa= ListArray[i-1];
	for(int j=i-1;j<size-1;j++) {
		ListArray[j]=ListArray[j+1];
	}
		size--;
		
		return aaa;
}
 



public static void updown(SeqList list1) {
	Object temp;
	if(list1.size%2==0) {
		for(int i=0;i<list1.size/2;i++) {
			temp=list1.ListArray[i];
			list1.ListArray[i]=list1.ListArray[list1.size-i-1];
			list1.ListArray[list1.size-i-1]=temp;
		}
		}
	}
public Object  getdata(int i) {
	return ListArray[i];
}
}



