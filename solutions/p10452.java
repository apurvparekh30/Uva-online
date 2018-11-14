import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static char [][]g;
    static int n,m;
    static int dr[] = {-1,0,0};
    static int dc[] = {0,1,-1};
    static String dir[] = {"forth","right","left"};
    static int sx,sy;
    static int dx,dy;
    static int []route;
    static char []path = new String("IEHOVA#").toCharArray();

    static boolean rec(int x,int y,int idx){
        if(idx==path.length){
            return true;
        }
        for(int i=0;i<3;i++){
            int nx = x + dr[i];
            int ny = y + dc[i];
            if(nx<0||nx>=n||ny<0||ny>=m)
                continue;
            if(g[nx][ny]==path[idx]){
                route[idx] = i;
                if(rec(nx,ny,idx+1))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=0;t<tc;t++){
            n = fs.nextInt();
            m = fs.nextInt();
            g = new char[n][m];
            for(int i=0;i<n;i++){
                g[i] = fs.next().toCharArray();
                for(int j=0;j<m;j++){
                    if(g[i][j]=='@'){
                        sx = i;
                        sy = j;
                    }
                    if(g[i][j]=='#'){
                        dx = i;
                        dy = j;
                    }
                }
            }
            route = new int[7];
            rec(sx,sy,0);
            boolean space = false;
            for(int i=0;i<7;i++){
                int a = route[i];
                if(space)
                    System.out.print(" ");
                space = true;
                System.out.print(dir[a]);
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