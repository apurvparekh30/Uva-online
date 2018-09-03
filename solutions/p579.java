import java.util.*;

class Main{
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String inp;
        while(!((inp = scan.nextLine()).equals("0:00"))){
            //System.out.print(inp);
            StringTokenizer s = new StringTokenizer(inp,":");
            double h,m,ha,ma,a;
            h = Double.parseDouble(s.nextToken());
            m = Double.parseDouble(s.nextToken());
            //System.out.println(h + " " + m);
            ha = h*30+(m/60)*30;
            ma = m*6;
            a = ha-ma;
            if(a<0) a*=-1;
            if(a>180) a=360-a;
            System.out.printf("%.3f",a);
            System.out.println();
        } 
    }
}