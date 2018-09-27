//Apurv Parekh

import java.io.*;
import java.util.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static final int []dx={0,-1,-1,0,1,1};
    static final int []dy={-1,0,1,1,0,-1};

    public static void main(String[] args) {
        while(true){
            String line = fs.nextLine();
            if(line == null || line.isEmpty()) break;
            n = Integer.parseInt(line);
            int r=0,k=1; //ring number

            // somehow get r
            if(n==1){
                System.out.println("0 0");
            }
            else{
                for(int i=1;;i++){
                    k += 6*i;
                    if(n <= k){
                        r = i;
                        break;
                    }
                }
                //System.out.println(k +" " + r);
                int x = r,y=0;
                boolean flag=false;
                for(int i=0;i<6;i++){
                    for(int j=0;j<r;j++){
                        x+=dx[i];
                        y+=dy[i];
                        //System.out.println(x + " " + y);
                        k--;
                        //System.out.println("k=" +k + "n="+n);
                        if(k==n){
                            flag=true;
                            break;
                        }
                    }
                    if(flag) break;
                }
                System.out.println(x+" "+y);
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