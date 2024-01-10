package Day2;

import java.io.BufferedReader;
import java.io.FileReader;

import Helper.Math;

public class day2 {
    public static void main(String[] args) {
        for (boolean part2 : new boolean[] { false, true }) {
            try {
                int sum = 0;
                BufferedReader br = new BufferedReader(new FileReader("input/2.txt"));
                for (String line : br.lines().toList()) {
                    String[] parts = line.split("x");
                    int l = Integer.parseInt(parts[0]);
                    int w = Integer.parseInt(parts[1]);
                    int h = Integer.parseInt(parts[2]);
                    if (!part2) {
                        sum += 2 * l * w + 2 * w * h + 2 * h * l;
                        sum += Math.smallest(new int[] { l * w, w * h, h * l });
                    }
                    if (part2) {
                        sum += l * w * h;
                        sum += 2 * Math.smallest(new int[] { l + w, w + h, h + l });
                    }
                }
                String msg = part2 ? "Part2 : " : "Part1 : ";
                System.out.println(msg + sum);

            } catch (

            Exception e) {
                e.printStackTrace();
            }
        }

    }
}
