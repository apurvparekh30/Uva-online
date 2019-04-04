import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static int []p,r;

    static int find(int i){
        return (p[i]==i) ? i:(p[i]=find(p[i]));
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(r[x] > r[y])
                p[y] = x;
            else{
                p[x] = y;
                if(r[x]==r[y])
                    r[y]++;
            }
        }
    }

    static int getId(int i){
        return i+n;
    }
    
    public static void main(String[] args) {
        n = fs.nextInt();
        p = new int[n + n];
        r = new int[n + n];
        for(int i=0;i<n+n;i++)
            p[i] = i;

        while (true) {
            int o, x, y;
            o = fs.nextInt();
            x = fs.nextInt();
            y = fs.nextInt();
            if (o == 0 && x == 0 && y == 0)
                break;
            if(o==1){
                if((find(x)==find(getId(y))) || (find(y)==find(getId(x))))
                    System.out.println("-1");
                else{
                    union(x,y);
                    union(getId(x),getId(y));
                }
            }
            else if(o==2){
                if(find(x)==find(y))
                    System.out.println("-1");
                else{
                    union(x,getId(y));
                    union(y, getId(x));
                }    
            }
            else if(o==3){
                if(find(x)==find(y))
                    System.out.println("1");
                else
                    System.out.println("0");
            }
            else {
                if((find(x)==find(getId(y))) || (find(y)==find(getId(x))))
                    System.out.println("1");
                else
                    System.out.println("0");  
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