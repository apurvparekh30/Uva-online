import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int term;

    public static void main(String[] args) {
        while(true){
            String line = fs.nextLine();
            if(line == null || line.isEmpty()) break;
            term = Integer.parseInt(line);
            int x,y;
            for(int i=1;;i++){
                if( i*(i+1)/2 >= term){
                    int diff = (i*(i+1)/2) - term;
                    if(i%2==0){
                        x = i-diff;
                        y = 1+diff;
                    }
                    else{
                        y = i-diff;
                        x = 1+diff;
                    }
                    
                    break;
                }
            }
            System.out.println("TERM "+term+" IS "+x+"/"+y);
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