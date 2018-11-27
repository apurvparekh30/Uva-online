import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static task []tsk;
    
    public static void main(String[] args) {
        int tc = 0;
        while(true){
            tc++;
            n = fs.nextInt();
            if(n==0)
                break;
            tsk = new task[n];
            for(int i=0;i<n;i++){
                tsk[i] = new task(fs.nextInt(),fs.nextInt());
            }
            Arrays.sort(tsk);
            int a,b;
            a = 0;
            b = 0;
            for(int i=0;i<n;i++){
                a += tsk[i].b;
                if(b < a+tsk[i].j){
                    b = a + tsk[i].j;
                }
            }
            System.out.printf("Case %d: %d\n",tc,b);
        }
    }   


    static class task implements Comparable<task>{
        int b,j;
        task(int b,int j){
            this.b = b;
            this.j = j;
        }
        @Override
        public int compareTo(task o){
            if(this.j == o.j)
                return Integer.compare(this.b,o.b);
            return Integer.compare(o.j, this.j);
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