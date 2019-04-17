import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static int [][]dp;
    static int []weight;
    static int []cap;

    static int rec(int i,int w){
        if(i==n)
            return 0;
        if(w<=0)
            return 0;
        if(dp[i][w] != -1)
            return dp[i][w];
        int ans = 0;
        if(weight[i] <= w){
            ans = 1 + Math.max(ans,rec(i+1,Math.min(w-weight[i],cap[i])));
        }
        ans = Math.max(ans,rec(i+1,w));
        return dp[i][w] = ans;
    }
    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n==0)
                break;
            weight = new int[n];
            cap = new int[n];
            dp = new int[n][6001];
            for(int i=0;i<n;i++){
                weight[i] = fs.nextInt();
                cap[i] = fs.nextInt();
            }
            for(int []r:dp){
                Arrays.fill(r,-1);
            }
            int ans = rec(0,6000);

            System.out.println(ans);
        }
    }
}