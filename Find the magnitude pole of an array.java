// two passes, first pass we find the max value we found so far and set this value's position to true in bitset
// second pass, we traverse the array from the last element, and find the min value we found so far and set its position to true
// at last, we do AND operation to the two bitset, and return the first bit's position that set to true 

// O(n), O(n) space cost

import java.util.BitSet;

public class MagnitudePole {
    public static void main(String[] args) {
    // TODO Auto-generated method stub 
    int[] test = { 4, 2, 2, 3, 1, 4, 7, 8, 6, 9 }; 
    System.out.println(magnitudePole(test));
    }
    public static int magnitudePole(int[] A) { 
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE; 
        BitSet bits1 = new BitSet(A.length); 
        BitSet bits2 = new BitSet(A.length); 
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= max) { bits1.set(i);
            max = A[i]; 
        }
    }
    for (int i = A.length - 1; i >= 0; i--) {
        if (A[i] <= min) { 
            bits2.set(i);
            min = A[i]; 
        }
    }
    bits1.and(bits2);
    return bits1.nextSetBit(0);
    } 
}
