import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static job jb[];

    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        for(int tt=1;tt<=tc;tt++){
            n = fs.nextInt();
            jb = new job[n];
            for(int i=0;i<n;i++){
                jb[i] = new job(fs.nextInt(),fs.nextInt(),i+1);
            }
            Arrays.sort(jb);
            if(flag)
                System.out.println();
            flag = true;
            boolean space = false;
            for(int i=0;i<n;i++){
                if(space)
                    System.out.print(" ");
                space = true;
                System.out.print(jb[i].idx);
            }
            System.out.println();
        }
    }

    static class job implements Comparable<job>{
        int t,s,idx;
        
        job(int t,int s,int idx){
            this.t = t;
            this.s = s;
            this.idx = idx;
        }

        public int compareTo(job o){
            double a = this.t * o.s;
            double b = this.s * o.t;
            if(Double.compare(a, b)==0)
                return Integer.compare(this.idx, o.idx);
            return Double.compare(a, b);
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