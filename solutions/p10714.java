import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,l;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            l = fs.nextInt();
            n = fs.nextInt();
            int min = 0,max = 0;
            for(int j=0;j<n;j++){
                int x = fs.nextInt();
                x = (x < l-x) ? x:l-x;
                if(x > min)
                    min = x;
                if(l-x > max)
                    max = l-x;
            }
            System.out.println(min + " " + max);
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