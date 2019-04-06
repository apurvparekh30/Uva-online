import java.util.*;

class Main {
    static Scanner fs = new Scanner(System.in);
    static int n, m;
    static Map<Integer, List<Integer>> map;
    static int[] in;

    public static void main(String[] args) {
        while (true) {

            n = fs.nextInt();
            m = fs.nextInt();
            if (n == 0 && m == 0)
                break;
            in = new int[n + 1];
            map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                map.get(u).add(v);
                in[v]++;
            }
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (in[i] == 0)
                    q.offer(i);
            }
            if (q.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            List<Integer> list = new ArrayList<>();
            while (!q.isEmpty()) {
                int curr = q.poll();
                list.add(curr);
                for (int v : map.get(curr)) {
                    in[v]--;
                    if (in[v] == 0) {
                        q.offer(v);
                    }
                }
            }
            if(list.size()==n){
                for (int i : list) {
                    System.out.println(i);
                }
            }
            else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}