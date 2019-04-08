import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int v,e;
    static int []p;
    static edge ed[];
    static int cc;
    static List<edge> list;


    static int find(int i){
        return (i==p[i] ? i : (p[i] = find(p[i])));
    }
    
    static class edge implements Comparable<edge> {
        int u,v,c;
        boolean on = true;
        edge(int u,int v,int c){
            this.u = u;
            this.v = v;
            this.c = c;
        }
        @Override
        public int compareTo(edge o) {
            return Integer.compare(this.c,o.c);
        }
        @Override
        public String toString() {
            return u + " " + v + " " + c + " "+on;
        }
    }

    static int kruskal(boolean flag){
        
        int cost = 0;
        for(int i=0;i<e;i++){
            if(ed[i].on){
                int x = find(ed[i].u);
                int y = find(ed[i].v);
                if(x!=y){
                    p[y] = x;
                    cc--;
                    if(flag) list.add(ed[i]);
                    cost = cost + ed[i].c;
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            v = fs.nextInt();
            e = fs.nextInt();
            ed = new edge[e];
            p = new int[v+1];
            for(int i=1;i<=v;i++){
                p[i] = i;
            }
            for(int i=0;i<e;i++){
                int u,v,c;
                u = fs.nextInt();
                v = fs.nextInt();
                c = fs.nextInt();
                ed[i] = new edge(u,v,c);
            }
            Arrays.sort(ed);
            list = new ArrayList<>();
            cc = v;
            int cost = kruskal(true);

            if(cc!=1){
                System.out.printf("Case #%d : No way\n",tt);
                continue;
            }
            else {
                cost = Integer.MAX_VALUE;
                for(edge e:list){
                    e.on = false;
                    //System.out.println(Arrays.toString(ed));
                    p = new int[v+1];
                    for(int i=1;i<=v;i++)
                        p[i] = i;
                    cc = v;
                    int curr = kruskal(false);
                    //System.out.println(e + " " + cc + " " + curr);
                    if(cc==1 && cost > curr){
                        cost = curr;
                    }
                    e.on = true;
                }
                if(cost == Integer.MAX_VALUE){
                    System.out.printf("Case #%d : No second way\n",tt);
                }
                else {
                    System.out.printf("Case #%d : %d\n",tt,cost);
                }
            }
        }
    }
}