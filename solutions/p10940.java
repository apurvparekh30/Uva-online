import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static int [] sol;
    public static void main(String[] args) {
        sol = new int[500000 + 1];
        int exp = 0;
        int number = 1;
        sol[0] = 1;
        for(int i=1;i<=500000;i++){
            if(number > (1<<exp)){
                exp++;
                number = 2;
            }
            sol[i] = number;
            number+=2;
        }

        while(true){
            n = fs.nextInt();
            if(n==0) break;
            System.out.println(sol[n]);
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