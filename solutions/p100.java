import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int L,R;
    static HashMap <Integer,Integer> hm = new HashMap<Integer,Integer>();

    static int func(int i){
        if(hm.containsKey(i))
            return hm.get(i);
        if(i%2 == 1){
            int tmp = 1 + func(3*i+1);
            hm.put(i,tmp);
            return tmp;
        }
        int tmp = 1 + func(i/2);
        hm.put(i,tmp);
        return tmp;
    }

    /* static int func(int i){
        if(i==1) return 1;
        if(i%2 == 1)
            return 1+func((3*i)+1);
        return 1+func(i/2);
    }
 */
    public static void main(String[] args) {
        hm.put(1, 1);
        while(true){
            String line = fs.nextLine();
            if(line == null || line.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(line);
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            int l = L;
            int r = R;
            if(L > R){
                int tmp = L;
                L = R;
                R = tmp;
            }
            int ans = 0;
            for(int i = L;i<=R;i++){
                ans=Math.max(ans,func(i)); 
            } 
            System.out.printf("%d %d %d\n",l,r,ans);  
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