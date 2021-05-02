import java.util.*;
public class mat {
    public static void main(String[] args) {
        // Scanner scn=new Scanner(System.in);
        // int n=scn.nextInt();
        // int m=scn.nextInt();
        // int k=scn.nextInt();
        // int [][]matrix=new int [n][m];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++)
        //         matrix[i][j]=scn.nextInt();
        // }
        // System.out.println(op(matrix, n, m, k));
        int [][]q={{1,2,100},{2,5,100},{3,4,100}};
        System.out.println(maxcandy(10, q));

    }
    public static int maxcandy(int n,int [][]q){
        int []a=new int[n];
        int max=0;
        for(int []p:q){
            int si=p[0];
            int ei=p[1];
            int k=p[2];
            for(int i=si;i<=ei;i++){
                a[i]+=k;
                max=Math.max(max, a[i]);
            }
        }
        return max; 
    }
    public static int op(int [][]matrix,int n,int m,int k){
        int ctr=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]>k){
                    if(matrix[i][j]%k==0){
                        ctr+=(matrix[i][j]/k-1);
                        System.out.println(matrix[i][j]+" "+(matrix[i][j]/k-1));
                    }
                    else return -1;
                }else if(matrix[i][j]<k){
                    if(k%matrix[i][j]==0){
                        ctr+=(k/matrix[i][j]-1);
                        System.out.println(matrix[i][j]+" "+(k/matrix[i][j]-1));
                    }
                    else return -1;
                }
            }
        }
        return ctr;
    }
}
