import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        List<Summand> l1 = Polymath.parse(sc.nextLine());
        if (!sc.hasNextLine()) return;
        List<Summand> l2 = Polymath.parse(sc.nextLine());

        List<Summand> result = Polymath.multiply(l1, l2);
        if (result.isEmpty()) {
            System.out.println(0);
            return;
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            Summand s = result.get(i);
            int c = s.coeff;

            if (i > 0) {
                if (c > 0) out.append(" + ");
                else out.append(" - ");
            } else {
                if (c < 0) out.append("-");
            }

            int absC = Math.abs(c);
            if (s.totalDeg > 0) {
                if (absC != 1) {
                    out.append(absC).append("*");
                }
            } else {
                out.append(absC);
            }
            out.append(s.vars);
        }
        System.out.println(out.toString());
    }
}