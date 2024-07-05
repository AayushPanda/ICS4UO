package DSA3;

import java.util.Arrays;

public class GenericStack<T> {

    private Node<T> top;

    // Main method for testing the GenericStack class
    public static void main(String[] args) {
        // Create a GenericStack of Objects
        GenericStack<Object> stack = new GenericStack<>();
        stack.push(1);
        stack.push("Two");
        stack.push(3.0);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // Create a GenericStack of Characters from a string
        GenericStack<Character> stringStack = GenericStack.toStack("not a palindrome");
        System.out.println(stringStack.isPalindrome());
        System.out.println(GenericStack.toStack("racecar").isPalindrome());
        System.out.println(GenericStack.isPalindrome("abba"));
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
    }

    // Constructor for an empty GenericStack
    public GenericStack() {
        this.top = null;
    }

    // Constructor for a GenericStack with an initial object
    public GenericStack(T object) {
        this.top = new Node<>(object, null);
    }

    // Convert an array of objects to a GenericStack
    public static <R> GenericStack<R> toStack(R[] objects) {
        GenericStack<R> stack = new GenericStack<>();
        Arrays.stream(objects).forEach(stack::push);
        return stack;
    }

    // Convert a string to a GenericStack of Characters
    public static GenericStack<Character> toStack(String string) {
        return GenericStack.toStack(string.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
    }

    // Check if the GenericStack is a palindrome
    public boolean isPalindrome() {
        GenericStack<T> reversedStack = this.reverse();
        return GenericStack.equals(this, reversedStack);
    }

    // Check if a string is a palindrome
    public static boolean isPalindrome(String string) {
        return GenericStack.toStack(string).isPalindrome();
    }

    // Push an object onto the GenericStack
    public void push(T object) {
        this.top = new Node<>(object, this.top);
    }

    // Pop an object from the GenericStack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T object = this.top.getObject();
        this.top = this.top.getNext();
        return object;
    }

    // Peek at the top object of the GenericStack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.top.getObject();
    }

    // Check if the GenericStack is empty
    public boolean isEmpty() {
        return this.top == null;
    }

    // Reverse the GenericStack and return a new instance
    private GenericStack<T> reverse() {
        GenericStack<T> reversedStack = new GenericStack<>();
        GenericStack<T> tempStack = new GenericStack<>();

        while (!this.isEmpty()) {
            T object = this.pop();
            tempStack.push(object);
            reversedStack.push(object);
        }

        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }

        return reversedStack;
    }

    // Equals method that compares two stacks of any type
    public static <R> boolean equals(GenericStack<R> stack1, GenericStack<R> stack2) {
        GenericStack<R> copy1 = stack1.copy();
        GenericStack<R> copy2 = stack2.copy();

        while (!copy1.isEmpty() && !copy2.isEmpty()) {
            if (!copy1.pop().equals(copy2.pop())) {
                return false;
            }
        }

        return copy1.isEmpty() && copy2.isEmpty();
    }

    // Create a copy of the GenericStack
    private GenericStack<T> copy() {
        GenericStack<T> copyStack = new GenericStack<>();
        GenericStack<T> tempStack = new GenericStack<>();

        while (!this.isEmpty()) {
            T object = this.pop();
            tempStack.push(object);
            copyStack.push(object);
        }

        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }

        return copyStack;
    }
}
