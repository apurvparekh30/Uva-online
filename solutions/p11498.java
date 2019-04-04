import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int k;
    static int x,y;
    static int p,q;

    public static void main(String[] args) {
        while(true){
            k = fs.nextInt();
            if(k==0)
                break;
            x = fs.nextInt();
            y = fs.nextInt();
            
            for(int i=0;i<k;i++){
                String ans = "divisa";
                p = fs.nextInt();
                q = fs.nextInt();
                if(p>x && q>y)
                    ans = "NE";
                else if(p<x && q>y)
                    ans = "NO";
                else if(p<x && q<y)
                    ans = "SO";
                else if(p>x && q<y)
                    ans = "SE";
                System.out.println(ans);
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