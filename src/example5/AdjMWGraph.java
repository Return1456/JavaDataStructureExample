package example5;

public class AdjMWGraph {
    static final  int maxWeight=10000;

    private  SeqList vertices;
    public int[][] edge;
    private int numOfEdges;
    
    public  AdjMWGraph(int  maxV){
        
        vertices=new SeqList(maxV);
        edge=new int[maxV][maxV];
        for (int i=0;i<maxV;i++){
            for (int j=0;j<maxV;j++){
                if (i==j){
                    edge[i][j]=0;
                }
                else{
                    edge[i][j]=maxWeight;
                }
                
            }
           
        }
        numOfEdges=0;
    }
    
    public int[][] getEdge(){
    	return edge;
    }
    
    public  int  getNumOfVertices(){
        
        return vertices.size;
        
    }
    
    public int getNumOfEdges(){
        return numOfEdges;
    }
    
public Object getValue(int v){
        return vertices.getdata(v);
}

    public  int getWeight(int v1,int v2)throws Exception {
        if(v1<0||v1>=vertices.size||v2<0||v2>=vertices.size) throw new ArrayIndexOutOfBoundsException("参数v1或v2越界出错！");
        
        return edge[v1][v2];
    }
    
    
    public void  insertVertex(Object vertex)throws Exception{
        vertices.insert(vertices.size,vertex);
        
    }
    
    public void inserEdge(int v1,int v2,int weight)throws  Exception{
        if(v1<0||v1>=vertices.size||v2<0||v2>=vertices.size) throw new ArrayIndexOutOfBoundsException("参数v1或v2越界出错！");
        edge[v1][v2]=weight;
        numOfEdges++;
    }
    
    
    public  void  deleteEdge(int v1,int v2) throws Exception {
        if(v1<0||v1>=vertices.size||v2<0||v2>=vertices.size) throw new ArrayIndexOutOfBoundsException("参数v1或v2越界出错！");
        if(edge[v1][v2]==maxWeight||v1==v2)throw  new Exception("该边不存在！");
        
        edge[v1][v2]=maxWeight;
        numOfEdges--;
        
    }
    public  int getFirstNeighbor(int v) throws Exception{
        if(v<0||v>=vertices.size) throw new Exception("参数v越界出错！");
        for(int col=0;col<vertices.size;col++){
            if(edge[v][col]>0&&edge[v][col]<maxWeight)return col;
            
        }
        return  -1;
    }
    
    public int getNextNeighbor(int v1,int v2){
        if(v1<0||v1>=vertices.size||v2<0||v2>=vertices.size) throw new ArrayIndexOutOfBoundsException("参数v1或v2越界出错！");
        for(int col=v2+1;col<vertices.size;col++){
            if(edge[v1][col]>0&&edge[v1][col]<maxWeight)return col;

        }
        return  -1;        
    }
    
    public int getIndegree(int v) throws Exception {//求入度的函数
    	int count=0;
    	for(int i=0;i<vertices.size;i++) {
    		if(i!=v) if(edge[i][v]>0&&edge[i][v]<maxWeight)count++;     
    	   }
    	   return count;
    }
    
    public int getOutdegree(int v)throws Exception{
    	int count =0;
    	for (int i=0;i<vertices.size;i++) {
    		if(i!=v) if(edge[v][i]>0&&edge[v][i]<maxWeight)count++;     
    	}
    	return count;
    }
    
    
}
