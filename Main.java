
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max_heap heap = new max_heap(20);
        System.out.println("enter kth largest ");
        int k = sc.nextInt();
        heap.add(12);
        heap.add(8);
        heap.add(4);
        heap.add(3);
        heap.add(1);
        

        
        for(int i = 0;i<k;i++) {
            if(i == k-1) {
                System.out.println(heap.pop());
            }
            heap.pop();
        }
        
        
    }
}