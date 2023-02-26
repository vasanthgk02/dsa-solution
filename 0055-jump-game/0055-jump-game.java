class Solution {
    
    boolean helper(int arr[], int ind, int dp[]){
        if(ind == arr.length - 1) return true;
        if(dp[ind] != -1) return dp[ind] == 1;
        for(int steps = 1; steps <= arr[ind]; steps++){
            if(helper(arr, ind + steps, dp) == true){
                dp[ind + steps] = 1;
                return true;
            }
        }
        dp[ind] = 0;
        return false;
    }
    
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
}