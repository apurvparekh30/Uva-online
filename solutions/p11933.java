// Apurv Parekh

import java.util.*;
import java.io.*;

class Main{

    static FastReader fs = new FastReader();
    static int n,a,b;

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n==0) break;

            a=0; b=0;
            int j=0,i=0;
            while(n > 0){
                if((n&1)==1){
                    j++;
                    if(j%2==1){
                        a|=(1<<i);
                    }
                    else{
                        b|=(1<<i);
                    }
                }
                i++;
                n=n>>1;
            } 
            System.out.println(a+" "+b);
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