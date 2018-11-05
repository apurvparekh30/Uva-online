import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static ArrayList<forward> al;
    static boolean vis[];

    static class forward{
        int src,start,end,tar;
        forward(int src,int start, int end,int tar){
            this.src = src;
            this.start = start;
            this.end = end;
            this.tar = tar;
        }
        @Override
        public String toString(){
            return start+" "+end+" "+tar;
        }
    }

    static int rec(int t,int ext){
        if(vis[ext])
            return 9999;
        for(forward f: al){
            int src = f.src;
            int st = f.start;
            int en = f.end;
            int tar = f.tar;
            
            if(src == ext){
                if(t>=st && t<=en){
                    vis[ext] = true;
                    return rec(t,tar);
                }
            }
        }
        return ext;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        System.out.println("CALL FORWARDING OUTPUT");
        for(int t=1;t<=tc;t++){
            al = new ArrayList<forward>();
            String ext,st,en,tar;
            while(true){
                ext = fs.next();
                if(ext.equals("0000"))
                    break;
                st = fs.next();
                en = fs.next();
                tar = fs.next();
                al.add(new forward(Integer.parseInt(ext),Integer.parseInt(st),
                    Integer.parseInt(st)+Integer.parseInt(en),Integer.parseInt(tar)));
            }
            String time;
            System.out.println("SYSTEM " + t);
            while(true){
                vis = new boolean[10000];
                time = fs.next();
                if(time.equals("9000"))
                    break;
                tar = fs.next();
                int ans = rec(Integer.parseInt(time),Integer.parseInt(tar));
                String s = "0000" + Integer.toString(ans);
                System.out.printf("AT %s CALL TO %s RINGS %s\n",time,tar,s.substring(s.length()-4));
            }            
        }
        System.out.println("END OF OUTPUT");
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