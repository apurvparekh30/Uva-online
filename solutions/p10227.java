import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int p, t;
    static int[] pr, r;
    static HashSet<Integer> al[];

    static int find(int i) {
        return (i == pr[i]) ? i : (pr[i] = find(pr[i]));
    }

    static boolean consistent(int x, int y) {
        if (al[x].size() != al[y].size())
            return false;
        for(int i:al[x]){
            if(!al[y].contains(i))
                return false;
        }
        return true;
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (consistent(x, y)) {
                if (r[x] > r[y])
                    pr[y] = x;
                else {
                    pr[x] = y;
                    if (r[x] == r[y])
                        r[y]++;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        for (int tt = 1; tt <= tc; tt++) {
            p = fs.nextInt();
            t = fs.nextInt();
            al = new HashSet[p + 1];
            pr = new int[p + 1];
            r = new int[p + 1];
            for (int i = 1; i <= p; i++) {
                pr[i] = i;
                al[i] = new HashSet<>();
            }

            while (true) {
                String nxt = fs.nextLine();
                if (nxt == null || nxt.isEmpty())
                    break;
                StringTokenizer st = new StringTokenizer(nxt);
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                al[u].add(v);
            }
            //System.out.println(Arrays.toString(al));
            int cc = p;
            for (int i = 1; i <= p; i++) {
                for (int j = i + 1; j <= p; j++) {
                    if (union(i, j))
                        cc--;
                }
            }
            if(flag)
                System.out.println();
            flag = true;
            System.out.println(cc);
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