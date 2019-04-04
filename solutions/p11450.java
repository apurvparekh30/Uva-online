import java.util.*; 

class Main {

    static Scanner fs = new Scanner(System.in);
    static int dp[][];
    static int money;
    static int c;
    static int k;
    static int [][]list;

    static int rec(int i,int m){
        if(i>=c){
            return 0;
        }
        if(dp[i][m]!=-1)
            return dp[i][m];
        dp[i][m] = 0;
        int ans = -1;
        for(int k=0;k<list[i].length;k++){
            if(m + list[i][k]  >  money){
                break;
            } 
            int temp = rec(i+1,m+list[i][k]);
            if(temp == -1)
                ans = Math.max(ans,temp);
            else 
                ans = Math.max(ans,list[i][k] + temp);
        }
        return dp[i][m] = ans;
    }
    public static void main(String[] args) {
        int n = fs.nextInt();
        while(n-- > 0){
            money = fs.nextInt();
            c = fs.nextInt();
            dp = new int [c][money+1];
            for(int []r:dp){
                Arrays.fill(r,-1);
            }
            list = new int[c][];
            for(int i=0;i<c;i++){
                k = fs.nextInt();
                list[i] = new int[k];
                for(int j=0;j<k;j++){
                    list[i][j] = fs.nextInt();                    
                }
                Arrays.sort(list[i]);
            }
           /*  for(int []r:list){
                System.out.println(Arrays.toString(r));
            } */
            int ans = rec(0,0);
            System.out.println((ans==-1) ? "no solution" : ans);
        }
    }
}