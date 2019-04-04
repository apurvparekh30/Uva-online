import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int [] a;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            int n = fs.nextInt();
            a = new int[n];
            int sum = 0;
            for(int i=0;i<n;i++){
                a[i]=fs.nextInt();
                if(i==0) continue;
                int cnt = 0;
                for(int j=0;j<i;j++){
                    if(a[j]<=a[i])
                        cnt++;
                }
                sum+=cnt;
            }
            System.out.println(sum);
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