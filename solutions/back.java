import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n, t, m;
    static int[] tm;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for (int tt = 1; tt <= tc; tt++) {
            n = fs.nextInt();
            t = fs.nextInt();
            m = fs.nextInt();
            tm = new int[m];
            for (int i = 0; i < m; i++)
                tm[i] = fs.nextInt();
            int curr = tm[0];
            int cnt = 1;
            int rounds = 0;
            for(int i=1;i<m;i++){
                System.out.println(tm[i] + "  " + curr + " " + cnt);
                if(tm[i] - tm[i-1] > (2*t)){
                    cnt = 1;
                    rounds++;
                    curr = tm[i];
                    continue;
                }
                if(cnt >= n){
                    curr = Math.max(curr + (2*t),tm[i]);
                    cnt = 1;
                    rounds++;
                    continue;
                }
                curr = Math.max(curr,tm[i]);
                cnt++;
            }
            System.out.println("ans" + curr + " " + rounds);
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