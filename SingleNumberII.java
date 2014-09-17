/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

// Method 1: HashMap
// O(n), O(n) space for the map

public class Solution {
    public int singleNumber(int[] A) {
        int result = A[0];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        for(int i : map.keySet()) {
            if(map.get(i) < 3) {
                return i;
            }
        }
        return result;
    }
}


// Method 2: Bit operation
// O(n), O(1) space
// create a int[32] num, num[i] means all digits in position i appear num[i] times
// if num[i] is multipled by 3, ignore, otherwise extract it and return the result

public class Solution {
    public int singleNumber(int[] A) {
        int[] num = new int[32];
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < A.length; j++) {
                // calculate each digit in every number appears how many time in each position
                num[i] += (A[j] >> i) & 1;
            }
        }
        int result = 0;
        for(int i = 0; i < 32; i++) {
            // !!! move left for i, because we need to move back for last step !!!
            result += (num[i] % 3) << i;
        }
        return result;
    }
}


// Method 3: Bit operation (unknown)
// O(n), O(1) space

   public int singleNumber(int[] A) {

        int a = 0; int b = 0; int c = 0;
        for(int i=0;i<A.length; i++){
            b |= a&A[i];  //出现两次的 就加到B里面
            a ^= A[i];    //从A里面删除 出现两次的
            c = ~(a&b);   //如果是三次的 就会同时出现在A和B里面， 
            a &= c;       //然后删除A里三次的
            b &= c;       //删除B里三次的
        }
        return a;
    }
