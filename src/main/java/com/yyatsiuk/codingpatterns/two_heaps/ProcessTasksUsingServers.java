package com.yyatsiuk.codingpatterns.two_heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/process-tasks-using-servers/">1882. Process Tasks Using Servers</a>
 */
public class ProcessTasksUsingServers {

    private static class Server {
        private final int weight;
        private final int index;
        private int freeTime;

        public Server(int weight, int index, int freeTime) {
            this.weight = weight;
            this.index = index;
            this.freeTime = freeTime;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        Queue<Server> freeServers = new PriorityQueue<>((server1, server2) -> {
            int diff = server1.weight - server2.weight;
            if (diff == 0) {
                return server1.index - server2.index;
            }

            return diff;
        });
        Queue<Server> busyServers = new PriorityQueue<>(Comparator.comparingInt(server -> server.freeTime));

        for (int i = 0; i < servers.length; i++) {
            freeServers.add(new Server(servers[i], i, 0));
        }

        int[] ans = new int[tasks.length];
        int index = 0;
        int time = 0;

        while (index < ans.length) {
            while (!busyServers.isEmpty() && busyServers.peek().freeTime <= time) {
                freeServers.add(busyServers.poll());
            }

            while (!freeServers.isEmpty() && index <= time && index < ans.length) {
                Server freeServer = freeServers.poll();
                ans[index] = freeServer.index;
                freeServer.freeTime = time + tasks[index];
                busyServers.add(freeServer);
                index++;
            }

            if (!freeServers.isEmpty()) {
                time++;
            } else {
                time = busyServers.peek().freeTime;
            }
        }

        return ans;
    }

}
