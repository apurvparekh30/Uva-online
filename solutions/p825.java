import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n,m;
    static Map<Integer,HashSet<Integer>> map;
    static int dp[][];


    static int rec(int i,int j){
        if(i==n-1 && j==m-1){
            return 1;
        }
            
        if(i>=n || j>=m)
            return 0;
        if(map.get(i).contains(j))
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans = 0;
        ans += rec(i+1,j);
        ans += rec(i,j+1);
        return dp[i][j] = ans;
    }


    
    public static void main(String[] args) {
        int tc = Integer.parseInt(fs.nextLine());
        boolean line = false;
        while(tc-- > 0){
            fs.nextLine();
            StringTokenizer st = new StringTokenizer(fs.nextLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new HashMap<>();
            for(int i=0;i<n;i++){
                st = new StringTokenizer(fs.nextLine());
                int node = Integer.parseInt(st.nextToken())-1;
                map.put(node,new HashSet<>());
                while(st.hasMoreTokens()){
                    map.get(node).add(Integer.parseInt(st.nextToken())-1);
                }
            }
            //System.out.println(map);
            dp = new int[n][m];
            for(int []r:dp){
                Arrays.fill(r,-1);
            }
            if(line)
                System.out.println();
            line = true;
            System.out.println(rec(0,0));
        }   
    }   
}