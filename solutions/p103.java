import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int k,n;
    static int []dp;
    static int [][]box;
    static int []parent;

    static int rec(int idx){
        if(idx > k){
            return 0;
        }
        if(dp[idx]!=-1)
            return dp[idx];
        int ans = 0;
        for(int i=1;i<=k;i++){
            boolean flag = true;
            for(int j=0;j<n;j++){
                if(box[idx][j] >= box[i][j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                int temp = rec(i);
                if(temp > ans) {
                    ans = temp;
                    parent[idx] = i;
                }
            }
        }
        return dp[idx] = ans + 1;
    }
    public static void main(String[] args) {
        while(fs.hasNextInt()){
            k = fs.nextInt();
            n = fs.nextInt();
            dp = new int[k+1];
            box = new int[k+1][];
            parent = new int[k+1];
            box[0] = new int[n];
            for(int i=1;i<=k;i++){
                box[i] = new int[n];
                for(int j=0;j<n;j++){
                    box[i][j] = fs.nextInt();
                }
                Arrays.sort(box[i]);
            }
            Arrays.fill(dp,-1);
            int ans = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<=k;i++){
                Arrays.fill(parent,-1);
                Arrays.fill(dp,-1);
                int temp = rec(i);
                if(ans < temp){
                    ans = temp;
                    int t = i;
                    sb = new StringBuilder();
                    sb.append(i);
                    while(parent[t]!=-1){
                        sb.append(" " + parent[t]);
                        t = parent[t];
                    }
                }
            }
            System.out.println(ans);
            System.out.println(sb);
        }
    }
}