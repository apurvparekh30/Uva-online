import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;

    public static void main(String[] args) {
        System.out.print("PERFECTION OUTPUT\n");
        while(true){
            n = fs.nextInt();
            if(n==0) break;
            if(n==1){
                System.out.printf("%5d  DEFICIENT\n",n);
                continue;
            }
            int sum = 1;
            for(int i=2;i<=Math.sqrt(n);i++){
                if(sum>n) break;
                if(n%i==0){
                    sum+=i;
                    int q = (n/i);
                    if(q==i) continue;
                    sum+=(n/i);
                }
            }
            if(n==sum)
                System.out.printf("%5d  PERFECT\n",n);
            else if(n<sum)
                System.out.printf("%5d  ABUNDANT\n",n);
            else
                System.out.printf("%5d  DEFICIENT\n",n);
            
        }
        System.out.println("END OF OUTPUT");
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