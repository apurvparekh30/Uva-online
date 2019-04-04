import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,k;

    public static void main(String[] args) {
        while(true){
            String line = fs.nextLine();
            if(line == null || line.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            int ans = n;
            while(n>=k){
                int q = n/k;
                int r = n%k;
                ans+=q;
                n=q+r;
            }
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