class StackArray {
    private int maxSize;
    private int[] stack;
    private int top;

    public StackArray(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow!");
        } else {
            stack[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
class StackLinkedList {
    private class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
class QueueArray {
    private int[] queue;
    private int front, rear, size, capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue Overflow!");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
class QueueLinkedList {
    private class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node front, rear;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int value = front.data;
        front = front.next;
        if (front == null) rear = null;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
public class Main {
    public static void main(String[] args) {
        // Testing Stack
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        System.out.println("Stack Peek: " + stack.peek());
        System.out.println("Popped: " + stack.pop());

        // Testing Queue
        QueueArray queue = new QueueArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println("Queue Peek: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}
