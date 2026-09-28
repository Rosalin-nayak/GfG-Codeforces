class Solution {
    // static int[] dp;
    // public int findMaxSum(int[] arr){
    //     dp=new int[arr.length]; 
    //     Arrays.fill(dp,-1);
    //     return loot(0,arr);
    // }
    // public int loot(int i,int[] arr){
    //     if(i>=arr.length) return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     int pick=arr[i]+loot(i+2,arr);
    //     int skip=loot(i+1,arr);
    //     int ans=Math.max(pick,skip);
    //     dp[i]=ans;
    //     return ans;
    // }
    
    public int findMaxSum(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];
        dp[0]=arr[0];
        if(n>1) dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(arr[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}