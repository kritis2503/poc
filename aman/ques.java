import java.util.*;

public class ques {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        String line = sc.nextLine();
        int n=Integer.parseInt(line);

        String[] tokens = new String[n];
        for (int i=0; i<n; i++){
            tokens[i]=sc.nextLine();
        }
        String[] lmao=tokens[0].split(" ");
        int m=lmao.length;   
        int[][] arr=new int[n][m];
        for(int i=0; i<n; i++){
            lmao=tokens[i].split(" ");
            for(int j=0; j<m; j++){
                arr[i][j]=Integer.parseInt(lmao[j]);
            }
        }
        // for(int i=0;i<n;i++){
            // for(int j=0;j<m;j++){
                // System.out.print(arr[i][j]);
            // }
            // System.out.println();
        // }
        int []rowsum=new int [n];
        int []colsum=new int [m];
        int ctrZero=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0)
                    ctrZero++;
            }
        }
        int totEle=n*m;
        if(ctrZero<totEle)
            System.out.println("-1");
        else{

            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=0;j<m;j++)
                    sum+=arr[i][j];
                rowsum[i]=sum;
            }
            for(int j=0;j<n;j++){
                int sum=0;
                for(int i=0;i<n;i++)
                    sum+=arr[i][j];
                colsum[j]=sum;
            }
        
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]==0)
                        change(arr,i,j,rowsum,colsum);
                }
            }
            
        
        }
    }
    public static void change(int [][]arr,int i,int j,int []rowsum,int []colsum){
        if(rowsum[i]<=colsum[j]){
            if(arr[i][j]%2==0)
                arr[i][j]=2;
            else
                arr[i][j]=1;
        }
        else{
            if(arr[i][j]%3==0)
                arr[i][j]=3;
            else{
                arr[i][j]=3-(arr[i][j]%3);
            }
        }
    }

}
