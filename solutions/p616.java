import java.util.*;
import java.io.*;

class Main{

    static FastReader fs = new FastReader();
    static int n;

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n<0) break;
            int root = (int) Math.ceil(Math.sqrt(n));
            int ans = -1;
            for(int people=2;people<=root;people++){
                int cnt = n;
                for(int round=0;round<people;round++){
                    cnt=cnt-1;
                    if(cnt%people > 0) break;
                    cnt=cnt-(cnt/people);
                }
                if(cnt%people==0){
                    ans=people;
                }
            }
            if(ans==-1){
                System.out.println(n + " coconuts, no solution");
            }
            else{
                System.out.println(n + " coconuts, "+ans+" people and 1 monkey");
            }
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