package example8;

public class Test {
public static void  main(String args[]) {
	int n=4;
	HaffmanTree myHaffmanTree=new HaffmanTree(n);
	int[] weight={1,3,5,7};
	HaffNode[] node=new HaffNode[2*n+1];
	Code[] haffCode=new Code[n];
	
	myHaffmanTree.haffman(weight, node);
	myHaffmanTree.haffmanCode(node, haffCode);
	
	for (int i = 0; i < n; i++) {
		System.out.print("Weight= "+haffCode[i].weight+" Code= ");
		for (int j = haffCode[i].start+1; j < n; j++) {
			System.out.print(haffCode[i].bit[j]);
		}
		System.out.println();
	}
}
}
