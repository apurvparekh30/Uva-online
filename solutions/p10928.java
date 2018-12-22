import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int p;
    static int[] cnt;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for (int tt = 1; tt <= tc; tt++) {
            p = fs.nextInt();
            cnt = new int[p + 1];
            for (int i = 1; i <= p; i++) {
                String nxt = fs.nextLine();
                StringTokenizer st = new StringTokenizer(nxt);
                while (st.hasMoreTokens()) {
                    st.nextToken();
                    cnt[i]++;
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= p; i++) {
                ans = Math.min(ans, cnt[i]);
            }
            boolean flag = false;
            for (int i = 1; i <= p; i++) {
                if (cnt[i] == ans) {
                    if (flag)
                        System.out.print(" ");
                    flag = true;
                    System.out.print(i);
                }
            }
            System.out.println();
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