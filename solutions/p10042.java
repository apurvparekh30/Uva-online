import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static Long n;
    static int sum1, sum2;
    static HashMap<Long, Integer> hm = new HashMap<Long, Integer>();

    static int getSum(Long num) {
        if (num == 0L)
            return 0;
        return (int) ((num % 10) + (getSum(num / 10)));
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while (tc-- > 0) {
            n = fs.nextLong();
            Long num;
            Long tmp = n;
            while (true) {
                num = tmp + 1;
                tmp = num;
                // System.out.println(tmp);
                sum1 = getSum(new Long(num));
                sum2 = 0;
                boolean flag = true;
                if (!hm.containsKey(num)){
                    //System.out.println(num + "is not in map");
                    flag = false;
                    for (int j = 2; j <= Math.sqrt(num); j++) {
                        int times = 0;
                        while (num % j == 0) {
                            times++;
                            num = num / j;
                            flag = true;
                        }
                        sum2 += times * getSum(new Long(j));
                    }
                    if (num != 1)
                        sum2 += getSum(new Long(num));
                    if (flag)
                        hm.put(tmp, sum2);
                } else
                    sum2 = hm.get(num);
                //if(tmp==4) System.out.println(tmp + " " + sum2 + " "+sum1+" "+flag);
                if (sum1 == sum2 && flag)
                    break;
            }
            System.out.println(tmp);
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