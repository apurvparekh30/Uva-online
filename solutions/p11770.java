import java.util.*;

class Main {
    static Scanner fs = new Scanner(System.in);
    static int n,m;
    static HashMap<Integer,List<Integer>> adj;
    static Stack<Integer> stack;
    static boolean visited[];
    static int []dfsNum;
    static int []dfsLow;
    static int counter = 0;
    static int cc = 0;
    static int id[];

    static void dfs(int u){
        dfsLow[u] = dfsNum[u] = counter++;
        stack.push(u);
        visited[u] = true;

        for(int v:adj.get(u)){
            if(dfsNum[v]==-1){
                dfs(v);
            }
            if(visited[v]){
                dfsLow[u] = Math.min(dfsLow[u],dfsLow[v]);
            }
        }
        if(dfsLow[u] == dfsNum[u]){
            cc++;
            while(true){
                int v = stack.pop();
                id[v] = cc;
                visited[v] = false;
                if(u==v)
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            n = fs.nextInt();
            m = fs.nextInt();
            adj = new HashMap<>();
            for(int i=0;i<n;i++)
                adj.put(i,new ArrayList<>());
            stack = new Stack<>();
            visited = new boolean[n];
            dfsNum = new int[n];
            Arrays.fill(dfsNum,-1);
            dfsLow = new int[n];
            id = new int[n];
            counter = 0;
            cc = 0;
            for(int i=0;i<m;i++){
                int u = fs.nextInt() - 1;
                int v = fs.nextInt() - 1;
                adj.get(u).add(v);
            }
            for(int i=0;i<n;i++){
                if(dfsNum[i]==-1){
                    dfs(i);
                }
            }
            boolean []root = new boolean[cc+1];
            Arrays.fill(root,true);
            for(int i=0;i<n;i++){
                for(int v:adj.get(i)){
                    if(id[i]!=id[v]){
                        root[id[v]] = false;
                    }
                }                
            }
            int count = 0;
            for(int i=0;i<cc;i++)
                if(root[i])
                    count++;
            System.out.printf("Case %d: %d\n",tt,count);
        }
    }
}