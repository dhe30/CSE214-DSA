package A;
public class Fibonacci {
    public static long F(int n) {
        long[] f = new long[n+1];
        f[0] = 0;
        f[1] = 1;
        return G(n, f);
    }

    public static long G(int n, long[] f) {
        if (f[n] == 0 && n != 0) return G(n-1, f) + G(n-2, f);
        else return f[n];
    }

    public static long fibVar2(int n){
        long[] f = new long[n+1];
        f[0] = 0;
        f[1] = 1;
        fibSplit(f, 2, n);
        return f[n];
    }

    public static void fibSplit(long[] f, int low, int high) {
        int mid = (high + low) / 2;
        if (low == high) {
            f[low] = f[low - 1] + f[low - 2];
        } else {
            fibSplit(f, low, mid);
            fibSplit(f, mid + 1, high);
        }
    }

    public static long fibona(int n) {
        int curr = 0;
        int next = 0;
        int prev = 1;
        for (int i = 0; i < n; i++) {
            next = curr + prev; 
            prev = curr; 
            curr = next; 
        }
        return curr;
    }
    public static void main (String[] args) {
        System.out.println(F(20));
    }
}
