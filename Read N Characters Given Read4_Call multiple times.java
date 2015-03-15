/*
The read function may be called multiple times.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    /*
    1. buffer – An array of size 4 use to store data returned by read4 temporarily. 
        If the characters were read into the buffer and were not used partially, they will be used in the next call.
    2. offset – Use to keep track of the offset index where the data begins in the next read call. 
        The buffer could be read partially (due to constraints of reading up to n bytes) and therefore leaving some data behind.
    3. bufsize – The real buffer size that stores the actual data. 
        If bufsize > 0, that means there is partial data left in buffer from the last read call 
        and we should consume it before calling read4 again. 
        On the other hand, if bufsize == 0, it means there is no data left in buffer.
    */
     
    private char[] buffer = new char[4];
    int offset = 0; 
    int bufsize = 0;

    public int read(char[] buf, int n) {
        int Readbytes = 0;
        boolean lessthan4 = false;
        int bytes = 0;
        
        while(!lessthan4 && Readbytes<n){
            // no data left in buffer: update bufsize & lessthan4
            if(bufsize == 0){
                bufsize = read4(buffer);
                lessthan4 = bufsize < 4;
            }
            bytes = Math.min(n - Readbytes, bufsize);
            for(int i=0; i<bytes; i++){
                // offset + i
                buf[Readbytes + i] = buffer[offset + i];
            }
            
            // update offset
            offset = (offset + bytes) % 4;
            bufsize -= bytes;
            Readbytes += bytes;
        }
        return Readbytes;
    }
}   
