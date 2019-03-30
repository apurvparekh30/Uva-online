import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static String[][] dp;

    static String add (String aa,String bb){
        char []a = aa.toCharArray();
        char []b = bb.toCharArray();
        
        int carry = 0;
        int n = a.length-1;
        int m = b.length-1;
        StringBuilder sb = new StringBuilder();
        while(n>=0 || m>=0){
            int u = (n >= 0) ? a[n] - '0' : 0;
            int v = (m >= 0) ? b[m] - '0' : 0;
            int sum = u + v + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            n--;
            m--;
        }
        if(carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    static String rec(int n,int b){
        if(n <= 1){
            return "1";
        }
        if(!dp[n][b].equals("-1"))
            return dp[n][b];
        String sum = "1";
        for(int i=1;i<=b;i++){
            sum = add(sum,rec(n-i,b));
        }
        dp[n][b] = sum;
        return dp[n][b];
    }


    public static void main(String[] args) {
        dp = new String[61][61];
        for(String []row:dp){
            Arrays.fill(row,"-1");
        }
        /* Arrays.fill(dp[0], "1");
        Arrays.fill(dp[1], "1");
        for(int i=0;i<61;i++){
            dp[i][0] = "1";
        }
        for (int n = 2; n < 61; n++) {
            for (int b = 1; b < 61; b++) {
                String count = "0";
                for (int j = 1; j <= b; j++) {
                    int idx = Math.max(n - j, 0);
                    count = add(count,dp[idx][b]);
                }
                dp[n][b] = add(count,"1");
            }
        } */
        int tc = 0;
        while (true) {
            tc++;
            int n = fs.nextInt();
            int b = fs.nextInt();
            if (n > 60)
                break;
            System.out.println("Case " + tc + ": " + rec(n,b));
        }
    }
}