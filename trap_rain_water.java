class Solution {
    int trap(int[] height) {
        int lmax=0;
        int rmax=0;
        int l=0;
        int r=height.length-1;
        int t=0;
        while(l<r){
            if(height[l]<height[r]){
                if(height[l]>=lmax){
                lmax=height[l];
                }
                 else {
                    t += lmax - height[l];
                }
                l++;
            }
            else{
                 if (height[r] >= rmax) {
                    rmax = height[r];
                } else {
                    t += rmax - height[r];
                }
                r--;
            }
        }
        return t;
    }
}
