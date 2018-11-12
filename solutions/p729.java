import java.util.*;
import java.io.*;

class Main{

    static FastReader fs = new FastReader();
    static int n,h;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        while(tc-- > 0){
            n = fs.nextInt();
            h = fs.nextInt();
            int till = (1<<n);
            if(flag)
                System.out.println();
            flag = true;
            for(int i=0;i<till;i++){
                if(Integer.bitCount(i)==h){
                    String s = "00000000000000000" +Integer.toBinaryString(i);
                    System.out.printf("%s\n",s.substring(s.length()-n));
                }
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