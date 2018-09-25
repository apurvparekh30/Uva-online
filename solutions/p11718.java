import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,k,m;

    static long sq(long x){
        return (x*x)%m;
    }

    static long supPow(long b,long p,long m){
        if(p==0) return 1;
        if(p%2==0)
            return sq(supPow(b, p/2, m)) % m;
        else    
            return (b%m)*supPow(b,p-1,m)%m;
    }   

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            n = fs.nextInt();
            k = fs.nextInt();
            m = fs.nextInt();
            long sum = 0L;
            for(int i=0;i<n;i++){
                sum+=fs.nextInt();
                sum=sum%m;
            }
            long res = ((sum%m) * (k%m) * (supPow(n,k-1,m)%m) %m);
            System.out.println("Case "+t+": "+res);
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