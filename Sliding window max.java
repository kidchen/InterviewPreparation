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
