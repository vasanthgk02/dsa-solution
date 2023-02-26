class Solution {
    
    int helper(String s1, String s2, int i, int j, int dp[][]){
        if(i == 0 && j == 0) return s1.charAt(0) == s2.charAt(0) ? 0 : 1;
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = helper(s1, s2, i - 1, j - 1, dp);
            return dp[i][j];
        }
        int insert = helper(s1, s2, i, j - 1, dp);
        int remove = helper(s1, s2, i - 1, j, dp);
        int replace = helper(s1, s2, i - 1, j - 1, dp);
        dp[i][j] = Math.min(insert, Math.min(remove, replace)) + 1;
        return dp[i][j];
    }
    
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 || word2.length() == 0) 
            return Math.max(word1.length(), word2.length());
        int dp[][] = new int[word1.length()][word2.length()];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        return helper(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }
}