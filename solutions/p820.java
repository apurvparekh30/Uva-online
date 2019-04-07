import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static Map<Integer,List<Integer>> map;
    static int [][]cap;
    static int n;
    static int parent[];

    static class state {
        int u,c;
        state(int u,int c){
            this.u = u;
            this.c = c;
        }
    }

    
    static int bfs(int s,int t){
        Arrays.fill(parent,-1);
        parent[s] = -2;
        Queue<state> q = new ArrayDeque<>();
        q.offer(new state(s,Integer.MAX_VALUE));
        while(!q.isEmpty()){
            state curr = q.poll();
            int u = curr.u;
            int c = curr.c;
            if(u == t)
                return c;
            for(int v:map.get(u)){
                if(parent[v]==-1 && cap[u][v] > 0){
                    parent[v] = u;
                    int newC = Math.min(c,cap[u][v]);
                    q.offer(new state(v,newC));
                }
            }
        }
        return 0;
    }
    
    static int maxFlow(int s,int t){
        int flow = 0;
        int newFlow = 0;
        while((newFlow = bfs(s,t)) > 0){
            int cur = t;
            while(cur!=s){
                int prev = parent[cur];
                cap[prev][cur] -= newFlow;
                cap[cur][prev] += newFlow;
                cur = prev;
            }
            flow = flow + newFlow;
        }
        return flow;
    }
    public static void main(String[] args) {
        int tc = 0;
        while(true){
            tc++;
            n = fs.nextInt();
            if(n==0)
                break;
            map = new HashMap<>();
            cap = new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                map.put(i,new ArrayList<>());
            }
            int s = fs.nextInt();
            int t = fs.nextInt();
            int c = fs.nextInt();

            while(c-- > 0){
                int u,v,ct;
                u = fs.nextInt();
                v = fs.nextInt();
                ct = fs.nextInt();
                map.get(u).add(v);
                map.get(v).add(u);
                cap[u][v] += ct;
                cap[v][u] += ct;
            }
            //System.out.println(s + " " + t + " " + map);
            parent = new int[n+1];
            int flow = maxFlow(s,t);
            System.out.println("Network " + tc);
            System.out.println("The bandwidth is " + flow +".");
            System.out.println();
        }

    }
}