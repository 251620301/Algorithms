import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> {
    Node first;
    int N;

    private class Node {
        Item item;
        Node next;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public static void main(String args[]) {
        Stack<String> s;
        s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!"-".equals(item)){
                s.push(item);
            } else if(!s.isEmpty()){
                StdOut.print(s.pop()+" ");
            }
        }
        StdOut.println(s.size()+"left in stack");
    }
}
