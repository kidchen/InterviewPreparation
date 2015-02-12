import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int items = s.nextInt();
        for(int i = 0; i < items; i++) {
            long n = s.nextLong();
            long mask = 0xffffffffL;
            long result = n ^ mask;
            System.out.println(result);
        }
    }
}
