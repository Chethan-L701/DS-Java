package learnds.DataStructs.Stack;

/**
 * @author Chethan L
 * @Date 02/12/2022
 * @github <a href =
 *         https://github.com/Chethan-L701/DS-Java.git>
 *         <u>Chethan-L</u></a>
 *
 *         <p>
 *         <h2>About DataStructs.Stack.StackArrImpl:</h2>
 *         <b>
 *         <i>DataStructs.Stack.StackArrImpl</i> is a class that can used to
 *         create Stacks.<br>
 *         The stacks are implemented by using <i>one-dimensional array.</i><br>
 *         This class contains all the functions for basic operation on
 *         <i>Stacks</i><br>
 *         </b>
 *         </p>
 */
public class StackArrImpl {
    private int[] items;
    private int top;
    private final int maxSize;

    /**
     * Constructor for Stack Class.<br>
     * It initialises the top and the size of the stack.
     * 
     * @param maxSize the maximum size of the array.
     */
    StackArrImpl(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.items = new int[maxSize];
    }

    /**
     * <p>
     * <b>Checks whether the stack is empty.</b>
     * <p/>
     */
    public boolean isEmpty() {
        return top < 0;
    }

    /**
     * <B>Checks whether the stack is full</B>
     */
    public boolean isFull() {
        return top >= maxSize;
    }

    /**
     * <b>To push an item to the top of the stack.<br>
     * </b>
     * 
     * @param item the item to be pushed.
     */
    public void push(int item) {
        if (!isFull()) {
            this.top++;
            this.items[top] = item;
        } else
            System.out.println("Stack Overflow :: stack is full.");
    }

    /** Removes the topmost item of the stack and returns its value */
    public int pop() {
        if (isEmpty())
            System.out.println("Stack underflow :: Stack is Empty.");
        else {
            int rm_item;
            rm_item = this.items[top];
            this.items[top] = 0;
            this.top--;
            return rm_item;
        }
        return 0;
    }

    /**
     * Returns the value of the topmost element without <br>
     * removing it from the Stack.
     */
    public int peek() {
        return this.items[top];
    }

    /**
     * Displays all the elements of the stack.
     */
    public void display() {
        if (!isEmpty()) {
            System.out.println();
            for (int i = top; i >= 0; i--)
                System.out.print(this.items[i] + "\t");
            System.out.println();
        } else
            System.out.println("The stack is empty.");
    }

    /**
     * Pushes all the elements of the arrays into the stack.
     * 
     * @param itemlist list of the items to be inserted.
     */
    public void pushBatch(int[] itemlist) {
        for (int j : itemlist)
            push(j);
    }

    /**
     * Remove up to n number of elements from the stack,<br>
     * returns the removed elements in the form of an array.
     * 
     * @param num number of items to be popped/removed.
     */
    public int[] popBatch(int num) {
        int[] rm_items = new int[num];
        for (int i = 0; i < num; i++)
            rm_items[i] = pop();
        return rm_items;
    }
}
