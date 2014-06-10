public class Solution {
    public int[] searchRange(int[] A, int target) {
        if(A.length==0 || A==null) return null;
        int[] result = {-1, -1};
        int start = 0, end = A.length-1;
        
        // find the left min (start)
        while(start<end){
            if(start == end - 1){
                if(A[start] != target){
                    start = end;
                }
                break;
            }
            int mid = (start+end)/2;
            if(A[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        // if there is no match !!!
        if(A[start]!=target){
            return result;
        }
        result[0] = start;
        
        // find the right max (end)
        start = 0;
        end = A.length-1;
        while(start<end){
            if(start == end - 1){
                if(A[end] != target){
                    end = start;
                }
                break;
            }
            int mid = (start+end)/2;
            if(A[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }        
        result[1] = end;
        
        return result;
    }
}
