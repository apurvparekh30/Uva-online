import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static final int LEFT = 0;
    static final int RIGHT = 1;

    static Deque<Integer> qe[];

    public static void main(String[] args) throws Exception {
        int tc = fs.nextInt();
        while(tc-- > 0){
            qe = new Deque[2];
            qe[LEFT] = new ArrayDeque<Integer>();
            qe[RIGHT] = new ArrayDeque<Integer>();

            int l,m;
            l = fs.nextInt() * 100;
            m = fs.nextInt();

            for(int i=0;i<m;i++){
                int tt = fs.nextInt();
                String d = fs.next();
                if(d.equals("left"))
                    qe[LEFT].addLast(tt);
                else
                    qe[RIGHT].addLast(tt);
            }

            int dir = LEFT;
            int rounds = 0;
            while(true){
                if(qe[LEFT].isEmpty() && qe[RIGHT].isEmpty()) break;
                int currLength=0;
                while(!qe[dir].isEmpty() && (currLength+qe[dir].getFirst())<=l){
                    currLength+=qe[dir].removeFirst();
                }
                rounds++;
                dir^=1;
            }
            System.out.println(rounds);
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