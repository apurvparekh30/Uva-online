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
            int cnt = 0;
            int rounds = 0;
            boolean first = false;
            if((m%n)!=0)
                first = true;
            for(int i=0;i<m;i++){
                if(curr < tm[i])
                    curr = tm[i];
                cnt++;
                if(!first){
                    if(cnt == n){
                        cnt = 0;
                        curr+=t+t;
                        rounds++;
                    }
                }
                else if(cnt == (m%n)){
                    first = false;
                    cnt = 0;
                    curr+=t+t;
                    rounds++;
                }
            }
            System.out.println(curr-t + " " + rounds);
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