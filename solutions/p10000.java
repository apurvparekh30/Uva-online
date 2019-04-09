import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static Map<Integer,List<Integer>> adj;
    static int s;
    static int dp[];
    static int t;
    static int []next;

    static int dfs(int u){
        if(dp[u]!=-1)
            return dp[u];
        int ans = 0;
        for(int v:adj.get(u)){
            int curr = dfs(v);
            if(curr >= ans){
                if(ans == curr){
                    if(next[u] > v)
                        next[u] = v;
                }
                else {
                    ans = curr;
                    next[u] = v;
                }
            }
        }
        return dp[u] = 1 + ans;
    }

    static class state {
        int u,c;
        state(int u,int c){
            this.u = u;
            this.c = c;
        }
    }

    static int bfs(){
        Queue<state> q = new ArrayDeque<>();
        q.offer(new state(s,0));
        int longest = 0;

        while(!q.isEmpty()){
            state curr = q.poll();
            if(dp[curr.u] < curr.c){
                dp[curr.u] = curr.c;
                if(longest < curr.c){
                    longest = curr.c;
                    t = curr.u;
                }
                else if(longest == curr.c && t > curr.u){
                    t = curr.u;
                }
                for(int v:adj.get(curr.u)){
                    q.offer(new state(v,curr.c+1));
                }
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int tc = 0;
        boolean line = false;
        while(true){
            tc++;
            n = fs.nextInt();
            if(n==0)
                break;
            adj = new HashMap<>();
            s = fs.nextInt();
            for(int i=1;i<=n;i++)
                adj.put(i,new ArrayList<>());
            while(true){
                int u,v;
                u = fs.nextInt();
                v = fs.nextInt();
                if(u==0 && v==0)
                    break;
                adj.get(u).add(v);
            }
            dp = new int[n+1];
            Arrays.fill(dp,-1);
            next = new int[n+1];
            //int ans = dfs(s)-1;
            int ans = bfs();
            /* int curr = s;
            while(curr!=0){
                t = curr;
                curr = next[curr];
            } */
            System.out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n\n",tc,s,ans,t);
        }
    }
}