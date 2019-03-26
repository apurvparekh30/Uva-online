import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n,m,t;
    static pair dp[];
    static int beer = 0;

    static class pair {
        int t,p;
        pair(int t,int p){
            this.t = t;
            this.p = p;
        }
    }

    static pair rec(int tot){
        //System.out.println(tot);
        if(tot < n && tot < m){
            return new pair(0,tot);
        }
        if(dp[tot]!=null)
            return dp[tot];
        pair a = null,b = null;
        if(tot - m >= 0){
            b = rec(tot-m);
        }
        if(tot - n >= 0){
            a = rec(tot-n);
        }
        pair ans;
        if(a==null){
            ans = new pair(1+b.t,b.p);
        }
        else if(b==null){
            ans = new pair(1+a.t,a.p);
        }
        else if(a.p < b.p){
            ans = new pair(1+a.t,a.p);
        }
        else if(b.p < a.p){
            ans = new pair(1+b.t,b.p);
        }
        else {
            ans = new pair(1 + Math.max(a.t,b.t),a.p);
        }
        return dp[tot] = ans;
    }
    public static void main(String[] args) {
        while(fs.hasNextLine()){
            String nextLine = fs.nextLine();
            StringTokenizer st = new StringTokenizer(nextLine);
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            dp = new pair[t+1];
            pair ans = rec(t);
            System.out.println(ans.t + (ans.p==0 ? "" : " " + ans.p));
        }
    }
}