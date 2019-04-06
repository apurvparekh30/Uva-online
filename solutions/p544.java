import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int v,e;
    static Map<String,Integer> map;
    static Map<Integer,List<state>> adj;
    static edge ed[];
    static int []p;
    static int ans;

    static class state {
        int v,c;
        state(int v,int c){
            this.v = v;
            this.c = c;
        }
        @Override
        public String toString() {
            return v + " " + c;
        }
    }

    static class edge implements Comparable<edge> {
        int u,v,c;
        edge(int u,int v,int c){
            this.u = u;
            this.v = v;
            this.c = c;
        }
        @Override
        public int compareTo(edge o) {
            return Integer.compare(o.c,c);
        }
        @Override
        public String toString() {
            return u + " " + v + " " + c;
        }
    }

    static int find(int i){
        return i == p[i] ? i : (p[i] = find(p[i]));
    }

    static boolean dfs(int u,int v,int p,int wt){
        if(u==v){
            ans = wt;
            return true;
        }
        for(state j:adj.get(u)){
            if(j.v !=p){
                if(dfs(j.v,v,u,Math.min(wt,j.c)))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int tc = 0;
        while(true){
            tc++;
            v = fs.nextInt();
            e = fs.nextInt();
            if(v==0 && e==0)
                break;
            adj = new HashMap<>();
            map = new HashMap<>();
            ed = new edge[e];
            p = new int[v];
            for(int i=0;i<v;i++){
                p[i] = i;
                adj.put(i,new ArrayList<>());
            }
                
            int n = 0;
            for(int i=0;i<e;i++){
                String u = fs.next();
                String v = fs.next();
                if(!map.containsKey(u)){
                    map.put(u,n++);
                }
                if(!map.containsKey(v)){
                    map.put(v,n++);
                }
                int uu = map.get(u);
                int vv = map.get(v);
                int c = fs.nextInt();
                ed[i] = new edge(uu,vv,c);
            }
            //System.out.println(Arrays.toString(ed));
            Arrays.sort(ed);
            for(int i=0;i<e;i++){
                int x = find(ed[i].u);
                int y = find(ed[i].v);
                if(x!=y){
                    p[y] = x;
                    adj.get(ed[i].u).add(new state(ed[i].v,ed[i].c));
                    adj.get(ed[i].v).add(new state(ed[i].u,ed[i].c));
                }
            }
            int u = map.get(fs.next());
            int v = map.get(fs.next());
            if(u > v) {
                int temp = u;
                u = v;
                v = temp;
            }
            //System.out.println(map);
            //System.out.println(adj);
            //System.out.println( u + " " + v);
            System.out.println("Scenario #"+tc);
            dfs(u,v,u,Integer.MAX_VALUE);
            System.out.println(ans + " tons\n");
        }
    }
}