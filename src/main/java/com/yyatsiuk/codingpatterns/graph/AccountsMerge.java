package com.yyatsiuk.codingpatterns.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class AccountsMerge {

    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<>();

    private void dfs(List<String> mergedAccount, String email) {
        visited.add(email);
        mergedAccount.add(email);

        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(mergedAccount, neighbor);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        for (List<String> account : accountList) {
            int accountSize = account.size();

            // Building adjacency list
            // Adding edge between first email to all other emails in the account
            String accountFirstEmail = account.get(1);
            adjacent.putIfAbsent(accountFirstEmail, new ArrayList<>());
            for (int j = 2; j < accountSize; j++) {
                String accountEmail = account.get(j);

                adjacent.get(accountFirstEmail).add(accountEmail);

                adjacent.putIfAbsent(accountEmail, new ArrayList<>());
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }

        // Traverse over all the accounts to store components
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accountList) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);

            // If email is visited, then it's a part of different component
            // Hence perform DFS only if email is not visited yet
            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);

                dfs(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }

        return mergedAccounts;
    }

    public static void main(String[] args) {
        /*
        accounts =
        [["John","johnsmith@mail.com","john_newyork@mail.com"],
        ["John","johnsmith@mail.com","john00@mail.com"],
        ["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
         */

        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> accountList = new ArrayList<>();
        accountList.add(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accountList.add(List.of("John", "johnsmith@mail.com", "john00@mail.com"));
        accountList.add(List.of("Mary", "mary@mail.com"));
        accountList.add(List.of("John", "johnnybravo@mail.com"));

        List<List<String>> mergedAccounts = accountsMerge.accountsMerge(accountList);
        System.out.println(mergedAccounts);
    }
}
