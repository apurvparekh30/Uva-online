import java.util.*;

class Main{
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {    
        int tc = scan.nextInt();
        while(tc-- > 0){
            long s1,s2; 
            s1 = scan.nextLong();
            s2 = scan.nextLong();
            long a,b;
            a = (s1+s2)/2;
            b = a - s2;
            if(((s1+s2)%2!=0) || a<0 || b<0)
                System.out.println("impossible");
            else System.out.println(a + " " + b);
        }
    }
}