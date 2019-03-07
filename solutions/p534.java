import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int []x,y;
    static int n;
    static int []p;
    static ArrayList<Edge> edges;
    static ArrayList<Edge> list[];
    static final int oo = 987654321;
    static int tc = 0;
    static boolean []done;

    static int find(int i){
        return (p[i]==i) ? i: (p[i] =find(p[i]));
    }


    static double d(int x1,int x2,int y1,int y2){
        return Math.hypot(x1-x2, y1-y2);
    }

    static class Edge implements Comparable<Edge> {
        int u,v;
        double w;
        Edge(int u,int v,double w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.w,o.w);
        }
        @Override
        public String toString() {
            return u + " " + v + " " + w;
        }
    }

    static boolean rec(int u,double d){
        done[u] = true;
        if(u==1){
            System.out.println("Scenario #"+tc);
            System.out.printf("Frog Distance = %.3f\n\n",d);
            return true;
        }
            
        int max = -1;
        for(Edge e:list[u]){
            if(done[e.v])
                continue;
            if(rec(e.v,Math.max(d,e.w)))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n==0)
                break;
            tc++;
            x = new int[n];
            y = new int[n];
            p = new int[n];
            list = new ArrayList[n];
            
            edges = new ArrayList<>();
            for(int i=0;i<n;i++){
                p[i] = i;
                list[i] = new ArrayList<Edge>();
            }
                
            for(int i=0;i<n;i++){
                x[i] = fs.nextInt();
                y[i] = fs.nextInt();
            }
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    edges.add(new Edge(i,j,d(x[i],x[j],y[i],y[j])));
                }
            }

            Collections.sort(edges);
            for(Edge e:edges){
                int u = e.u;
                int v = e.v;
                int x = find(u);
                int y = find(v);
                if(x!=y){
                    p[y] = x;
                    list[u].add(new Edge(u,v,e.w));
                    list[v].add(new Edge(v,u,e.w));
                }            
            }
            /* for(int i=0;i<n;i++)
                System.out.println(list[i]); */
            done = new boolean[n];
            rec(0,0.0);
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}