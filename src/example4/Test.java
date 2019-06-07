package example4;

public class Test {
	int s=10;
	int[] w=new int[5];
public static void main(String args[]){
	Test a=new Test();
	int[] intArray = { 9, 6, 5, 4, 2 }; 
	System.out.println(a.beibao(intArray, 0, 21));
}


public void out(int[] w ,int sum){
	for (int i = 1; i <= w.length; i++) {
		if (w[i]==sum) {
			System.out.println(w[i]);
		}
	}
}

	public boolean beibao(int[] intArray,int start,int sum){
			if(start >= intArray.length){ 
				return false; 
			} 
			
			if(intArray[start] == sum){ 
				System.out.print(intArray[start]+" ");
				return true; 
			}else if(this.beibao(intArray,start+1,sum-intArray[start])){
				System.out.print(intArray[start]+" ");
				return true; 
			}else if(this.beibao(intArray,start+1,sum)){
				return true; 
			}
			return false;
	}	
	
	}

