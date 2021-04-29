import java.util.*;
public class q {
    public static int addnum(int n){
    int m=1;
    int num=n;
    while(num%10==0){
        m=m*10;
        num=num/10;
    }
    int reverse=0;
    while(num != 0)   
{  
int remainder = num % 10;  
reverse = reverse * 10 + remainder;  
num = num/10;  
}  
reverse=reverse*m;
return reverse+n;  
    }
    public static void main(String[] args) {
        System.out.println(addnum(1230));
    }
}

