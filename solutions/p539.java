import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n, m;
    static int graph[][];

    static int rec(int u) {
        int ans = 0;
        for(int i=0;i<n;i++){
            if(graph[u][i]==0) continue;
            graph[u][i] = 0;
            graph[i][u] = 0;
            ans = Math.max(ans,rec(i));
            graph[u][i] = 1;
            graph[i][u] = 1;
        }
        return 1+ans;
    }

    public static void main(String[] args) {
        while (true) {
            n = fs.nextInt();
            m = fs.nextInt();
            if (n == 0 && m == 0)
                break;

            graph = new int[n][n];
            for (int i = 0; i < m; i++) {
                int u, v;
                u = fs.nextInt();
                v = fs.nextInt();
                graph[u][v] = 1;
                graph[v][u] = 1;
            }
            int ans = 0;
            for(int i=0;i<n;i++)
                ans = Math.max(ans, rec(i)-1);
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