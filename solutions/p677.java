import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int[][] graph;
    static int v, n;
    static boolean found;

    static void rec(int u, int mask, int pos, int[] path) {
        if (pos == n) {
            System.out.print("(1");
            for (int i = 0; i < n; i++) {
                System.out.print("," + (path[i] + 1));
            }
            System.out.println(")");
            found = true;
            return;
        }
        for (int i = 0; i < v; i++) {
            int v = graph[u][i];
            if (v == 1 && (mask & (1 << i)) == 0) {
                path[pos] = i;
                rec(i, mask | (1 << i), pos + 1, path);
            }
        }
    }

    public static void main(String[] args) {
        boolean line = false;
        while (true) {
            String ln = fs.nextLine();
            if (ln == null || ln.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(ln);
            v = Integer.parseInt(st.nextToken());
            if (v == -9999)
                continue;
            n = Integer.parseInt(st.nextToken());

            graph = new int[v][v];

            for (int i = 0; i < v; i++)
                for (int j = 0; j < v; j++)
                    graph[i][j] = fs.nextInt();

            if (line)
                System.out.println();
            line = true;
            found = false;
            rec(0, 1, 0, new int[n]);
            if(!found)
                System.out.println("no walk of length " + n);

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