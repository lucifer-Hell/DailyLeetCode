class Solution {
    

     private int partition (int []nums,int l,int mid ,int r){
        int []temp=new int[r-l+1];
        int left=l,right=mid+1,end=r;
        int idx=0;
        int c=0;
        int pleft=l;
        //calculate the counts
        while(pleft<=mid) {
            int p=mid+1;
            while(p<=r && nums[pleft]>2L*nums[p])p++;
            c+=p-(mid+1);
            pleft++;
        }          
        while(left<=mid && right<=end){

            if(nums[left]>=nums[right]){
                // perform regular merge
                temp[idx++]=nums[right++];
            }else{
                temp[idx++]=nums[left++];
            }
        }
        while(left<=mid){
            temp[idx++]=nums[left++];
        }
        while(right<=end){
            temp[idx++]=nums[right++];
        }
        idx=0;
        for(int i=l;i<=r;i++){
            nums[i]=temp[idx++];
        }
        return c;
    }
  
    private int mergeSort(int []nums,int l,int r){
        if(l>=r)return 0;
        int mid=(l)+(r-l)/2;
        int c=mergeSort(nums,l,mid);
        c+=mergeSort(nums, mid+1, r);
        c+=partition(nums,l,mid,r);
        return c;
    }
    
    public int reversePairs(int[] nums) {
        int c=mergeSort(nums, 0, nums.length-1);
        return c;
    }
}