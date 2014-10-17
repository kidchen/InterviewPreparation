// Implement pow(x, n).
// O(logn), space cost O(logn) --> recursion stack cost

public class Solution {
    public double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        boolean neg = false;
        if(n < 0) {
            neg = true;
            n *= -1;
        }
        double half = pow(x, n/2);
        // !!! if n is an odd number, we need to multiple additional x !!!
        double odd = pow(x, n - n/2*2);
        if(neg) {
            return 1/(half * half * odd);
        }
        return half * half * odd;
    }
}


/******* OLD VERSION *******/

public class Solution {
    public double pow(double x, int n) {
        // Attention: use power recursion rather than pow itself
        if(n < 0) return 1 / power(x, -n);
        else return power(x, n);
    }
    
    double power(double x, int n) {
        if(n == 0) return 1;
        double half = power(x, n/2);
        if(n%2 == 0) return half * half;
        else return half * half *x;
    }
}


// Thought: pow(x,n) = pow(x, n/2) * pow(x, n - n/2)
// if n < 0: return 1 / pow(x, -n)
// if n > 0: check n%2 and return half * half (* x)
