import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static Map<Integer,List<Integer>> adj;
    static int n;
    static int []dp;
    static boolean []done;
    
    static int dfs(int i){
        done[i] = true;
        int ans = 0;
        if(dp[i]!=-1){
            return dp[i];
        }
            
        for(int v:adj.get(i)){
            if(!done[v]){
                ans += dfs(v);
            }
        }
        return ans+1;
    }

    public static void main(String[] args) {
        while(true){
            int n = fs.nextInt();
            if(n==0)
                break;
            adj = new HashMap<>();
            for(int i=1;i<=n;i++){
                adj.put(i,new ArrayList<>());
                int t = fs.nextInt();
                while(t-- > 0){
                    int v = fs.nextInt();
                    adj.get(i).add(v);
                }
            }
            dp = new int[n+1];
            Arrays.fill(dp,-1);
            int max = 0;
            int at = -1;
            for(int i=1;i<=n;i++){
                if(dp[i]==-1){
                    done = new boolean[n+1];
                    int curr = dfs(i);
                    System.out.println(i + " " + curr);
                    if(curr > max){
                        max = curr;
                        at = i;
                    }
                }
            }
            
            System.out.println(at);
        }
    }
}