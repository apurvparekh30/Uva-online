import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static TreeSet<Integer> al[];
    static int graph 
    static int s,d;
    static int cnt;

    static void rec(int u,int mask,int i,ArrayList<Integer> lst){
        if(u==d){
            System.out.print("1");
            for(int a:lst){
                System.out.print(" " + a);
                if(a==d)
                    break;
            }
            System.out.println();
            cnt++;
            return;
        }
        for(int v:al[u]){
            if((mask & (1<<v))==0){
                lst.add(i,v);
                rec(v,mask|(1<<v),i+1,lst);
            }
        }
    }

    public static void main(String[] args) {
        int tc = 0;
        while(true){
            tc++;
            String line = fs.nextLine();
            if(line==null || line.isEmpty())
                break;
            s = 1;
            d = Integer.parseInt(line);
            al = new TreeSet[21];
            for(int i=0;i<=20;i++)
                al[i] = new TreeSet<Integer>();
            while(true){
                int u = fs.nextInt();
                int v = fs.nextInt();
                if(u==0 && v==0)
                    break;
                al[u].add(v);
            }
            cnt = 0;
            System.out.println("CASE "+tc+":");
            rec(s,2,0,new ArrayList<>());
            System.out.printf("There are %d routes from the firestation to streetcorner %d.\n",cnt,d);
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