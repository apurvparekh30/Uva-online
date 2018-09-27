import java.util.*;
import java.io.*;

class Main {
    final static int max = 5842;
    static FastReader fs = new FastReader();
    static String arr[] = {"th","st","nd","rd","th","th","th","th","th","th"};
    static TreeSet<Long> ts;
    static ArrayList<Long> al = new ArrayList<Long>();
    static PriorityQueue<Long> pq = new PriorityQueue<Long>();
    static int n;
    

    static void generate(){
        //al.add(1L);
        pq.add(1L);
        while(true){
            if(al.size()>max) break;
            Long tmp = pq.poll();
            al.add(tmp);
            if(!pq.contains(tmp*2)){
                pq.add(2*tmp);
            }
            if(!pq.contains(tmp*3)){
                pq.add(3*tmp);
            }
            if(!pq.contains(tmp*5)){
                pq.add(5*tmp);
            }
            if(!pq.contains(tmp*7)){
                pq.add(7*tmp);
            }
        }
        Collections.sort(al);
        //System.out.println(al);
    }
    public static void main(String[] args) {
        generate();
        while(true){
            n = fs.nextInt();
            if(n==0) break;
            if (n % 100 == 11 || n % 100 == 12 || n % 100 == 13)
                System.out.printf("The %dth humble number is %d.\n",n,al.get(n-1));
            else
                System.out.printf("The %d%s humble number is %d.\n",n,arr[n%10],al.get(n-1));
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
