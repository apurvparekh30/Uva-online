import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int t,p,s;
    static HashMap<String,Integer> hm;
    static MyString tp[];
    static int g[][];
    
    static void rec(int u,int pos,int []sol,int used){
        if(pos==s){
            boolean space = false;
            for(int i=0;i<s;i++){
                if(space)
                    System.out.print(" ");
                space = true;
                System.out.print(tp[sol[i]].s.toUpperCase());
            }
            System.out.println();
            return;
        }
        for(int i=u+1;i<t;i++){
            boolean valid = true;
            for(int j=0;j<pos;j++){
                if(g[sol[j]][i]==0){
                    valid = false;
                    break;
                }
            }
            if(!valid)
                continue;
            if((used & (1<<i))>0)
                continue;
            sol[pos] = i;
            rec(i,pos+1,sol,used|(1<<i));
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int cse=1;cse<=tc;cse++){
            hm = new HashMap<>();
            t = fs.nextInt();
            p = fs.nextInt();
            s = fs.nextInt();
            
                
            g = new int[t][t];
            tp = new MyString[t];

            for(int i=0;i<t;i++){
                for(int j=i;j<t;j++)
                    g[i][j] = 1;
            }
                
            for(int i=0;i<t;i++){
                tp[i] = new MyString(fs.next());
            }
            
            Arrays.sort(tp);

            for(int i=0;i<t;i++){
                hm.put(tp[i].s,i);
            }
            for(int i=0;i<p;i++){
                String u,v;
                u = fs.next();
                v = fs.next();
                int uu=-1,vv=-1;
                if(hm.containsKey(u) && hm.containsKey(v)){
                    uu = hm.get(u);
                    vv = hm.get(v);
                    g[uu][vv] = 0;
                    g[vv][uu] = 0;
                }
            }
            System.out.printf("Set %d:\n",cse);
            for(int i=0;i<t;i++){
                int []sol = new int[s];
                sol[0] = i;
                rec(i,1,sol,(1<<i));
            }
            System.out.println();
        }
    }

    static class MyString implements Comparable<MyString>{
        String s;
        MyString(String s){
            this.s = s;
        }
        @Override
        public int compareTo(MyString other){
            if(other.s.length() == this.s.length())
                return this.s.compareTo(other.s);
            return Integer.compare(other.s.length(), this.s.length());
        }
        /* @Override
        public String toString(){
            return this.s;
        } */
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