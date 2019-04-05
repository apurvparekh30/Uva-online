import java.util.*;

class Main {
    static Scanner fs = new Scanner(System.in);
    static HashMap<Character, List<Character>> adj;

    public static void main(String[] args) {
        
        while (fs.hasNextLine()) {
            adj = new HashMap<>();
            List<String> list = new ArrayList<>();
            HashMap<Character, Integer> in = new HashMap<>();
            while (true) {
                String next = fs.nextLine();
                if (next.equals("#")) {
                    break;
                }
                list.add(next);
                for (char c : next.toCharArray()) {
                    adj.put(c, new ArrayList<>());
                    in.put(c, 0);
                }

            }

            String curr = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                String next = list.get(i);
                for (int j = 0; j < curr.length() && j < next.length(); j++) {
                    if (curr.charAt(j) != next.charAt(j)) {
                        char c = next.charAt(j);
                        adj.get(curr.charAt(j)).add(c);
                        in.put(c, in.get(c) + 1);
                        break;
                    }
                }
                curr = next;
            }

            StringBuilder sb = new StringBuilder();
            Queue<Character> q = new ArrayDeque<>();
            for (char c : in.keySet()) {
                if (in.get(c) == 0)
                    q.offer(c);
            }
            while (!q.isEmpty()) {
                char cur = q.poll();
                sb.append(cur);
                for (char c : adj.get(cur)) {
                    in.put(c, in.get(c) - 1);
                    if (in.get(c) == 0)
                        q.offer(c);
                }
            }
            System.out.println(sb);
        }
    }
}