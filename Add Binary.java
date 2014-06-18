public class Solution {
    public String addBinary(String a, String b) {
        // length of a and b
        int alen = a.length() - 1;
        int blen = b.length() - 1;
        // change string a, b to char
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        int carry = 0;
        // add 3: two for alen/blen - 1, and one for carry
        char[] result = new char[Math.max(alen, blen) + 3];
        int index = 0;
        // add two:
        while(true) {
            if(alen < 0 && blen < 0 && carry == 0) {
                break;
            }
            // !!! initial aint and bint, because one of them may be not available in next if() !!!
            int aint = 0;
            int bint = 0;
            // !!! >= should be add equal, because alen/blen is length - 1 !!!
            if(alen >= 0) {
                aint = achar[alen] - '0';
            }
            if(blen >= 0) {
                bint = bchar[blen] - '0';
            }
            // !!! have to add '0', to change int into char !!!
            if(aint + bint + carry > 1) {
                result[index] = (char)('0' + aint + bint + carry - 2);
                carry = 1;
            } else {
                result[index] = (char)('0' + aint + bint + carry);
                carry = 0;
            }
            alen--;
            blen--;
            index++;
        }
        // !!! should use stringBuffer.reverse.tostring !!!
        // !!! should use string(char[], int, length) to new a substring !!!
        return new StringBuffer(new String(result,0,index)).reverse().toString();
    }
}
