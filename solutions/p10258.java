// Apurv Parekh

import java.util.*;
import java.io.*;

class Main{

    static FastReader fs = new FastReader();
    static Contestant [] cn;
    static boolean [] valid;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        fs.nextLine();
        boolean flag = false;
        while(tc-- > 0){
            cn = new Contestant[101];
            for(int i=0;i<=100;i++) 
                cn[i]=new Contestant();
            valid = new boolean[101];
            StringTokenizer st;
            String line;
            while(true){
                line = fs.nextLine();
                if(line == null || line.isEmpty()) break;

                st = new StringTokenizer(line);

                int n,p,t; String r;

                n = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());
                r = st.nextToken();

                if(!valid[n]){
                    valid[n] = true;
                    cn[n].no = n;
                    cn[n].solved = 0;
                    cn[n].time = 0;
                }         
                if(r.equals("I")){
                    if(!cn[n].problems[p]) 
                        cn[n].incorrects[p]++;
                }
                    
                else if(r.equals("C")){
                    if(!cn[n].problems[p]){
                        cn[n].time+=(t + 20*cn[n].incorrects[p]);
                        cn[n].solved++;
                        cn[n].problems[p]=true;
                    }
                }
                
            }
            Arrays.sort(cn);
            if(flag) System.out.println(); flag=true;
            for(int i=0;i<=100;i++)
                if(valid[cn[i].no]){
                    System.out.println(cn[i].no+" "+cn[i].solved+" "+cn[i].time);
                }
            
        }
    }

    static class Contestant implements Comparable<Contestant> {
        int no,solved,time;
        boolean []problems = new boolean[10];
        int []incorrects = new int[10];

        @Override
        public int compareTo(Contestant b){
            if(this.solved == b.solved && this.time==b.time)
                return this.no-b.no;
            if(this.solved == b.solved) 
                return this.time - b.time;
            return b.solved - this.solved;
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