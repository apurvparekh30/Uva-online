

//Apurv Parekh

import java.util.*;
import java.io.*;


class Main {

    static FastReader fs = new FastReader();
    static BitSet bs;
    static int n,m;

    static final int mx = (int) 1e6+1;

    public static void main(String[] args) {
        while(true){
            n=fs.nextInt(); m=fs.nextInt();
            if(n==0 && m==0) break;
            bs = new BitSet(mx);
            boolean res = false;
            while(n-- > 0){
                int st,en;
                st=fs.nextInt(); en=fs.nextInt();
                for(int i=st;i<en;i++){
                    if(bs.get(i)){
                        res = true;
                    }
                    else
                        bs.set(i);
                }
                    
            }
            while(m-- > 0){
                int st,en,in;
                st=fs.nextInt(); en=fs.nextInt(); in=fs.nextInt();
                for(int nst = st;nst<mx;nst+=in,en=en+in){
                    for(st=nst;st<en;st++){
                        if(bs.get(st)){
                            res = true;
                        }
                        else 
                            bs.set(st);
                    }  
                }
            }   

            if(res){
                System.out.println("CONFLICT");
            } 
            else {
                System.out.println("NO CONFLICT");
            }
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