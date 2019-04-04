
// Apurv Parekh

import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int d,p;

    public static void main(String[] args) {
        while(true){
            d=fs.nextInt();
            p=fs.nextInt();
            if(d==0 && p==0) break;


            int root = (int) Math.sqrt(p);
            if(root*root == p && root%2==1){
            }
            else if(root%2==1) root+=2;
            else root+=1;
            int i=0,j=0;
            if(root *root == 1){
                i = (d/2)+1;
                j = (d/2)+1;
                System.out.println("Line = "+i+", column = " + j + ".");
                continue;
            }

            int group = (root*root-p)/(root-1);
            
            switch(group){
                case 0:
                    j = d - ((d-root)/2);
                    i = ((d-root)/2)+1;
                    i = i+(root*root - p);
                    break;
                case 1:
                    i = d - ((d-root)/2);
                    j = ((d-root)/2)+1;
                    int tmp = (root * root - ((root-1) * 2));
                    j = j + (p-tmp); 
                    break;
                case 2:
                    j = ((d-root)/2)+1;
                    i = j;
                    tmp = (root*root - ((root-1)*3));
                    i = i + (p - tmp);
                    break;
                case 3:
                    tmp = (root*root - ((root-1)*3));
                    j = ((d-root)/2)+1;
                    i = j;
                    j = j + (tmp - p);
                    break;
            }
            System.out.println("Line = "+((d-i)+1)+", column = " + j + ".");
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