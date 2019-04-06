import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int v,e;
    static Map<String,Integer> map;
    static edge []ed;
    static int []p;
    

    static class edge implements Comparable<edge> {
        int u,v,c;
        edge(int u,int v,int c){
            this.u = u;
            this.v = v;
            this.c = c;
        }
        @Override
        public int compareTo(edge o) {
            return Integer.compare(c, o.c);
        }
    }

    static int find(int i){
        return i == p[i] ? i : (p[i] = find(p[i]));
    }

    public static void main(String[] args) {
        while(true){
            v = fs.nextInt();
            e = fs.nextInt();
            if(v==0 && e==0)
                break;
            map = new HashMap<>();
            ed = new edge[e];
            p = new int[v];
            for(int i=0;i<v;i++)
                p[i] = i;
            
            for(int i=0;i<v;i++){
                String st = fs.next();
                map.put(st,i);
            }
            for(int i=0;i<e;i++){
                int u = map.get(fs.next());
                int v = map.get(fs.next());
                int c = fs.nextInt();
                ed[i] = new edge(u,v,c);
            }
            fs.next();
            edge min = null; 
            /* int xx = map.get(fs.next());
            for(int i=0;i<e;i++){
                if(xx == ed[i].u || xx == ed[i].v){
                    if(min == null || min.c > ed[i].c)
                        min = ed[i];
                }
            }
            if(min==null){
                System.out.println("Impossible");
                continue;
            }
            int cost = min.c;
            p[min.v] = min.u; */
            Arrays.sort(ed);
            int cost = 0;
            int cc = v;
            for(int i=0;i<e;i++){
                int x = find(ed[i].u);
                int y = find(ed[i].v);
                if(x!=y){
                    p[y] = x;
                    cost += ed[i].c;
                    cc--;
                }
            }
            if(cc==1)
                System.out.println(cost);
            else 
                System.out.println("Impossible");
        }
    }
}