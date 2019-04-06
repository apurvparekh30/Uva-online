import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static Map<Integer,List<Integer>> map;
    static int n;
    static int[]colorCount;
    static int mycolor[];

    static boolean dfs(int u,int color){
        colorCount[color] += 1;
        mycolor[u] = color;
        for(int v:map.get(u)){
            if(mycolor[v] == mycolor[u]){
                return false;
            }
            if(mycolor[v]==-1)
                if(!dfs(v,1-color))
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        fs.nextLine();
        while(tc-- > 0){
            fs.nextLine();
            n = fs.nextInt();
            map = new HashMap<>();
            for(int i=1;i<=n;i++)
                map.put(i,new ArrayList<>());
            for(int i=1;i<=n;i++){
                int v = fs.nextInt();
                while(v-- > 0) {
                    int node = fs.nextInt();
                    if(node >n)
                        continue;
                    map.get(i).add(node);
                    map.get(node).add(i);
                }
            }
            int ans = 0;
            mycolor = new int[n+1];
            Arrays.fill(mycolor,-1);
            for(int i=1;i<=n;i++){
                if(mycolor[i]!=-1)
                    continue;
                colorCount = new int[2];
                boolean ret = dfs(i,0);
                if(ret){
                    ans += Math.max(colorCount[0],colorCount[1]);
                }
            }
            System.out.println(ans);
        }
    }
}