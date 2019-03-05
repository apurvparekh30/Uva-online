import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int f,n;
    static boolean stations[];
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
            stations = new boolean [n];
            dist = new int[n];
            g = new ArrayList[n];
            for(int i=0;i<f;i++)
                stations[fs.nextInt()] = true;
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
            int ans = 0;
            int max = oo;
            for(int i = 1;i<n;i++){
                if(!stations[i])
                    continue;
                Queue<state> pq = new PriorityQueue<>();
                pq.offer(new state(i,0));
                dist[i] = 0;
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
            for(int i= 1;i<n;i++){
                int []newDist = Arrays.copyOf(dist,dist.length);
                newDist[i] = 0;
                Queue<state> pq = new PriorityQueue<>();
                pq.offer(new state(i,0));
                while(!pq.isEmpty()){
                    state curr = pq.poll();
                    int v = curr.v;
                    int d = curr.d;
                    if(newDist[v] < d)
                        continue;
                    for(state next:g[v]){
                        if(newDist[next.v] > d + next.d){
                            newDist[next.v] = d + next.d;
                            pq.offer(new state(next.v,newDist[next.v]));
                        }
                    }
                }
                int currMax = 0;
                int j = 1;
                //System.out.println("from " + i + " " + Arrays.toString(newDist));
                for(j=1;j<n;j++){
                    if(newDist[j] > currMax)
                        currMax = newDist[j];
                }
                if(currMax < max){
                    max = currMax;
                    ans = i;
                }
                //System.out.println();
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