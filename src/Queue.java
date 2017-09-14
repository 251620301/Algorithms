import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    public static void main(String args[]) {
        Queue<String> s  = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!"-".equals(item)){
                s.enqueue(item);
            } else if(!s.isEmpty()){
                StdOut.print(s.dequeue()+" ");
            }
        }
        StdOut.println(s.size()+"left in stack");
    }
}
