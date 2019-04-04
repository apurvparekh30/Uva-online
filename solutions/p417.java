import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static ArrayList<String> al = new ArrayList<>();
    static TreeMap<String,Integer> ts = new TreeMap<>(new MyComp());
    
    static void rec(char []s,char c,int idx){
        if(5==idx)
            return;
        /* if(('z' - c + 1) < (5-idx))
            return; */
        for(char ch = c;ch<='z';ch++){
            s[idx] = ch;
            String tmp = new String(s,0,idx+1);
            al.add(tmp);
            rec(s,(char)(ch+1),idx+1);
        }
    }
    public static void main(String[] args) {
        rec(new char[5],'a',0);
        Collections.sort(al, new MyComp());
        for(int i=0;i<al.size();i++){
            //System.out.println(al.get(i));
            ts.put(al.get(i),i+1);
        }
        while(true){
            String nxtLine = fs.nextLine();
            if(nxtLine ==null || nxtLine.isEmpty())
                break;
            char []arr = nxtLine.toCharArray();
            boolean flag = true;
            for(int i=1;i<arr.length;i++){
                if(arr[i-1] > arr[i]){
                    flag  = false;
                    break;
                }
            }
            if(!flag){
                System.out.println("0");
            }
            else {
                System.out.println(ts.get(nxtLine));
            }
        }
    }

    static class MyComp implements Comparator<String>{
        @Override
        public int compare(String a,String b){
            if(a.length()==b.length()){
                return a.compareTo(b);
            }
            return Integer.compare(a.length(), b.length());
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