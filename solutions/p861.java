import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,k;
    static int cnt = 0;


    static void rec(int c,int r,int fd,int bd,int k){
        if(k==0){
            cnt++;
            return;
        }
        if(c==n)
            return;
        for(int i=r;i<n;i++){
            if(((fd & (1<<(r+c)))==0) && ((bd & (1<<(r-c+n)))==0)){
                rec(c,r+1,fd|(1<<(r+c)),bd|(1<<(r-c+n)),k-1);
            }
        }
        rec(c+1,0,fd,bd,k);
    }

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            k = fs.nextInt();
            if(n==0)
                break;
            cnt=0;
            rec(0,0,0,0,k);
            System.out.println(cnt);
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