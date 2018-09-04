
// Apurv Parekh

import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();

    static char[][] a, b;
    static int N, n;

    static void rotate(){
        
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++){
                char temp = b[i][j];
                b[i][j] = b[j][i];
                b[j][i] = temp;
            }
        
        for(int i=0;i<n;i++)
            b[i] = new StringBuilder(new String(b[i])).reverse().toString().toCharArray();
    }

    static int check(){
        int cnt=0;
        for(int i=0;i+n<=N;i++){
            for(int j=0;j+n<=N;j++){
                boolean flag=true;
                for(int k=0;k<n;k++){
                    for(int l=0;l<n;l++){
                        if(a[i+k][j+l] != b[k][l]){
                            flag=false;
                            break;
                        }  
                    }
                    if(!flag) break;
                }
                if(flag) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        while (true) {
            N = fs.nextInt();
            n = fs.nextInt();

            if (N == 0 && n == 0)
                break;
            a = new char[N][N];
            b = new char[n][n];

            for (int i = 0; i < N; i++){
                a[i] = fs.next().toCharArray();
            }
                
            for (int i = 0; i < n; i++){
                b[i] = fs.next().toCharArray();
            }
            System.out.print(check());
            for(int i=0;i<3;i++){
                rotate();
                /* for(int k=0;k<n;k++){
                    for(int j=0;j<n;j++)
                        System.out.print(b[k][j]);
                    System.out.println();
                }
                System.out.println(); */
                System.out.print(" " + check());
            }

            System.out.println();
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