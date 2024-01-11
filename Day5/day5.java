package Day5;

import java.io.FileNotFoundException;
import java.util.List;

import Helper.File;

public class day5 {

    public static boolean isVowel(char ch) {
        if ("aeiou".contains(String.valueOf(ch))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> words = File.readInputFull("input/5.txt");
        int r = words.size();

        for (boolean part2 : new boolean[] { false, true }) {
            long sum = 0;

            if (!part2) {
                for (int i = 0; i < r; i++) {
                    int c = words.get(i).length();
                    int vowel_count = 0;
                    boolean isRepeat = false;
                    for (int j = 0; j < c; j++) {
                        if (isVowel(words.get(i).charAt(j))) {
                            vowel_count++;
                        }
                        if (j > 0 && !isRepeat) {
                            if (words.get(i).charAt(j) == words.get(i).charAt(j - 1)) {
                                isRepeat = true;
                            }
                        }
                    }
                    if (vowel_count < 3 || !isRepeat) {
                        continue;
                    }
                    if (words.get(i).contains("ab")
                            || words.get(i).contains("cd")
                            || words.get(i).contains("pq")
                            || words.get(i).contains("xy")) {
                        continue;
                    }
                    sum += 1;

                }
            }
            if (part2) {
                for (int i = 0; i < r; i++) {
                    int c = words.get(i).length();
                    boolean isRepeat = false;
                    boolean middle = false;
                    for (int j = 0; j < c - 1; j++) {
                        if (j == c - 2) {
                            break;
                        }
                        String a = words.get(i).substring(j, j + 2);
                        String b = words.get(i).substring(j + 2);
                        if (b.contains(a) && !isRepeat) {
                            isRepeat = true;
                        }

                    }
                    for (int j = 0; j < c; j++) {
                        if (j > 0 && j < c - 1 && !middle) {
                            if (words.get(i).charAt(j - 1) == words.get(i).charAt(j + 1)) {
                                middle = true;
                            }
                        }
                    }
                    if (!isRepeat || !middle) {
                        continue;
                    }
                    sum += 1;
                }
            }

            String msg = part2 ? "Part2: " : "Part1: ";
            System.out.println(msg + sum);
        }

    }
}
