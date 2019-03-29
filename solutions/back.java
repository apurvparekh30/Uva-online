import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int f,n;
    static int stations[];
    static int []dist;
    static ArrayList<state> g[];
    static final int oo = 987654321;

    static class state implements Comparable<state> {
        int v,d;
        state(int v,int d){
            this.v = v;
            this.d = d;
        }
        @Override
        public int compareTo(state o) {
            return Integer.compare(this.d, o.d);
        }
        @Override
        public String toString() {
            return v + " " + d;
        }
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        while(tc-- > 0){
            f = fs.nextInt();
            n = fs.nextInt();
            n++;
            stations = new int [f];
            dist = new int[n];
            g = new ArrayList[n];
            for(int i=0;i<f;i++)
                stations[i] = fs.nextInt();
            for(int i=1;i<n;i++)
                g[i] = new ArrayList<>();
            while(true){
                String nextLine = fs.nextLine();
                if(nextLine==null || nextLine.isEmpty())
                    break;
                int u,v,w;
                StringTokenizer st = new StringTokenizer(nextLine);
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                g[u].add(new state(v,w));
                g[v].add(new state(u,w));
            }
            Arrays.fill(dist,oo);
            for(int i = 0;i<f;i++){
                Queue<state> pq = new PriorityQueue<>();
                pq.offer(new state(stations[i],0));
                while(!pq.isEmpty()){
                    state curr = pq.poll();
                    int v = curr.v;
                    int d = curr.d;
                    if(dist[v] < d)
                        continue;
                    for(state next:g[v]){
                        if(dist[next.v] > d + next.d){
                            dist[next.v] = d + next.d;
                            pq.offer(new state(next.v,dist[next.v]));
                        }
                    }
                }
            }
            int max = 0;
            int ans = 0;
            for(int i=1;i<n;i++){
                if(dist[i] > max){
                    max = dist[i];
                    ans = i;
                } 
            }
            if(flag)
                System.out.println();
            flag = true;
            System.out.println(ans);
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