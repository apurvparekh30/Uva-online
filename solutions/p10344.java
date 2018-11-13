import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int[] arr;
    static boolean possible;

    static boolean rec(int i, long ans) {
        if (i == 5) {
            if (ans == 23L)
                return true;
            return false;
        }
        return (rec(i + 1, ans + arr[i]) || rec(i + 1, ans - arr[i]) || rec(i + 1, ans * arr[i]));
    }

    static boolean next_permutation(){
        int n = arr.length,i=n-2;
        while(i>=0 && arr[i]>=arr[i+1])
            i--;
        if(i==-1){
            return false;
        }
        int x = arr[i],j=n-1;
        while(j>i && arr[j]<=x)
            j--;
        arr[i] = arr[j];
        arr[j] = x;
        Arrays.sort(arr,i+1,n);
        return true;
    }

    public static void main(String[] args) {
        while (true) {
            arr = new int[5];
            for (int i = 0; i < 5; i++)
                arr[i] = fs.nextInt();
            if (arr[0] == 0)
                break;
            possible = false;
            Arrays.sort(arr);
            do{
                if(rec(1,arr[0])){
                    possible = true;
                    break;
                }
            } while(next_permutation());
            if(possible)
                System.out.println("Possible");
            else
                System.out.println("Impossible");
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