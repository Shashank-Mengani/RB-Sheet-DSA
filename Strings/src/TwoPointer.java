import java.util.Arrays;

public class TwoPointer {
    public static void main(String[] args) {
        String str = "hello";
        char[] arr = str.toCharArray();
        reverseString(arr);
        System.out.println(arr);

        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        String word = "abca";
        System.out.println(validPalindrome(word));
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

    // 125. Valid Palindrome
    static boolean isPalindrome(String s){

        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            //Ignoring Digits from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            //Ignoring Digits from Right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 680. Valid Palindrome II
    static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return palindrome(s, left + 1, right) || palindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean palindrome(String s, int left, int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
