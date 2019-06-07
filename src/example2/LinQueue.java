package example2;

public class LinQueue {
	Node headNode;
	Node tailNode;
	int count;
	
	public LinQueue() {
		headNode=tailNode=null;
		count=0;
	}
	
	public void append(Object object){
		Node tempNode=new Node(object,null);
		if(tailNode==null){
			headNode=tempNode;
			tailNode=tempNode;
		}else{
			tailNode.next=tempNode;
			tailNode=tempNode;
		}
		count++;
	}
	
	public Object getFront() {
		if(headNode==null){
			return null;
		}else{
			Node temNode=new Node(null);
			temNode=headNode;
			headNode=headNode.next;
			if(headNode==null){
				tailNode=null;
			}
			count--;
			return temNode.getElement();
		}
	}
}
