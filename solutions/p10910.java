import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int [][]dp;
    static int n,t,p;

    static int rec(int i,int t){
        if(t==0 && i==n)
            return 1;
        if(t < p)
            return 0;
        if(i>=n)
            return 0;
        if(dp[i][t]!=-1)
            return dp[i][t];
        int sum = 0;
        for(int marks = p;marks <= t ; marks++){
            sum+=rec(i+1,t-marks);
        }
        return dp[i][t] = sum;
    }
    public static void main(String[] args) {
        int k = fs.nextInt();
        while(k-- > 0){
            n = fs.nextInt();
            t = fs.nextInt();
            p = fs.nextInt();
            dp = new int[n][t+1];
            for(int []row:dp){
                Arrays.fill(row,-1);
            }
            System.out.println(rec(0,t));
        }
    }
}