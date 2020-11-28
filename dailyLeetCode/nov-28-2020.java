class Solution {
    
    private int totSum(int []nums){
        int sum=0;
        for(int i=0;i<nums.length;i++)sum+=nums[i];
        return sum;
    }
    int [][]dp;
    boolean solve(int []nums,int sum,int totSum,int idx){
        if(idx>=nums.length)return false;
        if(dp[sum][idx]==1)return true;
        if(dp[sum][idx]==-1)return false;
        if(sum==totSum-sum){
            dp[sum][idx]=1;
        }
        else {
            dp[sum][idx]=(solve(nums,sum+nums[idx],totSum,idx+1)||solve(nums,sum,totSum,idx+1))?1:-1; 
        }
        return (dp[sum][idx]==1);

    }
    public boolean canPartition(int[] nums) {
        int sum=totSum(nums);
        dp=new int[sum+1][nums.length];
        return solve(nums, 0, sum, 0);
    }
}