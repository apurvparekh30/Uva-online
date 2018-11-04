import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		while (N-- != 0) {
			boolean bad = false;
			char[] cs = bf.readLine().toCharArray();
			Stack<Character> stk = new Stack<Character>();
			for (char c : cs) {
				if (c == '[' || c == '(') {
					stk.push(c);
				} else {
					if (c == ']') {
						if (stk.isEmpty() || stk.peek() == '(')		bad |= true;
					} else if (c == ')') {
						if (stk.isEmpty() || stk.peek() == '[')		bad |= true;
					}
					if (!stk.isEmpty())		stk.pop();
				}
			}
			if (!stk.isEmpty())		bad = true;
			System.out.println(bad ? "No" : "Yes");
		}
	}
}


