import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {
    public static double timeTrial(int N) {
        int[] a = new int[N];
        for (int i=0;i<a.length;i++) {
            a[i] = StdRandom.uniform(-1000000,1000000);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSumFast.count(a);
        return timer.elapsedTime();
    }

    public static void main(String args[]) {
        for (int N = 1;true;N+=N) {
            StdOut.println(N+"      "+timeTrial(N));
        }
    }
}
