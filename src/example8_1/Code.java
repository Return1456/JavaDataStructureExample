package example8_1;
public class Code {

    int[] bit;  //编码的数组
    int start;  //编码的开始下标
    int weight; //权值
    Code(int n){
        bit = new int[n];
        start = n-1;
    }
}