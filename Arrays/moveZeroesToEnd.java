// brute force : pretty simple : store non zero in another array and zero in another array . merge both arrays 

//better at space complextiy

class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                for(int j=i+1;j<nums.length;j++){
                 if(nums[j]!=0){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    break;

                }
            }
            }
            
        }
    }
}



//optimal : two pointer approach


class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[lastNonZeroFoundAt]=nums[i];
                lastNonZeroFoundAt++;
            }

            
        }
        for(int i=lastNonZeroFoundAt;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
