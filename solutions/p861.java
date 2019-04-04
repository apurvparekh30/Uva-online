import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,k;
    static int cnt = 0;
    static int res[][] = new int[9][65];


    static void rec(int c,int r,int fd,int bd,int k){
        if(k==0){
            cnt++;
            return;
        }
        int used = Math.max(c-1*n,0) + r;
        //System.out.println();
        if((n*n-used) < k)
            return;
        if(c==n)
            return;
        for(int i=r;i<n;i++){
            if(((fd & (1<<(i+c)))==0) && ((bd & (1<<(i-c+n)))==0)){
                rec(c,i+1,fd|(1<<(i+c)),bd|(1<<(i-c+n)),k-1);
            }
        }
        rec(c+1,0,fd,bd,k);
    }

    public static void main(String[] args) {

        for(int i=1;i<=8;i++){
            n = i;
            for(int j=1;j<=(i*i);j++){
                cnt = 0;
                rec(0,0,0,0,j);
                res[i][j] = cnt;
            }
        }
        while(true){
            n = fs.nextInt();
            k = fs.nextInt();
            if(n==0)
                break;
            cnt = 0;
            rec(0,0,0,0,k);
            System.out.println(res[n][k]);
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