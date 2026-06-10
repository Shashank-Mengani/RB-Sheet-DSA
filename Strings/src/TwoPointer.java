public class TwoPointer {
    public static void main(String[] args) {
        String str = "hello";
        char[] arr = str.toCharArray();
        reverseString(arr);
        System.out.println(arr);
    }

    // 344. Reverse String
    static void reverseString(char[] s){

        int left = 0;
        int right = s.length - 1;

        while (left < right){
            swap(s, left, right);
            left++;
            right--;
        }
    }

    private static void swap(char[] str, int left, int right) {

        char temp = str[left];
        str[left] = str[right];
        str[right] = temp;
    }
}
