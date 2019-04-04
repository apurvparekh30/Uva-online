import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int d,i;
    static int maxNode;

    static int bs(int node,int balls){
        int left = node * 2;
        int right = left + 1;
        if(left < maxNode && right < maxNode){
            if(balls%2==0){
                return bs(right,balls/2);
            }
            else
                return bs(left,balls/2+1);
        }
        return node;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            d = fs.nextInt();
            i = fs.nextInt();
            maxNode = (int) Math.pow(2, d);
            System.out.println(bs(1,i));
        }
        fs.nextInt();
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