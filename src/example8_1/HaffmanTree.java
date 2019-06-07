package example8_1;
//哈夫曼树类
public class HaffmanTree {
    //最大权值
    static final int MAXVALUE=1000;
    int nodeNum ; //叶子结点个数
    
    public HaffmanTree(int n)
    {
       this.nodeNum = n;
    }
    
    //构造哈夫曼树算法
    public void haffman(int[] weight,HaffNode[] nodes)//权值数组，所有节点数组
    {
        int n = this.nodeNum;
        //m1,m2,表示最小的两个权值，x1,x2,表示最小两个权值对应的编号,m1表示最小，m2表示次小
        int m1,m2,x1,x2; 
        
        //初始化所有的结点，对应有n个叶子结点的哈夫曼树，有2n-1个结点。
        for(int i=0;i < 2*n-1;i++)
        {
            HaffNode temp = new HaffNode();
            //初始化n个叶子结点，就是输入的节点。0、1、2、3是叶子节点也是输入的节点
            if(i < n)
            {
               temp.weight = weight[i];    
            }
            else
            {
               temp.weight = 0;    
            }
            temp.parent = 0;
            temp.flag = 0;
            temp.leftChild = -1;
            temp.rightChild = -1;
            nodes[i] = temp;
        }
        
        for(int i=0;i<n-1;i++){//初始化n-1个非叶子结点，n-1表示要循环n-1次求的n-1个数。
           m1 = m2 = MAXVALUE;
           x1 = x2 =0;
           for(int j=0;j< n+i;j++)//求得这n-1个数时，每次都是从0到n+i-1,并且flag=0的，flag=1表示已经加入到二叉树。
           {   //以下2步是找出权值最小的2个
               if(nodes[j].weight<m1 && nodes[j].flag==0)//if成立了else、else if就不进去了。
               {
                //m1,x1初始值为第一个元素，后面如果比m1要小，则m1指向更小的，原来m1指向的现在由m2指向，
                //如果后面比m1大比m2小，则m2指向这个比m1大比m2小的，
                //也就是说m1指向最小的，m2指向第2小的。
                  m2 = m1;
                  x2 = x1;
                  m1 = nodes[j].weight;
                  x1 = j;
               }
               else if(nodes[j].weight<m2 && nodes[j].flag ==0)
               {
                  m2 = nodes[j].weight;
                  x2 = j;
               }
           }
           //将权值最小的2个组合成一个2插树
           nodes[x1].parent = n+i;
           nodes[x2].parent = n+i;
           nodes[x1].flag = 1;
           nodes[x2].flag = 1;
           nodes[n+i].weight = nodes[x1].weight + nodes[x2].weight;
           nodes[n+i].leftChild = x1;
           nodes[n+i].rightChild = x2;
        }
        /*
        初始化数组之后：[1,3,5,7,4,9,16]
        编码：100、101、11、0
        */
    }
    
    //哈弗曼编码算法
    public void haffmanCode(HaffNode[] nodes,Code[] haffCode)
    {
        int n = this.nodeNum;
        Code code = new Code(n);//4
        int child,parent;
        
        for(int i=0;i<n; i++)//给前面n个输入的节点进行编码
        {
           code.start = n-1;//3
           code.weight = nodes[i].weight;//1
           child = i;//0
           parent = nodes[child].parent;
           //从叶子节点向上走来生成编码，画图即可。
           while(parent!=0)
           {
              if(nodes[parent].leftChild == child)
              {
                  code.bit[code.start] = 0;
              }
              else
              {
                  code.bit[code.start] = 1;
              }
              
              code.start--; 
              child = parent;
              parent = nodes[child].parent;
           }
           
           Code temp = new Code(n);
           for(int j=code.start+1;j < n;j++)
           {
               temp.bit[j] = code.bit[j];
           }
           temp.weight = code.weight;
           temp.start = code.start;
           haffCode[i] = temp;
        }
    }
}