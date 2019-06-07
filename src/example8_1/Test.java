package example8_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {

    public static void main(String[] args) {
    	
    	
    	
    	List<Character> list=new ArrayList<Character>();
    	
    	for (int i = 65; i < 91; i++) {
			Character character=new Character();
			character.c=(char)i;
			list.add(character);
		}
    	
    	System.out.println("请输入大写字母的字符串（以回车结束输入）：  ");
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        for (int i = 0; i <string.length(); i++) {
        	for (Character cha:list) {
				if (cha.c==string.charAt(i)) {
					cha.num++;
				}
			}
		}
        int charNum=0;
    	for (Character cha:list) {
    		if(cha.num>0)charNum++;
		}
    	
    	
        int[] weight=new int[charNum];
        for (int i = 0; i < weight.length; i++) {
        	for (Character cha:list) {
        		if(cha.num>0&&cha.flag==0){
        			weight[i]=cha.num;
        			cha.flag=1;
        			break;
        		}
    		}
		}
        
   
        HaffmanTree haffTree = new HaffmanTree(charNum);
        HaffNode[] nodes = new HaffNode[2*charNum-1];
        Code[] codes = new Code[charNum]; 
        //构造哈夫曼树
        haffTree.haffman(weight, nodes);
        //生成哈夫曼编码
        haffTree.haffmanCode(nodes, codes);
        
        //打印哈夫曼编码
        for(int i=0;i<charNum;i++)
        {   	
        	for (Character cha:list) {
        		if(cha.num==codes[i].weight&&cha.flag1==0){
        			cha.code=codes[i];
        			System.out.print("Character="+cha.c+" Weight="+codes[i].weight+" Code=");
        			 for(int j=codes[i].start+1;j<charNum;j++)
        	            {
        	               System.out.print(codes[i].bit[j]);    
        	            }
        			cha.flag1=1;
        			break;
        		}
        		
			}
        	
        	System.out.println();
     
        }
        
        System.out.println("编码结果为：");
        for (int i = 0; i < string.length(); i++) {
        	for (Character cha:list){
        		if(string.charAt(i)==cha.c){
        			 cha.codeString="";
       			 for(int j=cha.code.start+1;j<charNum;j++)
 	            {
 	               System.out.print(cha.code.bit[j]);    
 	              cha.codeString=cha.codeString+cha.code.bit[j];
 	            }
        		}
        	}
			
		}
        System.out.println("\n请输入码");
        String codeString=scanner.nextLine();
        
        System.out.print("\n解码得：");
        int flag=0;
        while(codeString.length()>0&&flag<50){
            for (int i = 0; i < codeString.length()+1; i++) {
                    for(Character cha:list){
                    	if(codeString.substring(0, i).equals(cha.codeString)){
                    		System.out.print(cha.c);
                    		codeString=codeString.substring(i,codeString.length());
                    		break;
                    	}
                    }
    		}
            flag++;
        }


    }

}