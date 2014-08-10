/*
A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. Following is an example:
The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

*/
 public static Integer[] getMaxInSlideWindow(Integer[] A, Integer w) {
     // invalid input
     if (A == null || w <= 0 || A.length - w < 0) return null;

     Integer[] B = new Integer[A.length - w + 1];

     // auxiliary queue that is sorted in descending order
     LinkedList<Integer> q = new LinkedList<Integer>();

     for (int i = 0; i < A.length; i++) {
         // enqueue. Remove those smaller values
         int data = A[i];
         while (!q.isEmpty() && q.getLast() < data) {
             q.removeLast();
         }
         q.add(data);

         if (i < w - 1) continue; 

         // dequeue. If the current number is the maximum. Also remove it
         // from the queue
         B[i - w + 1] = q.get(0);
         if (A[i - w + 1] == B[i - w + 1]) {
             q.removeFirst();
         }
     }

     return B;
 }
