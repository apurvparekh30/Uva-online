import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int r,c;
    static int m,n;
    static int g[][];
    static boolean done[][];
    static int []dr = {1,0,-1,0};
    static int []dc = {0,-1,0,1};

    static class state{
        int i,j,w;
        state(int i,int j,int w){
            this.i = i;
            this.j = j;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        while(true){
            r = fs.nextInt();
            c = fs.nextInt();
            
            if(r==0 && c==0){
                break;
            }
            r++;
            c++;
            g = new int[r][c];
            done = new boolean[r][c];
            m = fs.nextInt();
            for(int i=0;i<m;i++){
                int u,v;
                u = fs.nextInt();
                v = fs.nextInt();
                g[u][v] = -1;
            }
            n = fs.nextInt();
            for(int i=0;i<n;i++){
                int u,v,l;
                
                u = fs.nextInt();
                v = fs.nextInt();
                l = fs.nextInt();
                for(int cr=-l;cr<=l;cr++){
                    for(int cc=-l;cc<=l;cc++){
                        if(cr*cr + cc*cc > l*l)
                            continue;
                        int uu = u + cr;
                        int vv = v + cc;
                        if(uu<=0 || uu>=r || vv<=0 || vv>=c)
                            continue;
                        g[uu][vv] = -1;
                    }
                }
            }

            if(g[1][1]==-1){
                System.out.println("Impossible.");
                continue;
            }
            Queue<state> q = new ArrayDeque<>();
            q.offer(new state(1,1,0));
            StringBuilder sb = new StringBuilder("Impossible.");
            while(!q.isEmpty()){
                state curr = q.poll();
                int i = curr.i;
                int j = curr.j;
                int w = curr.w;
                if(i==r-1 && j==c-1){
                    sb = new StringBuilder().append(w);
                    break;
                }
                for(int k=0;k<4;k++){
                    int ii = i + dr[k];
                    int jj = j + dc[k];
                    if(ii<=0 || ii>=r || jj <=0 || jj>=c)
                        continue;
                    if(done[ii][jj] || g[ii][jj]==-1)
                        continue;
                    done[ii][jj] = true;
                    q.offer(new state(ii,jj,w+1)); 
                }
            }
            System.out.println(sb);
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