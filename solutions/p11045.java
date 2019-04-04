import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n,m;
    static Map<Integer,ArrayList<Integer>> map;
    static int [][]cap;
    static int oo = 987654321;
    static Map<String,Integer> mp = new HashMap<>();
    static int []parent;

    static class state {
        int v,c;
        state(int v,int c){
            this.v = v;
            this.c = c;
        }
    }

    static int bfs(int s,int t){
        Arrays.fill(parent,-1);
        parent[s] = -2;
        Queue<state> q = new ArrayDeque<>();
        q.offer(new state(s,oo));
        while(!q.isEmpty()){
            state curr = q.poll();
            int v = curr.v;
            int c = curr.c;
            for(int next:map.get(v)){
                if(parent[next]==-1 && cap[v][next] > 0){
                    parent[next] = v;
                    int newC = Math.min(c,cap[v][next]);
                    if(next == t)
                        return newC;
                    q.offer(new state(next,newC));
                } 
            }
        }
        return 0;
    }

    static int maxFlow(int s,int t){
        int flow = 0;
        int newFlow = 0;
        while((newFlow = bfs(s,t)) > 0){
            flow = flow + newFlow;
            int cur = t;
            while(cur != s){
                int prev = parent[cur];
                cap[prev][cur] -= newFlow;
                cap[cur][prev] += newFlow;
                cur = prev;
            }
        }
        return flow;
    }

    public static void main(String[] args) {
        mp.put("XS",1);
        mp.put("S",2);
        mp.put("M",3);
        mp.put("L",4);
        mp.put("XL",5);
        mp.put("XXL",6);
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            m = fs.nextInt();
            map = new HashMap<>();
            int w = n / 6;
            cap = new int[8 + m][8 + m];
            parent = new int[8 + m];
            for(int i=0;i<8+m;i++)
                map.put(i,new ArrayList<>());
            for(int i=1;i<=6;i++){
                map.get(0).add(i);
                map.get(i).add(0);
                cap[0][i] = w;
                cap[i][0] = w;
            }
            for(int i=7;i<8+m;i++){
                map.get(i).add(7+m);
                map.get(7+m).add(i);
                cap[i][7+m] = 1;
                cap[7+m][i] = 1;
            }
            for(int i=7;i<7+m;i++){
                for(int j=0;j<2;j++){
                    String s = fs.next();
                    //System.out.println(s);
                    map.get(i).add(mp.get(s));
                    map.get(mp.get(s)).add(i);
                    cap[i][mp.get(s)] = 1;
                    cap[mp.get(s)][i] = 1;
                }
            }
            int flow = maxFlow(0, 7+m);
            //System.out.println(flow);
            if(flow == m){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}