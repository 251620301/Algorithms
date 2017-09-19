import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] a;
    private int count;
    private int[] sz;

    public UF(int N) {
        a = new int[N];
        count = N;
        for(int i=0;i<a.length;i++) {
            a[i] = i;
        }
        sz = new int[N];
        for(int i=0;i<a.length;i++) {
            sz[i] = 1;
        }
    }

    public void union(int p,int q) {
        int pID = find(p);
        int qID = find(q);
        if(pID==qID) {
            return;
        }
        if(sz[pID]<sz[qID]) {
            a[pID] = qID;
            sz[qID] += sz[pID];
        }else{
            a[qID]=pID;
            sz[pID] += sz[qID];
        }
        count--;
    }

    public int find(int p) {
        while (p!=a[p]){
            p = a[p];
        }
        return p;
    }



    public boolean connected(int p,int q) {
        return find(p)==find(q);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)){
                continue;
            } else {
                uf.union(p,q);
                StdOut.println(p + " " + q);
            }
        }
        StdOut.println(uf.count()+"components");
    }
}
