/*
You are given a non-negative integer N, find the last non-zero digit of N!.
*/

class Solution {
    public int lastDigit(int n) {
        int result = 1;
        int two = 0;
        int five = 0;
        for(int i = 1; i <= n; i++) {
            int number = i;
            while(number % 2 == 0) {
                two++;
                number /= 2;
            }
            while(number % 5 == 0) {
                five++;
                number /= 5;
            }
            result *= number;
            result %= 10;
        }
        int leftTwo = two - five;
        for(int i = 0; i < leftTwo; i++) {
            result *= 2;
            result %= 10;
        }
        return result;
        }
}
