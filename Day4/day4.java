package Day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class day4 {

    public static String generateMD5Hash(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String text = "ckczppom";
        for (boolean part2 : new boolean[] { false, true }) {
            int i = 0;
            while (true) {
                String num = String.valueOf(i);
                String ans = generateMD5Hash(text + num);
                if (!part2) {
                    if (ans.startsWith("00000")) {
                        System.out.println("Part1 : " + i);
                        break;
                    }
                    i++;
                    continue;
                }
                if (part2) {
                    if (ans.startsWith("000000")) {
                        System.out.println("Part2 : " + i);
                        break;
                    }
                    i++;
                    continue;
                }
            }
        }

    }

}
