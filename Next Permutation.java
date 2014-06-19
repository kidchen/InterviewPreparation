public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length <= 1) return;
        // scan from the last but one
        // eg : 236541 --> 246531 --> 241356
        // find "3"
        for(int i = num.length - 2; i >= 0; i--) {
            if(num[i] < num[i + 1]) {
                // !!! have to new a j before for loop, this j will be used later !!!
                int j;
                for(j = num.length - 1; j > i; j--) {
                    // find "4"
                    if(num[j] > num[i]) {
                        break;
                    }
                }
                // swap "3" and "4"
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
                reverse(num, i + 1, num.length - 1);
                return;
            }
        }
        // eg: 654321 --> 123456
        reverse(num, 0, num.length - 1);
        return;
    }
    
    void reverse(int[] num, int start, int end) {
        while(start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }
}
