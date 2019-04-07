import java.util.*;


class Main {

    static Scanner fs =  new Scanner(System.in);
    static Map<Integer,ArrayList<Integer>> adj;
    static Map<String,Integer> map;
    static int []dfsNum,dfsLow;
    static Stack<Integer> st;
    static boolean visited[];
    static int n,m;
    static int counter;
    static List<String> list;

    static void dfs(int u){
        dfsLow[u] = dfsNum[u] = counter++;
        visited[u] = true;
        st.push(u);

        for(int v:adj.get(u)){
            if(dfsNum[v]==-1)
                dfs(v);
            if(visited[v])
                dfsLow[u] = Math.min(dfsLow[u],dfsLow[v]);
        }
        if(dfsNum[u] == dfsLow[u]){
            StringBuilder sb = new StringBuilder();
            boolean comma = false;
            while(true){
                int v = st.pop();
                visited[v] = false;
                if(comma)
                    sb.append(", ");
                comma = true;
                sb.append(list.get(v));
                if(v==u)
                    break;
            }
            System.out.println(sb);
        }
    }
    public static void main(String[] args) {
        boolean line = false;
        int tc = 0;
        while(true){
            tc++;
            int n = fs.nextInt();
            int m = fs.nextInt();

            if(n==0 && m==0)
                break;
            map = new HashMap<>();
            adj = new HashMap<>();
            list = new ArrayList<>();
            int num = 0;
            for(int i=0;i<m;i++){
                String x = fs.next();
                String y = fs.next();
                if(!map.containsKey(x)){
                    map.put(x,num++);
                    list.add(x);
                }
                if(!map.containsKey(y)){
                    map.put(y,num++);
                    list.add(y);
                }
                 
                if(!adj.containsKey(map.get(x))){
                    adj.put(map.get(x),new ArrayList<>());
                }
                adj.get(map.get(x)).add(map.get(y));
            }
            for(int i=0;i<n;i++){
                if(!adj.containsKey(i))
                    adj.put(i,new ArrayList<>());
            }
            //System.out.println(adj);
            dfsLow = new int[n];
            dfsNum = new int[n];
            Arrays.fill(dfsNum,-1);
            visited = new boolean[n];
            st = new Stack();
            if(line)
                System.out.println();
            line = true;
            System.out.printf("Calling circles for data set %d:\n",tc);
            counter = 0;
            if(m > 0){
                for(int i=0;i<n;i++){
                    if(dfsNum[i]==-1){
                        dfs(i);
                    }
                }
            }
            ///System.out.println();
        }
    }
}