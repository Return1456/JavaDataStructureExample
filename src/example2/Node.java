package example2;
public class Node{
	Object data;
	Node next;
	
	Node(Node nextval){
		next=nextval;
	}
	
	Node(Object obj,Node nextval){
		data = obj;
		next=nextval;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node nextval) {
		next=nextval;
	}
	

	
	public void setElement(Object obj) {
		data=obj;
	}

	public Object getElement() {
		return data;
	}


}