class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       
        if(nums1.length > nums2.length) //cause we want to traverse through the short array
        {
            int temp[]= nums1;
            nums1= nums2;
            nums2 =temp;
        }
        int low = 0;
        // int partX,partY,leftX,leftY,rightX, rightY;
        int hi = nums1.length;
        int combinedLength = nums1.length +nums2.length;
       
        while(low<=hi)
        {
           int partX= (hi+low)/2;
           int partY = (combinedLength + 1)/2 - partX;
           
           int leftX=findMax(nums1,partX);
            int leftY=findMax(nums2,partY);

           int rightX=findMin(nums1,partX);
           int rightY=findMin(nums2,partY);
           
            if(leftX<=rightY && leftY<=rightX)
            {
                if(combinedLength%2==0)
                {
                    return (Math.max(leftX,leftY) + Math.min(rightX,rightY))/2.0;
                }
             
                    return Math.max(leftX , leftY);
               
            }
            if(leftX>rightY)
            {
                hi = partX-1;
            }
            else
            {
                low = partX+1;
            }
           
        }
        return -1;
    }
    private int findMax(int[] nums,int partition)
    {
        if(partition<=0)
        {
            return (int)Double.NEGATIVE_INFINITY;
        }
        else return nums[partition-1];
           
    }
      private int findMin(int[] nums,int partition)
    {
        if(partition>=nums.length)
        {
            return (int)Double.POSITIVE_INFINITY;
        }
        else return nums[partition];
           
    }
   
}
//leetcode link : https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
// resource link : https://www.youtube.com/watch?v=lLFDQCDzfpI&t=611s
