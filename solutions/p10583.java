import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,m;
    static int []p,r;

    static int find(int i){
        return (i==p[i]) ? i:(p[i]=find(p[i]));
    }

    static boolean union(int x,int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(r[x] > r[y])
                p[y] = x;
            else {
                p[x] = y;
                if(r[x]==r[y])
                    r[y]++;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int tc = 0;
        while(true){
            tc++;
            n = fs.nextInt();
            m = fs.nextInt();
            if(n==0 && m==0)
                break;
            p = new int[n+1];
            r = new int[n+1];
            for(int i=0;i<=n;i++)
                p[i] = i;
            int cc = n;
            for(int i=0;i<m;i++){
                int u,v;
                u = fs.nextInt();
                v = fs.nextInt();
                if(union(u, v))
                    cc--;
            }
            System.out.printf("Case %d: %d\n",tc,cc);
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