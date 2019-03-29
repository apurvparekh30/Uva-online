import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int []arr;
    static int n,t;
    static int dp[][];
    static String exp = "";

    static int rec(int i,int sum,String e) {
        //System.out.println(sum);
        if(sum==t && i==n){
            exp = e + "=" + t;
            return 1;
        }
        if(i>=n){
            return 0;
        }
        if(dp[i][sum+32000]!=-1)
            return dp[i][sum+32000];
        dp[i][sum+32000] = 0;
        if(sum + arr[i] <= 32000 && sum + arr[i] >= -32000){
            if(rec(i+1,sum+arr[i],e+"+"+arr[i])==1){
                return dp[i][sum+32000] = 1;
            }
        }
        if(sum - arr[i] <= 32000 && sum - arr[i] >= -32000){
            if(rec(i+1,sum-arr[i],e+"-"+arr[i])==1){
                return dp[i][sum+32000] = 1;
            }
        }
        if(sum * arr[i] <= 32000 && sum * arr[i] >= -32000){
            if(rec(i+1,sum*arr[i],e+"*"+arr[i])==1){
                return dp[i][sum+32000] = 1;
            }
        }
        if(arr[i]!=0 && sum % arr[i] == 0){
            if(rec(i+1,sum/arr[i],e+"/"+arr[i])==1)
                return dp[i][sum+32000] = 1;
        }
        return dp[i][sum+32000];
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            arr = new int[n];
            dp = new int[n][64001];
            for(int []r:dp){
                Arrays.fill(r,-1);
            }
            for(int i=0;i<n;i++){
                arr[i] = fs.nextInt();
            }
            t = fs.nextInt();
            int ans = rec(1,arr[0],""+arr[0]);
            if(ans == 0){
                System.out.println("NO EXPRESSION");
            }
            else {
                System.out.println(exp);
            }
        }
    }
}