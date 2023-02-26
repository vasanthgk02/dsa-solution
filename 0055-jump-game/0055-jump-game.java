class Solution {
    
    boolean helper(int arr[], int ind, int dp[]){
        if(ind == arr.length - 1) return true;
        if(dp[ind] != 0) return dp[ind] == 2;
        for(int steps = 1; steps <= arr[ind]; steps++){
            if(helper(arr, ind + steps, dp) == true){
                dp[ind + steps] = 2;
                return true;
            }
        }
        dp[ind] = 1;
        return false;
    }
    
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        return helper(nums, 0, dp);
    }
}