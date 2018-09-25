import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n==0) break;
            int gridSize = (int)Math.ceil(Math.sqrt(n));
            int x,y;
            int totalGrid = gridSize * gridSize;
            int diff = totalGrid - n;
            if(gridSize%2 == 0){
                int move = Math.min(gridSize-1,diff);
                y = 1 + move;
                diff = diff - move;
                x = gridSize - diff;
            }   
            else{
                int move = Math.min(gridSize-1,diff);
                x = 1 + move;
                diff = diff - move;
                y = gridSize - diff;
            }
            System.out.println(x+" "+y);
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