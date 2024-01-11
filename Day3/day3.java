package Day3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Helper.File;

public class day3 {

    public static boolean isCoordExists(List<List<Integer>> list, int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0) == x && list.get(i).get(1) == y) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<List<String>> arrows = File.readInput("input/3.txt", "");
        int r = File.getRows(arrows);
        int c = File.getCols(arrows);

        // File.printList(arrows);

        List<List<Integer>> coords = new ArrayList<>();
        List<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(0);
        coords.add(start);

        List<List<Integer>> coords_robo = new ArrayList<>();
        coords_robo.add(start);

        int x = 0;
        int y = 0;

        int xr = 0;
        int yr = 0;

        int turn = 0;

        // part1
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arrows.get(i).get(j).equals("^")) {
                    x -= 1;
                    if (!isCoordExists(coords, x, y)) {
                        List<Integer> t = new ArrayList<>();
                        t.add(x);
                        t.add(y);
                        coords.add(t);
                    }
                    continue;
                }
                if (arrows.get(i).get(j).equals("v")) {
                    x += 1;
                    if (!isCoordExists(coords, x, y)) {
                        List<Integer> t = new ArrayList<>();
                        t.add(x);
                        t.add(y);
                        coords.add(t);
                    }
                    continue;
                }
                if (arrows.get(i).get(j).contains(">")) {
                    y += 1;
                    if (!isCoordExists(coords, x, y)) {
                        List<Integer> t = new ArrayList<>();
                        t.add(x);
                        t.add(y);
                        coords.add(t);
                    }
                    continue;
                }
                if (arrows.get(i).get(j).contains("<")) {
                    y -= 1;
                    if (!isCoordExists(coords, x, y)) {
                        List<Integer> t = new ArrayList<>();
                        t.add(x);
                        t.add(y);
                        coords.add(t);
                    }
                    continue;
                }
            }
        }

        System.out.println("Part1: " + coords.size());
        coords.clear();
        coords.add(start);
        x = 0;
        y = 0;

        // part2
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arrows.get(i).get(j).equals("^")) {
                    if (turn == 0) {
                        x -= 1;
                        if (!isCoordExists(coords, x, y)) {
                            List<Integer> t = new ArrayList<>();
                            t.add(x);
                            t.add(y);
                            coords.add(t);
                        }
                        turn = 1;
                        continue;
                    } else {
                        xr -= 1;
                        if (!isCoordExists(coords_robo, xr, yr)) {
                            List<Integer> t = new ArrayList<>();
                            t.add(xr);
                            t.add(yr);
                            coords_robo.add(t);
                        }
                        turn = 0;
                        continue;
                    }

                }
                if (arrows.get(i).get(j).equals("v")) {
                    if (turn == 0) {
                        x += 1;
                        if (!isCoordExists(coords, x, y)) {
                            List<Integer> t = new ArrayList<>();
                            t.add(x);
                            t.add(y);
                            coords.add(t);
                        }
                        turn = 1;
                        continue;
                    } else {
                        xr += 1;
                        if (!isCoordExists(coords_robo, xr, yr)) {
                            List<Integer> t = new ArrayList<>();
                            t.add(xr);
                            t.add(yr);
                            coords_robo.add(t);
                        }
                        turn = 0;
                        continue;
                    }
                }
                if (arrows.get(i).get(j).contains(">")) {
                    if (turn == 0) {
                        y += 1;
                        if (!isCoordExists(coords, x, y)) {
                            List<Integer> t = new ArrayList<>();
                            t.add(x);
                            t.add(y);
                            coords.add(t);
                        }
                        turn = 1;
                        continue;
                    } else {
                        yr += 1;
                        if (!isCoordExists(coords_robo, xr, yr)) {
                            List<Integer> t = new ArrayList<>();
                            t.add(xr);
                            t.add(yr);
                            coords_robo.add(t);
                        }
                        turn = 0;
                        continue;
                    }
                }
                if (arrows.get(i).get(j).contains("<")) {
                    if (turn == 0) {
                        y -= 1;
                        if (!isCoordExists(coords, x, y)) {
                            List<Integer> t = new ArrayList<>();
                            t.add(x);
                            t.add(y);
                            coords.add(t);
                        }
                        turn = 1;
                        continue;
                    } else {
                        yr -= 1;
                        if (!isCoordExists(coords_robo, xr, yr)) {
                            List<Integer> t = new ArrayList<>();
                            t.add(xr);
                            t.add(yr);
                            coords_robo.add(t);
                        }
                        turn = 0;
                        continue;
                    }
                }
            }
        }

        HashSet<List<Integer>> ans = new HashSet<>();

        for (List<Integer> a : coords) {
            ans.add(a);
        }

        for (List<Integer> a : coords_robo) {
            ans.add(a);
        }

        System.out.println("Part2: " + ans.size());

    }

}
