import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static ArrayDeque<Integer> st[];
    static int ans = 0;


    static void rec(int no,int peg){
        if(peg == n)
            return;
        if(st[peg]==null){
            st[peg] = new ArrayDeque<>();
            st[peg].addLast(no);
            ans++;
            rec(no+1,peg);
            return;
        }
        for(int i=0;i<=peg;i++){
            int tmp = st[i].peekLast();
            int t = (int) Math.sqrt(tmp+no);
            if((t*t) == (tmp+no)){
                ans++;
                st[i].addLast(no);
                rec(no+1,peg);
                return;
            }
        }
        rec(no,peg+1);
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            st = new ArrayDeque[n];
            ans = 0;
            rec(1,0);
            System.out.println(ans);
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