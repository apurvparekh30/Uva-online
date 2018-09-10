import java.util.*;
import java.io.*;

class Main {

    

    static FastReader fs = new FastReader();
    static Deque<Car> qe[];
    static final int LEFT = 0;
    static final int RIGHT = 1;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        qe = new Deque[2];
        qe[0] = new ArrayDeque<Car>();
        qe[1] = new ArrayDeque<Car>();
        int []ans;

        boolean flag = false;
        while(tc-- > 0){
            int n,t,m;
            n = fs.nextInt();
            t = fs.nextInt();
            m = fs.nextInt();
            ans = new int[m];

            int i = 0;

            while(m-- > 0){
                int tt = fs.nextInt();
                String bank = fs.next();
                if(bank.equals("left"))
                    qe[0].addLast(new Car(i,tt));
                else 
                    qe[1].addLast(new Car(i,tt));
                i++;
            }

            
            int currTime = 0;
            int dir = LEFT;

            while(true){
                if(qe[LEFT].isEmpty() && qe[RIGHT].isEmpty()) break;
                int next = 0;
                if(!qe[LEFT].isEmpty())
                    next = qe[LEFT].getFirst().t;
                if(!qe[RIGHT].isEmpty())
                    next = Math.min(next,qe[RIGHT].getFirst().t);
                
                currTime = Math.max(currTime,next);
                int carCount=0;
                while(!qe[dir].isEmpty() && carCount<n && qe[dir].getFirst().t <= currTime){
                    ans[qe[dir].removeFirst().id] = currTime + t;
                    carCount++;
                }
                currTime+=t;
                dir=dir^1;
            }   
            
            if(flag) System.out.println(); flag=true;
            for(int a:ans)
                System.out.println(a);
        }
    }

    static class Car {
        int id,t;
        Car(){}
        Car(int id,int t){
            this.id=id;
            this.t=t;
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