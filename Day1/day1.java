package Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class day1 {
    public static void main(String[] args) {
        for (boolean part2 : new boolean[] { false, true }) {
            try {
                int sum = 0;
                int i = 0;
                BufferedReader br = new BufferedReader(new FileReader("input/1.txt"));
                for (String line : br.lines().toList()) {
                    for (String ch : line.split("")) {
                        if (!part2) {
                            if (ch.equals("(")) {
                                sum += 1;
                                continue;
                            }
                            if (ch.equals(")")) {
                                sum -= 1;
                                continue;
                            }
                        }
                        if (part2) {
                            if (ch.equals("(")) {
                                sum += 1;
                                i++;
                            }
                            if (ch.equals(")")) {
                                sum -= 1;
                                i++;
                            }
                            if (sum == -1) {
                                break;
                            }
                        }
                    }
                }
                String msg = part2 ? "Part2 : " : "Part1 : ";
                int ans = part2 ? i : sum;
                System.out.println(msg + ans);

            } catch (

            Exception e) {
                e.printStackTrace();
            }
        }

    }

}