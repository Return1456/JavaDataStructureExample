package example9;

public class HashItem {
Data data;
 int info;
 
public HashItem(int i) {
this.info=i;
}
 
 public HashItem(Data data,int i) {
	 this.info=i;
	 this.data=data;
}
 
 public Data getData() {
	if(data!=null){ 
		return data;
	}
	else {
		return null;
	}
}
}
