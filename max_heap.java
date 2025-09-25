public class max_heap {

      private int capacity;
      private int size;
      private int[] heap;

      public  max_heap(int capacity) {

        this.capacity = capacity;
        this.size = 1;
        this.heap = new int[capacity];
      }
    
    private int parent(int current) {
        return current/2;                   // algo for parent node
    }
    private int left(int current) {
        return current * 2;                 // algo for left child
    }
    private int right(int current) {
        return current * 2 + 1;             // algo for right child
    }

      public void add(int value) {

        if(size == capacity) {
        System.out.println("overflow");
        return;
        }

        heap[size] = value;
        int current = size;

        while(current > 1 && heap[current] > heap[parent(current)]) {

            int temp = heap[current];
            heap[current] = heap[parent(current)];
            heap[parent(current)] = temp;
            current = parent(current);
        }
        size++;
      }

    public int pop() {
        int max = heap[1];
        heap[1] = heap[size-1];
        size--;

        heapify(1);
        return max;

        
    }

    public void heapify(int current) {
        
        int largest = current;
        int left = left(current);
        int right = right(current);

        if(left < size && heap[left] > heap[largest]) largest = left;
        if(right < size && heap[right] > heap[largest]) largest = right;

        if(largest != current) {

          int temp = heap[current];
          heap[current] = heap[largest];
          heap[largest] = temp;

          heapify(largest);
        }
            
    }
}