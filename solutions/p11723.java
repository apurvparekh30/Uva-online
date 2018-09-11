import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int r,n;
    public static void main(String[] args) {
        int tc = 0;
        while(true){
            tc++;
            
            r = fs.nextInt();
            n = fs.nextInt();
            if(r==0 && n==0) break;
            if(r<=n){
                System.out.println("Case " + tc + ": " + 0);
                continue;
            }
            r = r - n;
            if(n*26 < r){
                System.out.println("Case " + tc + ": " + "impossible");
                continue;
            }
            System.out.println("Case " + tc + ": " + ((r/n)+(r%n==0 ? 0:1)));
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