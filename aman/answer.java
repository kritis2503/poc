import java.util.*;

public class answer{
    public static void main(String[] args) {
       
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();

        boolean flag=false;
        String ans="";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a'|| ch=='e' || ch=='i'|| ch=='o' || ch=='u'||ch=='A'|| ch=='E' || ch=='I'|| ch=='O' || ch=='U'){
                int res=change(i);
                char c=(char)(res+'0');
                ans+=(c+"");
                flag=true;
            }
            else
                ans+=(ch+"");
        }
        if(flag)
            System.out.println(ans);
        else System.out.println("-1");

    }
    public static int change(int idx){
        int product=idx*5;
        int sum=0;

        for(int i=1;i<=product;i+=2)
            sum+=i;
        return digSum(sum);
        
    }
    public static int digSum(int n)
    {
        int sum = 0;
 
        // Loop to do sum while
        // sum is not less than
        // or equal to 9
        while (n > 0 || sum > 9)
        {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}