import java.util.*;
import java.io.*;

class Main {
    static int []arr;
    static int n;
    static FastReader fs = new FastReader();
    static ArrayList<pair> al;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        for(int tt=1;tt<=tc;tt++){
            n = fs.nextInt();
            arr = new int[n];
            al = new ArrayList<>();
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            Arrays.sort(arr); 
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for(int i=0;i<n;i++)
                dq.addLast(arr[i]);
            int totalTime = 0;
            //System.out.println(dq);
            while(true){
                int sz = dq.size();
                int A = dq.pollFirst();
                if(sz == 1){
                    totalTime+=A;
                    al.add(new pair(A,-1));
                    break;
                }
                int B = dq.pollFirst();
                if(sz == 2){
                    totalTime+=B;
                    al.add(new pair(A,B));
                    break;
                }
                int C = dq.pollLast();
                if(sz == 3){
                    totalTime+=A+B+C;
                    al.add(new pair(A,B));
                    al.add(new pair(A,-1));
                    al.add(new pair(A,C));
                    break;
                }
                //System.out.println(dq.toString());
                int D = dq.pollLast();
                if((A+D)<(2*B)){
                    //System.out.println("executed first");
                    totalTime+=C+2*A+D;
                    al.add(new pair(A,C));
                    al.add(new pair(A,-1));
                    al.add(new pair(A,D));
                    al.add(new pair(A,-1));
                    dq.addFirst(B);
                    dq.addFirst(A);
                }
                else{
                    //System.out.println("executed second");
                    totalTime+=2*B+A+C;
                    al.add(new pair(A,B));
                    al.add(new pair(A,-1));
                    al.add(new pair(D,C));
                    al.add(new pair(B,-1));
                    dq.addFirst(B);
                    dq.addFirst(A);
                }
                //System.out.println("al " + al);
                //System.out.println(dq);
            }
            if(flag)
                System.out.println();
            flag = true;
            System.out.println(totalTime);
            for(pair p:al){
                System.out.println(p);
            }
        }
    }

    static class pair{
        int a,b;
        pair(int a,int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public String toString(){
            if(b==-1)
                return a+"";
            return a+" "+b;
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