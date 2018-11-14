import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static char g[][];
    static int dr[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static int dc[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static TreeSet<MyString> hm;

    static void rec(int x, int y, char[] word, int idx) {
        
        if (idx > word.length)
            return;
        
        if (idx >= 3) {
            hm.add(new MyString(new String(word, 0, idx)));
        }
        
        for (int i = 0; i < 8; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];
            /* 
                if ((new String(word, 0, idx + 1)).equals("dfh"))
                System.out.println(x + " " + y); */
            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            
            if (g[nx][ny] > g[x][y]) {
                word[idx] = g[nx][ny];
                
                rec(nx, ny, word, idx + 1);
            }
        }
    }

    static class MyString implements Comparable<MyString>{
        String s;
        MyString(String s){
            this.s = s;
        }
        @Override
        public int compareTo(MyString o){
            if(this.s.length() == o.s.length())
                return this.s.compareTo(o.s);
            return Integer.compare(this.s.length(), o.s.length());
        }
        @Override  
        public String toString(){
            return this.s;
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        for (int t = 0; t < tc; t++) {
            n = fs.nextInt();
            g = new char[n][n];
            for (int i = 0; i < n; i++) {
                g[i] = fs.next().toCharArray();
            }
            hm = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    char[] word = new char[n * n];
                    word[0] = g[i][j];
                    rec(i, j, word, 1);
                }
            }
            
            if(hm.size() > 0){
                for (MyString s : hm) {
                    System.out.println(s);
                }
                
            }
            if (t < tc-1 ) {
                System.out.println();
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