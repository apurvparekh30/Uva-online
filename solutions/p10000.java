import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static Map<Integer,List<Integer>> adj;
    static int s;
    static pair dp[];

    static class pair {
        int cost;
        int vertex;
        pair(int c,int v){
            cost = c;
            vertex = v;
        }
    }

    static pair dfs(int u){
        if(dp[u].cost!=-1)
            return dp[u];
        pair ans = new pair(0,u);
        for(int v:adj.get(u)){
            pair curr = dfs(v);
            if(curr.cost > ans.cost){
                ans.cost = curr.cost;
                ans.vertex = curr.vertex;
            }
            else if(curr.cost == ans.cost && ans.vertex > curr.vertex){
                ans.vertex = curr.vertex;
            }
        }
        return dp[u] = new pair(ans.cost+1,ans.vertex);
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
            dp = new pair[n+1];
            Arrays.fill(dp,new pair(-1,-1));
            pair ans = dfs(s);
            
            System.out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n\n",tc,s,ans.cost-1,ans.vertex);
        }
    }
}