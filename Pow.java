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
