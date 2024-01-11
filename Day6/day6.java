package Day6;

import java.io.FileNotFoundException;
import java.util.List;

import Helper.File;

public class day6 {

    public static int numOfLights(int[][] lights) {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (lights[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long brightness(int[][] lights) {
        long sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                sum += lights[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {

        int[][] lights = new int[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                lights[i][j] = 0;
            }
        }

        List<List<String>> instructions = File.readInput("input/6.txt", " ");

        for (List<String> i : instructions) {
            if (i.get(1).equals("off")) {
                String[] start = i.get(2).split(",");
                String[] end = i.get(4).split(",");
                int x0 = Integer.parseInt(start[0]);
                int y0 = Integer.parseInt(start[1]);
                int x1 = Integer.parseInt(end[0]);
                int y1 = Integer.parseInt(end[1]);

                for (int j = x0; j <= x1; j++) {
                    for (int k = y0; k <= y1; k++) {
                        lights[j][k] = 0;
                    }
                }
                continue;
            }
            if (i.get(1).equals("on")) {
                String[] start = i.get(2).split(",");
                String[] end = i.get(4).split(",");
                int x0 = Integer.parseInt(start[0]);
                int y0 = Integer.parseInt(start[1]);
                int x1 = Integer.parseInt(end[0]);
                int y1 = Integer.parseInt(end[1]);

                for (int j = x0; j <= x1; j++) {
                    for (int k = y0; k <= y1; k++) {
                        lights[j][k] = 1;
                    }
                }
                continue;
            }
            if (i.get(0).equals("toggle")) {
                String[] start = i.get(1).split(",");
                String[] end = i.get(3).split(",");
                int x0 = Integer.parseInt(start[0]);
                int y0 = Integer.parseInt(start[1]);
                int x1 = Integer.parseInt(end[0]);
                int y1 = Integer.parseInt(end[1]);

                for (int j = x0; j <= x1; j++) {
                    for (int k = y0; k <= y1; k++) {
                        if (lights[j][k] == 1) {
                            lights[j][k] = 0;
                        } else {
                            lights[j][k] = 1;
                        }
                    }
                }
                continue;
            }
        }

        System.out.println("Part1 : " + numOfLights(lights));

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                lights[i][j] = 0;
            }
        }

        for (List<String> i : instructions) {
            if (i.get(1).equals("off")) {
                String[] start = i.get(2).split(",");
                String[] end = i.get(4).split(",");
                int x0 = Integer.parseInt(start[0]);
                int y0 = Integer.parseInt(start[1]);
                int x1 = Integer.parseInt(end[0]);
                int y1 = Integer.parseInt(end[1]);

                for (int j = x0; j <= x1; j++) {
                    for (int k = y0; k <= y1; k++) {
                        if (lights[j][k] == 0) {
                            continue;
                        }
                        lights[j][k] -= 1;
                    }
                }
                continue;
            }
            if (i.get(1).equals("on")) {
                String[] start = i.get(2).split(",");
                String[] end = i.get(4).split(",");
                int x0 = Integer.parseInt(start[0]);
                int y0 = Integer.parseInt(start[1]);
                int x1 = Integer.parseInt(end[0]);
                int y1 = Integer.parseInt(end[1]);

                for (int j = x0; j <= x1; j++) {
                    for (int k = y0; k <= y1; k++) {
                        lights[j][k] += 1;
                    }
                }
                continue;
            }
            if (i.get(0).equals("toggle")) {
                String[] start = i.get(1).split(",");
                String[] end = i.get(3).split(",");
                int x0 = Integer.parseInt(start[0]);
                int y0 = Integer.parseInt(start[1]);
                int x1 = Integer.parseInt(end[0]);
                int y1 = Integer.parseInt(end[1]);

                for (int j = x0; j <= x1; j++) {
                    for (int k = y0; k <= y1; k++) {
                        lights[j][k] += 2;
                    }
                }
                continue;
            }
        }

        System.out.println("Part2 : " + brightness(lights));

    }
}
