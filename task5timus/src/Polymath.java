import java.util.*;

public class Polymath {
    public static List<Summand> parse(String s) {
        List<Summand> list = new ArrayList<>();
        String clean = s.replace(" ", "").replace("*", "").replace("-", " -").replace("+", " +").trim();
        for (String term : clean.split("\\s+")) {
            if (term.isEmpty()) continue;
            Summand sm = new Summand();
            int letterIdx = -1;
            for (int i = 0; i < term.length(); i++) {
                if (Character.isLetter(term.charAt(i))) {
                    letterIdx = i;
                    break;
                }
            }
            if (letterIdx == -1) {
                sm.coeff = Integer.parseInt(term);
            } else {
                String cStr = term.substring(0, letterIdx);
                if (cStr.isEmpty() || cStr.equals("+")) sm.coeff = 1;
                else if (cStr.equals("-")) sm.coeff = -1;
                else sm.coeff = Integer.parseInt(cStr);

                String vPart = term.substring(letterIdx);
                for (int i = 0; i < vPart.length(); i++) {
                    if (Character.isLetter(vPart.charAt(i))) {
                        char v = vPart.charAt(i);
                        int p = 1;
                        if (i + 1 < vPart.length() && vPart.charAt(i + 1) == '^') {
                            int j = i + 2;
                            while (j < vPart.length() && Character.isDigit(vPart.charAt(j))) j++;
                            p = Integer.parseInt(vPart.substring(i + 2, j));
                            i = j - 1;
                        }
                        sm.powers[v - 'a'] += p;
                        sm.totalDeg += p;
                    }
                }
            }
            list.add(sm);
        }
        return list;
    }

    public static List<Summand> multiply(List<Summand> p1, List<Summand> p2) {
        Map<String, Summand> map = new HashMap<>();
        for (Summand s1 : p1) {
            for (Summand s2 : p2) {
                Summand res = new Summand();
                res.coeff = s1.coeff * s2.coeff;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    res.powers[i] = s1.powers[i] + s2.powers[i];
                    res.totalDeg += res.powers[i];
                    if (res.powers[i] > 0) {
                        if (sb.length() > 0) sb.append("*");
                        sb.append((char) ('a' + i));
                        if (res.powers[i] > 1) sb.append("^").append(res.powers[i]);
                    }
                }
                res.vars = sb.toString();
                if (map.containsKey(res.vars)) map.get(res.vars).coeff += res.coeff;
                else map.put(res.vars, res);
            }
        }
        List<Summand> result = new ArrayList<>();
        for (Summand s : map.values()) if (s.coeff != 0) result.add(s);
        result.sort((a, b) -> {
            if (a.totalDeg != b.totalDeg) return b.totalDeg - a.totalDeg;
            for (int i = 0; i < 26; i++) {
                if (a.powers[i] != b.powers[i]) return b.powers[i] - a.powers[i];
            }
            return 0;
        });
        return result;
    }
}