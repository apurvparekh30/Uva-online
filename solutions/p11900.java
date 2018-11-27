import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,p,q;
    static int []eggs;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            n = fs.nextInt();
            p = fs.nextInt();
            q = fs.nextInt();
            eggs = new int[n];
            for(int i=0;i<n;i++)
                eggs[i] = fs.nextInt();
            //System.out.println(Arrays.toString(eggs));
            int c = 0,wt = 0;
            for(int i=0;i<n && c<p && wt<q;i++){
                wt += eggs[i];
                c++;
            }
            if(wt>q)
                c--;
            System.out.printf("Case %d: %d\n",tt,c);
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