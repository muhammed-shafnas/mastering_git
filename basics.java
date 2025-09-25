
import java.util.PriorityQueue;

public class basics {
    public static void main(String[] args) {
       PriorityQueue<Integer> heap = new PriorityQueue<>();

       heap.add(4);
       heap.add(8);
      System.out.println( heap.poll());
        
    }
}