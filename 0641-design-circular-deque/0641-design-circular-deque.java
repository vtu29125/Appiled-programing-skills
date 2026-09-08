class MyCircularDeque {

    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add element at front
    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        // Move front backward circularly
        front = (front - 1 + capacity) % capacity;

        deque[front] = value;

        size++;

        // First element
        if (size == 1) {
            rear = front;
        }

        return true;
    }

    // Add element at rear
    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        }

        // Move rear forward circularly
        rear = (rear + 1) % capacity;

        deque[rear] = value;

        size++;

        // First element
        if (size == 1) {
            front = rear;
        }

        return true;
    }

    // Delete element from front
    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;

        size--;

        return true;
    }

    // Delete element from rear
    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }

        rear = (rear - 1 + capacity) % capacity;

        size--;

        return true;
    }

    // Get front element
    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return deque[front];
    }

    // Get rear element
    public int getRear() {

        if (isEmpty()) {
            return -1;
        }

        return deque[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}