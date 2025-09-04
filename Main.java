import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long minOperations(long n, long k) {
        long sum = 0;
        if (k == 1) {
            sum = n;
        } else {
            while (n > 0) {
                sum += n % k;
                n /= k;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt(); // number of test cases
        while (t-- > 0) {
            long n = in.nextLong();
            long k = in.nextLong();
            out.println(minOperations(n, k));
        }

        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
