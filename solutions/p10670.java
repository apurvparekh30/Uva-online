import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,m,l;


    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            n = fs.nextInt();
            m = fs.nextInt();
            l = fs.nextInt();
            ArrayList<agency> al = new ArrayList<>();
            for(int i=0;i<l;i++){
                StringTokenizer st = new StringTokenizer(fs.nextLine());
                String name = st.nextToken(":");
                int a = Integer.parseInt(st.nextToken(",").substring(1));
                int b = Integer.parseInt(st.nextToken());
                int cost = 0;
                int nn = n;
                //System.out.println(a + " " + b);
                while(nn > m){
                    if((nn/2) < m || ((nn - (nn/2)) * a) < b) {
                       cost+=a;
                       nn=nn-1; 
                       continue;
                    }
                    cost+=b;
                    nn=nn/2;
                    
                }
                al.add(new agency(name, cost));
            }
            Collections.sort(al);
            System.out.printf("Case %d\n",tt);
            for(agency ag:al){
                System.out.println(ag);
            }
        }
    }

    static class agency implements Comparable<agency>{
        String name;
        int cost;
        agency(String name,int cost){
            this.name = name;
            this.cost = cost;
        }
        @Override
        public int compareTo(agency other){
            if(this.cost == other.cost)
                return this.name.compareTo(other.name);
            return Integer.compare(this.cost, other.cost);
        }
        @Override
        public String toString(){
            return name+" "+cost;
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