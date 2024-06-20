class Solution {
    public int missingNumber(int[] nums) {
        int totalNumbers=nums.length;
        
        int sumofTotalNumbers= (totalNumbers * (totalNumbers+1))/2;
        int sumOfNumbersPresent=0;
        for(int i=0;i<totalNumbers;i++){
            sumOfNumbersPresent+=nums[i];
        }

        return (sumofTotalNumbers-sumOfNumbersPresent);

    }
}
