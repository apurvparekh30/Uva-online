import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,m,k;
    static int []pr,rnk;

    static int findParent(int i){
        return pr[i]==i ? i:(pr[i]=findParent(pr[i]));
    }
    public static void main(String[] args) {
        boolean flag = false;
        while(true){
            if(flag){
                fs.nextLine();
            }
            String nxtLine = fs.nextLine();
            if(nxtLine == null || nxtLine.isEmpty())
                break;
            if(flag){
                System.out.println();
            }
            flag = true;
            n = Integer.parseInt(nxtLine);
            pr = new int[n+1];
            rnk = new int[n+1];
            for(int i=1;i<=n;i++)
                pr[i] = i;
            int cost = 0;
            ArrayList<edge> al = new ArrayList<>();
            for(int i=0;i<n-1;i++){
                int u = fs.nextInt();
                int v = fs.nextInt();
                int c = fs.nextInt();
                cost+=c;
            }
            System.out.println(cost);
            cost = 0;
            k = fs.nextInt();
            for(int i=0;i<k;i++){
                int u = fs.nextInt();
                int v = fs.nextInt();
                int c = fs.nextInt();
                al.add(new edge(u,v,c));
            }
            m = fs.nextInt();
            for(int i=0;i<m;i++){
                int u = fs.nextInt();
                int v = fs.nextInt();
                int c = fs.nextInt();
                al.add(new edge(u,v,c));
            }
            Collections.sort(al);
            for(edge e:al){
                int u = e.u;
                int v = e.v;
                int c = e.c;
                int x = findParent(u);
                int y = findParent(v);
                if(x==y)
                    continue;
                cost+=c;
                if(rnk[x] > rnk[y]){
                    pr[y] = x;
                }
                else{
                    pr[x] = y;
                    if(rnk[x]==rnk[y])
                        rnk[y]++;
                }
            }
            System.out.println(cost);
        }
    }


    static class edge implements Comparable<edge>{
        int u,v,c;
        edge(int u,int v,int c){
            this.u = u;
            this.v = v;
            this.c = c;
        }
        @Override
        public int compareTo(edge o){
            return Integer.compare(this.c,o.c);
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