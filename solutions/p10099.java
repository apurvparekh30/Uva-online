import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n,m;
    static int s,t,d;
    static edge ed[];
    static Map<Integer,List<state>> adj;
    static int []p;

    static int find(int i){
        return (i==p[i] ? i : (p[i] = find(p[i])));
    }

    static class state{
        int u,c,p;
        state(int u,int c,int p){
            this.u = u;
            this.c = c;
            this.p = p;
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
            return Integer.compare(o.c,this.c);
        }
    }
    public static void main(String[] args) {
        int tc = 0;
        while(true){
            tc++;
            int n = fs.nextInt();
            int m = fs.nextInt();
            if(n==0 && m==0)
                break;
            ed = new edge[m];
            adj = new HashMap<>();
            p = new int[n+1];
            for(int i=1;i<=n;i++){
                adj.put(i,new ArrayList<>());
                p[i] = i;
            }
                
            for(int i=0;i<m;i++){
                int u,v,c;
                u = fs.nextInt();
                v = fs.nextInt();
                c = fs.nextInt();
                ed[i] = new edge(u,v,c);
            }

            
            s = fs.nextInt();
            d = fs.nextInt();
            t = fs.nextInt();

            Arrays.sort(ed);
            for(int i=0;i<m;i++){
                int x = find(ed[i].u);
                int y = find(ed[i].v);
                if(x!=y){
                    p[y] = x;
                    adj.get(ed[i].u).add(new state(ed[i].v,ed[i].c,-1));
                    adj.get(ed[i].v).add(new state(ed[i].u,ed[i].c,-1));
                }
            }

            Queue<state> q = new ArrayDeque<>();
            q.offer(new state(s,Integer.MAX_VALUE,-1));
            int cap = -1;
            while(!q.isEmpty()){
                state curr = q.poll();
                int u = curr.u;
                int c = curr.c;
                int p = curr.p;
                if(u==d){
                    cap = c-1;
                    break;
                }

                for(state next:adj.get(u)){
                    if(next.u!=p){
                        int newC = Math.min(c,next.c);
                        q.offer(new state(next.u,newC,u));
                    }
                }
            }
            int ans = t/cap;
            if(t%cap!=0)
                ans++;
            System.out.println("Scenario #" + tc);
            System.out.println("Minimum Number of Trips = " + ans);
            System.out.println();
        }
    }
}