package com.coding.aligntechne.deloitte;

import java.util.*;

public class PlayerOfTheYear {

    // Function to find the player of the year
    public static int playerOfTheYear(int N, int M, int[][] data) {
        int result = -404;
        Map<Integer, Integer> playerPerformance = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int maxPerformance = Integer.MIN_VALUE;
            int topPlayer = -1;
            for (int j = 0; j < N; j++) {
                int performance = data[j][i];
                if (performance > maxPerformance) {
                    maxPerformance = performance;
                    topPlayer = j;
                }
            }
            playerPerformance.put(topPlayer, playerPerformance.getOrDefault(topPlayer, 0) + 1);
        }
        int maxDuration = Integer.MIN_VALUE;
        for (int duration : playerPerformance.values()) {
            maxDuration = Math.max(maxDuration, duration);
        }
        List<Integer> topPlayers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : playerPerformance.entrySet()) {
            if (entry.getValue() == maxDuration) {
                topPlayers.add(entry.getKey() + 1);
            }
        }
        if (topPlayers.size() == 1) {
            result = topPlayers.get(0);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] data = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        int result = playerOfTheYear(N, M, data);
        System.out.println(result);
        scanner.close();
    }
}
//3
//4
//1 3 4 5
//7 2 3 4
//1 3 2 1