import java.util.*;


class Main {
    
    static Scanner fs = new Scanner(System.in);
    static List<Integer> cars;
    static int ferry;
    static int [][]dp;
    static int [][]dir;
    static int n;
    static int []sum;


    static int rec(int i,int w){
        if(i==n)
            return 0;
        if(dp[i][w]!=-1){
            return dp[i][w];
        }
        int p = 0;
        int s = 0;
        if(w + cars.get(i)<=ferry) {
            p = 1+rec(i+1,w+cars.get(i));
        }
        if((sum[i] - w)<= ferry){
            s = 1+rec(i+1,w);            
        }
        if(s > p){
            dir[i][w] = -1;
            return dp[i][w] = s;
        }
        if(p!=0 || s!=0)
            dir[i][w] = 1;
        return dp[i][w] = p;
    }
    public static void main(String[] args) {
        int tc = Integer.parseInt(fs.nextLine());
        boolean newLine = false;
        while(tc-- > 0){
            fs.nextLine();
            cars = new ArrayList<>();
            ferry = Integer.parseInt(fs.nextLine()) * 100;
            while(true){
                int len = Integer.parseInt(fs.nextLine());
                if(len == 0)
                    break;
                cars.add(len);
            }

            n = cars.size();
            if(n==0){
                if(newLine)
                    System.out.println();
                newLine = true;
                System.out.println(0);
                continue;
            }
            sum = new int[n];
            sum[0] = cars.get(0);
            for(int i=1;i<n;i++){
                sum[i] = sum[i-1] + cars.get(i);
            }
            dp = new int[n][ferry+1];
            for(int []r:dp){
                Arrays.fill(r,-1);
            }

            dir = new int[n][ferry+1];
            
            int no = rec(0,0);
            if(newLine)
                System.out.println();
            newLine = true;
            System.out.println(no);
            int w = 0;
            int i = 0;
            while(i < n){
                if(dir[i][w] == 1){
                    System.out.println("port");
                    w = w + cars.get(i);
                }
                else if(dir[i][w]==-1){
                    System.out.println("starboard");
                }
                i = i + 1;
            } 
        }
    }
}