public class BinaryHeadImp{
    public static void main(String [] args) throws Exception{
        int [] heap = { -4, 2, 7, 6, 45, 57, 13, 224, 18 };
    //  ---------------------
        System.out.print("Heap: ");
        for (int i = 0; i < heap.length; i++) {
         System.out.print(heap[i] + " ");
        }
        System.out.println();
    //  ---------------
        System.out.println("2nd Smallest numbest: " + findSecondSmallest(heap));
        System.out.println("4nd Smallest numberst: " + findFourthSmallest(heap));
        System.out.println("Largest: " + findTheLargestValue(heap));
    }
    public static int findSecondSmallest(int [] heap) throws Exception{
        if (heap == null || heap.length < 2) {
            throw new Exception("Heap needs 2 elements");
        }
        int leftChild = heap[1];
        if (heap.length == 2) {
            return leftChild;
        }

        // right child = 2(0) + 2 = 2
        int rightChild = heap[2];

        // Return the smaller child of the root
        if (leftChild > rightChild) {
            return rightChild;
        } else {
            return leftChild;
        }
    }
     public static int findFourthSmallest(int[] heap) throws Exception {
        if (heap == null || heap.length < 4) {
            throw new Exception("Heap needs at least 4 elements");
        }

        // Create a copy of the heap and simulate removals
        int[] temp = heap.clone();

        // Extract the minimum (root) three times
        for (int i = 0; i < 3; i++) {
            removeMin(temp);
        }

        // The root after 3 removals is the 4th smallest
        return temp[0];
    }

    // Helper method to remove the minimum (root) from a min-heap
    private static void removeMin(int[] heap) {
        int n = heap.length;
        if (n == 0) return;

        heap[0] = heap[n - 1];
        heap[n - 1] = Integer.MAX_VALUE; // mark as removed
        heapifyDown(heap, 0, n - 1);
    }

    // Restores heap property after removing the min
    private static void heapifyDown(int[] heap, int i, int size) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] < heap[smallest]) smallest = left;
        if (right < size && heap[right] < heap[smallest]) smallest = right;

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            heapifyDown(heap, smallest, size);
        }
    }
    // Find Largest
    public static int findTheLargestValue(int[] heap) throws Exception {
        if (heap == null || heap.length == 0) {
            throw new Exception("Heap is empty");
        }

        // In a min-heap, the largest value will be among the leaves
        int start = heap.length / 2; // first leaf index
        int largest = heap[start];

        for (int i = start + 1; i < heap.length; i++) {
            if (heap[i] > largest) {
                largest = heap[i];
            }
        }
        return largest;
    }
}