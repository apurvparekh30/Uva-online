import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static String input;
    static Deque<Character> st[];
    static int cnt;

    static void addToStack(char c) throws Exception{
        for(int i=0;i<cnt;i++){
            if(st[i].peekFirst()>=c){
                st[i].addFirst(c);
                return ;
            }
        }
        st[cnt] = new ArrayDeque<Character>();
        st[cnt].addFirst(c);
        cnt++;
    }

    public static void main(String[] args) throws Exception {
        int tc = 0;
        while(!(input = fs.nextLine()).equals("end")){
            tc++;
            st = new Deque[26];
            cnt = 0;
            for(char c:input.toCharArray()){
                addToStack(c);
            }
            System.out.println("Case "+tc+": "+cnt);
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