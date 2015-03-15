/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. 
For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note: The read function will only be called once for each test case.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        
        boolean lessthan4 = false;
        int Readbyte = 0;
        int bytes = 0;
        
        while(!lessthan4 && Readbyte<n){
            int size = read4(buffer);
            if(size<4){
                lessthan4 = true;
            }
            
            // n-Readbyte: only need to read *this* more, size: only *this* left
            bytes = Math.min(n - Readbyte, size);
            for(int i=0; i<bytes; i++){
                buf[Readbyte + i] = buffer[i];
            }
            Readbyte += bytes;
        }
        return Readbyte;
    }
}
