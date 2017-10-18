import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    private static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i,int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a,int lo,int hi) {
        if(lo>=hi) {
            return;
        }
        int j = patition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static int patition(Comparable[] a,int lo,int hi) {
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (less(v,a[++i])){
                if(i==hi){
                    break;
                }
            }
            while (less(a[--j],v)){
                if(j==lo) {
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

}
