import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static Deque<Integer> st;
    static Deque<Integer> []qe;

    public static void main(String[] args) throws Exception {
        int tc = fs.nextInt();
        st = new ArrayDeque<Integer>();
        while(tc-- > 0){
            int n,s,q;
            n = fs.nextInt();
            s = fs.nextInt();
            q = fs.nextInt();

            qe = new Deque[n];
            for(int i=0;i<n;i++){
                qe[i] = new ArrayDeque<Integer>();
                int cnt = fs.nextInt();
                while(cnt-- > 0){
                    qe[i].addLast(fs.nextInt()-1);
                }
            }
            int currPos = 0;
            int time=0;
            while(true){
                while(!st.isEmpty() && (st.peekLast() == currPos || qe[currPos].size()<q)){
                    if(st.peekLast()!=currPos){
                        qe[currPos].addLast(st.getLast());
                    }
                    st.removeLast();
                    time++;
                }
                while(st.size() < s && !qe[currPos].isEmpty()){
                    st.addLast(qe[currPos].removeFirst());
                    time++;
                }   
                boolean clear = st.isEmpty();
                for(int i=0;i<n;i++){
                    clear&=qe[i].isEmpty();
                }
                if(clear) break;
                currPos = (currPos+1)%n;
                time+=2;
            }
            System.out.println(time);
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