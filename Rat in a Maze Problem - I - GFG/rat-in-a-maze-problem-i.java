//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
        
    public static ArrayList<String> helper(int[][] m, int n, int i, int j, ArrayList<String> res, String carry){
        if(i == n - 1 && j == n - 1 ){
            res.add(new String(carry.toCharArray()));
            return res;
        }
        // System.out.println(carry);
        if(j + 1 < n && (carry.length() == 0 || carry.charAt(carry.length() - 1) != 'L') && m[i][j + 1] != 0){
            m[i][j + 1] = 0;
            helper(m, n, i, j + 1, res, carry + "R");
            m[i][j + 1] = 1;
        }
        if(j - 1 >= 0 && (carry.length() == 0 || carry.charAt(carry.length() - 1) != 'R') && m[i][j - 1] != 0){
            m[i][j - 1] = 0;
            helper(m, n, i, j - 1, res, carry + "L");
            m[i][j - 1] = 1;
        }
        if(i + 1 < n && (carry.length() == 0 || carry.charAt(carry.length() - 1) != 'U') && m[i + 1][j] != 0){
            m[i + 1][j] = 0;
            helper(m, n, i + 1, j, res, carry + "D");
            m[i + 1][j] = 1;
        }
        if(i - 1 >= 0 && (carry.length() == 0 || carry.charAt(carry.length() - 1) != 'D') && m[i - 1][j] != 0){
            m[i - 1][j] = 0;
            helper(m, n, i - 1, j, res, carry + "U");
            m[i - 1][j] = 1;
        }
        return res;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        if(m[0][0] == 0){
            ArrayList<String> res = new ArrayList<String>();
            res.add("-1");
            return res;
        }
            
        return helper(m, n, 0, 0, new ArrayList<String>(), "");
    }
}