class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        int min1 = Integer.MAX_VALUE;
        int secondMin1 = Integer.MAX_VALUE;

        int min2 = Integer.MAX_VALUE;
        int secondMin2 = Integer.MAX_VALUE;

        for(int x:nums){
            if (x % 3 == 1) {
                if (x < min1) {
                    secondMin1 = min1;
                    min1 = x;
                } else if (x < secondMin1) {
                    secondMin1 = x;
                }
            }

            if (x % 3 == 2) {
                if (x < min2) {
                    secondMin2 = min2;
                    min2 = x;
                } else if (x < secondMin2) {
                    secondMin2 = x;
                }
            }
        }
        int rem = sum % 3;

        if (rem == 0) {
            return sum;
        }

        if (rem == 1) {
            int remove1 = min1;
            int remove2 =  (min2 != Integer.MAX_VALUE && secondMin2 != Integer.MAX_VALUE)
               ? min2 + secondMin2
               : Integer.MAX_VALUE;

            return sum - Math.min(remove1, remove2);
        }

        int remove1 = min2;
        int remove2 =  (min1 != Integer.MAX_VALUE && secondMin1 != Integer.MAX_VALUE)
               ? min1 + secondMin1
               : Integer.MAX_VALUE;

        return sum - Math.min(remove1, remove2);
    }
}