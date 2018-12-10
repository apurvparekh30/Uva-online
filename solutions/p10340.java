import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static String s,t;
    
    public static void main(String[] args) {
        while(true){
            String ln = fs.nextLine();
            if(ln==null || ln.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(ln);
            s = st.nextToken();
            t = st.nextToken();
            int tidx = 0;
            boolean flag = false;
            for(char c:s.toCharArray()){
                flag = false;
                for(;tidx<t.length();tidx++){
                    if(c==t.charAt(tidx)){
                        flag =true;
                        tidx++;
                        break;
                    }
                }
                if(!flag)
                    break;
            }
            if(flag)
                System.out.println("Yes");
            else
                System.out.println("No");
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