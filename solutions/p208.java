import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int[][] graph;
    static boolean reach[];
    static int s, d;
    static int cnt;
    static int mx;

    static void dfs(int u) {
        reach[u] = true;
        for (int i = 1; i <= mx; i++) {
            if (reach[i])
                continue;
            if (graph[u][i] == 0)
                continue;
            dfs(i);
        }
    }

    static void rec(int u, int mask, int i, ArrayList<Integer> lst) {
        if (reach[u]) {
            if (u == d) {
                System.out.print("1");
                for (int a : lst) {
                    System.out.print(" " + a);
                    if (a == d)
                        break;
                }
                System.out.println();
                cnt++;
                return;
            }
            for (int ii = 1; ii <= mx; ii++) {
                if (graph[u][ii] == 1) {
                    int v = ii;
                    if ((mask & (1 << v)) == 0) {
                        lst.add(i, v);
                        rec(v, mask | (1 << v), i + 1, lst);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int tc = 0;
        while (true) {
            tc++;
            String line = fs.nextLine();
            if (line == null || line.isEmpty())
                break;
            s = 1;
            d = Integer.parseInt(line);
            graph = new int[21][21];
            reach = new boolean[21];
            mx = -1;
            while (true) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                if (u == 0 && v == 0)
                    break;
                graph[u][v] = 1;
                graph[v][u] = 1;
                mx = Math.max(mx, Math.max(u, v));
            }
            cnt = 0;
            System.out.println("CASE " + tc + ":");
            dfs(d);
            rec(s, 2, 0, new ArrayList<>());
            System.out.printf("There are %d routes from the firestation to streetcorner %d.\n", cnt, d);
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