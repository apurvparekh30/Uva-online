
// Apurv Parekh

import java.util.*;

class Main {

    static Scanner scan = new Scanner(System.in);
    static int n, curr, prev;
    static BitSet bits;

    public static void main(String[] args) {
        while (scan.hasNext()) {
            n = scan.nextInt();
            bits = new BitSet(n);
            bits.set(0, true);
            for (int i = 0; i < n; i++) {
                curr = scan.nextInt();
                if (i != 0) {
                    int index = Math.abs(curr - prev);
                    if (index < n)
                        bits.set(index, true);
                }
                prev = curr;
            }
            // System.out.println(bits.length());
            if (bits.cardinality() == n)
                System.out.println("Jolly");
            else
                System.out.println("Not jolly");
        }
    }
}