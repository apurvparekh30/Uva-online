import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static char [][]g;
    static int n;

    static int []dr = {1,1,0,-1,-1,-1,0,1};
    static int []dc = {0,-1,-1,-1,0,1,1,1};

    static void dfs(int i,int j){
        g[i][j] = '0';
        for(int idx=0;idx<8;idx++){
            int nx = i + dr[idx];
            int ny = j + dc[idx];
            if(nx<0 || nx>=n || ny<0 || ny>=n)
                continue;
            if(g[nx][ny]=='0')
                continue;
            dfs(nx,ny);
        }
    }

    public static void main(String[] args) {
        int tt = 0;
        while(true){
            tt++;
            String nxtLine = fs.nextLine();
            if(nxtLine==null || nxtLine.isEmpty())
                break;
            n = Integer.parseInt(nxtLine);
            g = new char[n][n];
            for(int i=0;i<n;i++){
                g[i] = fs.next().toCharArray();
            }
            int cnt = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(g[i][j]=='0')
                        continue;
                    cnt++;
                    dfs(i,j);
                }
            }
            System.out.printf("Image number %d contains %d war eagles.\n",tt,cnt);
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