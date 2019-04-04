import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n==0) break;
            int ans = 0;
            if(n==1) ans = 0;
            else ans = (int)(Math.log(n)/Math.log(2));
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