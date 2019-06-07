package example1;

public class CycleLinList {
	 int size;
	 Node currentNode;
	 Node headNode;
	
	public CycleLinList() {
		headNode=currentNode=new Node(null);
		size=0;
		headNode.next=headNode;
	}
	
	public Node index(int i) throws Exception {
		if(i>size||i<-1){
			throw new Exception("输入参数大于链表长度或小于-1！");
		}else{
			if(size==0&&i==0){
				return null;
			} 
			currentNode=headNode;
			for (int j = 0; j < i+1; j++) {
				currentNode=currentNode.next;
			}
			return currentNode;
		}
	}
	
	public void insertNode(int i,Object object) throws Exception {

				currentNode=index(i-1);
				Node tempNode=new Node(object,currentNode.next);
				currentNode.setNext(tempNode);
				size++;	
			
	}
	
	public void deleteNode(int i) throws Exception {
		currentNode=index(i-1);
		currentNode.setNext(currentNode.next.next);
		size--;
	}
	
	public void deleteAfterN(int i){
		for (int j = 0; j < i-1; j++) {
			if(currentNode.next.getElement()==null){
				currentNode=currentNode.next;
			}
			currentNode=currentNode.next;
		}
		if(currentNode.next.getElement()==null){
			currentNode.setNext(currentNode.next.next.next);
			headNode.setNext(currentNode.next.next.next);
		}else{
			currentNode.setNext(currentNode.next.next);	
		}
		size--;
	}
	
	
	public  void  outprint() {
		currentNode=headNode;
		System.out.print("链表：");
		for (int i = 0; i < size; i++) {
			currentNode=currentNode.next;
			System.out.print(currentNode.getElement()+" ");
		}
		System.out.println();
	}
}
