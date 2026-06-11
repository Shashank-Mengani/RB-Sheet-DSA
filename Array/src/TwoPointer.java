import java.util.Arrays;

public class TwoPointer {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12,0,4};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] num = {0,1,2,4,3,6};
        int target = 2;
        System.out.println(Arrays.toString(twoSum(num, target)));

        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 283. Move Zeroes
    static void moveZeroes(int[] nums) {

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0){
                swap(nums, right, left);
                left++;
            }
        }
    }

    private static void swap(int[] nums, int right, int left) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    // 167. Two Sum II - Input Array Is Sorted
    static int[] twoSum(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int sum = nums[left] + nums[right];

            if (sum == target){
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }

    // 75. Sort Colors
    static void sortColors(int[] nums) {

        // Sorting 0's
        int left = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
            }
        }

        // Sorting 2's to last
        int right = nums.length - 1;
        for(int i=nums.length - 1; i>=0; i--){
            if(nums[i] == 2){
                swap(nums, i, right);
                right--;
            }
        }
    }
}
