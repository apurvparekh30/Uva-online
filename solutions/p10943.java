import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n,k;
    static int [][]dp;
    static final int mod = 1000000;

    static int rec(int n,int k){
        if(k==0)
            return 1;
        if(n==0)
            return 1;
        if(dp[n][k]!=-1)
            return dp[n][k];
        int ans = 0;
        for(int i=0;i<=n;i++){
            ans = (ans % mod  + rec(n-i,k-1) % mod) % mod;
        }
        return dp[n][k] = ans;
    }
    public static void main(String[] args) {
        dp = new int[101][101];
        for(int []r:dp){
            Arrays.fill(r,-1);
        }
        while(true){
            n = fs.nextInt();
            k = fs.nextInt();
            if(n==0 && k==0)
                break;
            System.out.println(rec(n,k-1)); 
        }
    }
}