//Apurv Parekh

import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int [][][] grid;
    static int dr[] = {1,0,-1,0};
    static int dc[] = {0,-1,0,1};

    static boolean done(int idx){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(grid[idx][i][j]==1) return false;
        return true;
    }

    static int f(int idx){
        if(done(idx)) return -1;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                for(int k=0;k<4;k++){
                    int ii = i+dr[k];
                    int jj = j+dc[k];
                    if(ii<0||ii>=3||jj<0||jj>=3) continue;
                    grid[idx+1][i][j] += grid[idx][ii][jj];
                }
                grid[idx+1][i][j]%=2;
            }   
        return 1 + f(idx+1);
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            grid = new int [10000][3][3];
            for(int i=0;i<3;i++){
                String s = fs.next();
                for(int j=0;j<3;j++)
                    grid[0][i][j] = s.charAt(j)-'0';
            }
            System.out.println(f(0));
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