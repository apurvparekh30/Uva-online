import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static Map<Character,ArrayList<Character>> adj;
    static Map<Character,Integer> in;
    static List<Character> list;
    
    static void dfs(String s){
        if(s.length() == list.size()){
            System.out.println(s);
            return;
        }
        for(int i=0;i<list.size();i++){
            char c = list.get(i);
            if(in.get(c)==0){
                for(char v:adj.get(c)){
                    in.put(v,in.get(v)-1);
                }
                in.put(c,in.get(c)-1);
                dfs(s+c);
                for(char v:adj.get(c)){
                    in.put(v,in.get(v)+1);
                }
                in.put(c,in.get(c)+1);
            }
        }
    }

    public static void main(String[] args) {
        boolean newline = false;
        while(fs.hasNextLine()) {
            String line = fs.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            adj = new HashMap<>();
            in = new HashMap<>();
            list = new ArrayList<>();
            while(st.hasMoreTokens()){
                char c = st.nextToken().charAt(0);
                adj.put(c,new ArrayList<>());
                in.put(c,0);
                list.add(c);
            }
            Collections.sort(list);
            st = new StringTokenizer(fs.nextLine());
            while(st.hasMoreElements()){
                char u = st.nextToken().charAt(0);
                char v = st.nextToken().charAt(0);
                adj.get(u).add(v);
                in.put(v,in.get(v)+1);
            }
            if(newline)
                System.out.println();
            newline = true;
            dfs("");
        }
    }
}