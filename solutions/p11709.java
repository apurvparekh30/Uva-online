import java.util.*;

class Main {
    static Scanner fs = new Scanner(System.in);
    static int p,t;
    static Map<String,Integer> map;
    static Map<Integer,ArrayList<Integer>> adj;

    static int []dfsNum,dfsLow;
    static boolean []visited;
    static int scc = 0;
    static int counter;
    static Stack<Integer> st;

    static void dfs(int u){
        dfsLow[u] = dfsNum[u] = counter++;
        visited[u] = true;
        st.push(u);
        for(int v:adj.get(u)){
            if(dfsNum[v]==-1)
                dfs(v);
            if(visited[v]){
                dfsLow[u] = Math.min(dfsLow[u],dfsLow[v]);
            }
        }
        if(dfsLow[u] == dfsNum[u]){
            scc++;
            while(true){
                int v = st.pop();
                visited[v] = false;
                if(v == u)
                    break;
            }
        }
    }

    public static void main(String[] args) {
        while(true){
            p = fs.nextInt();
            t = fs.nextInt();
            if(p == 0 && t==0)
                break;
            map = new HashMap<>();
            adj = new HashMap<>();
            fs.nextLine();
            int n = 0;
            for(int i=0;i<p;i++){
                String name = fs.nextLine();
                map.put(name,n++);
                adj.put(map.get(name),new ArrayList<>());
            }
            for(int i=0;i<t;i++){
                int u = map.get(fs.nextLine());
                int v = map.get(fs.nextLine());
                adj.get(u).add(v);
            }

            dfsNum = new int[p];
            Arrays.fill(dfsNum,-1);
            dfsLow = new int[p];
            visited = new boolean[p];
            scc = 0;
            counter = 0;
            st = new Stack<>();
            for(int i=0;i<p;i++){
                if(dfsNum[i]==-1){
                    dfs(i);
                }
            }
            System.out.println(scc);
        }
    }
}