import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int m,n;
    static int []teams;
    static table[] tb;

    public static void main(String[] args) {
        while(true){
            m = fs.nextInt();
            n = fs.nextInt();
            if(m==0 && n==0)
                break;
            teams = new int[m];
            StringBuilder sb[] = new StringBuilder[m];
            tb = new table[n];

            for(int i=0;i<m;i++){
                teams[i] = fs.nextInt();
                sb[i] = new StringBuilder();
            }
                
            for(int i=0;i<n;i++)
                tb[i] = new table(fs.nextInt(),i+1);
            Arrays.sort(tb);
            //System.out.println(Arrays.toString(tb));
            boolean flag = true;
            for(int i=0;i<m;i++){
                boolean space = false;
                int tmp = teams[i];
                for(int j=0;j<n;j++){
                    if(tmp<=0)
                        break;
                    if(tb[j].c<=0){
                        continue;
                    }
                    if(space)
                        sb[i].append(" ");
                    space = true;
                    sb[i].append(tb[j].i);
                    tb[j].c = tb[j].c-1;
                    tmp = tmp - 1;
                }
                if(tmp > 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(1);
                for(int i=0;i<m;i++)
                    System.out.println(sb[i].toString());
            }
            else
                System.out.println(0);
        }
    }

    static class table implements Comparable<table>{
        int c,i;
        table(int c,int i){
            this.c = c;
            this.i = i;
        }
        @Override
        public int compareTo(table o){
            return Integer.compare(o.c,this.c);
        }
        @Override
        public String toString(){
            return c+" "+i;
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