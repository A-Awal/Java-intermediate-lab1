package org.example.algorithm.ex2;

import java.util.Arrays;

public class LongestCommonSubsequence {
    static int[][] memo; // Memoization table

    public static int findLongestCommonSubsequence(String string1, String string2){
        memo = new int[string1.length() + 1][string2.length() + 1];
        for (int[] row : memo)
           Arrays.fill(row, -1);

        return lcsMemo(string1, string2, string1.length(), string2.length());
    }

    private static int lcsMemo(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (memo[m][n] != -1)
            return memo[m][n];
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return memo[m][n] = 1 + lcsMemo(X, Y, m - 1, n - 1);
        else
            return memo[m][n] = Math.max(lcsMemo(X, Y, m, n - 1), lcsMemo(X, Y, m - 1, n));
    }

   public static void main(String[] args) {
       String S1 = "AGGTAB";
       String S2 = "GXTXAYB";

       int lcs = findLongestCommonSubsequence(S1, S2);
       
       System.out.println("Length of LCS using memoization: " + lcs);
   }
}

