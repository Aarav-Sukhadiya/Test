public class A2020 {

    static int MinOp(int n, int k) {
        /*
         * Coded By Me
         * 
         */
        int min_op = 0;
        int highest_pow = 0;

        while (n != 0) {
            if (k > n) {
                min_op = n;
                break;
            } 
            else {
                while (true) {
                    if (n / (Math.pow(k, highest_pow)) >= 1) {
                        highest_pow++;
                    } else {
                        break;
                    }
                }
                highest_pow--;
                for (int pow = highest_pow; pow >= 0; pow--) {
                    while(n >= (Math.pow(k, pow))){
                        n -= (Math.pow(k, pow));
                        min_op++;
                    }
                }
            }
        }

        return min_op;
    }
    static int minOperations(int n, int k) {
        /*
         * Most Optimal Solution
         * 
         */
        int sum = 0;
        while (n > 0) {
            sum += n % k;  
            n /= k;
        }
        return sum;
    }

     public static void main(String[] args) {

        int n = 35658765;
        int k = 56;

        // Force garbage collection for accurate memory check
        System.gc();
        Runtime runtime = Runtime.getRuntime();

        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.currentTimeMillis();

        // ---- MAIN LOGIC ----
        int result = minOperations(n, k);
        System.out.println(result);
        int result2 = MinOp(n, k);
        System.out.println(result2);
        // --------------------

        long endTime = System.currentTimeMillis();
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();

        // Calculate memory usage
        long memoryUsedBytes = afterMemory - beforeMemory;
        double memoryUsedKB = memoryUsedBytes / 1024.0;
        double memoryUsedMB = memoryUsedKB / 1024.0;

        // Print execution time and memory
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");
        System.out.println("Memory Used: " + memoryUsedBytes + " bytes");
        System.out.printf("Memory Used: %.3f KB\n", memoryUsedKB);
        System.out.printf("Memory Used: %.6f MB\n", memoryUsedMB);

    }
}