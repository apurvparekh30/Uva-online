import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static int pz[];

    public static void main(String[] args) {
        int tc =fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            n = fs.nextInt();
            pz = new int[n];
            for(int i=0;i<n;i++){
                pz[i] = -fs.nextInt();
            }
            Arrays.sort(pz);
            int discount = 0;
            for(int i=0;i<n;i++){
                if((i+1)%3==0){
                    discount+=(-pz[i]);
                }
            }
            System.out.println(discount);
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