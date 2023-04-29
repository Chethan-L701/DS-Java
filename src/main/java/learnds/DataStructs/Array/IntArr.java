package learnds.DataStructs.Array;

import java.util.Scanner;

/**
 * @author Chethan L
 * @Date : 02/12/202
 * @github : <a href =
 *         https://github.com/Chethan-L-Gouda/Data-Structure-Java><u>Chethan
 *         L</u></a>
 *
 *         <p>
 *         <h2>About DataStructs.Array.IntArr:</h2>
 *         <b>
 *         <i>DataStructs.Array.IntArr</i> is a class that can used to create
 *         array of integers.<br>
 *         They are implemented by using <i>one-dimensional array.</i><br>
 *         This class contains all the functions for basic operation on
 *         <i>Integer Array,</i><br>
 *         Such as : inserting,searching,sorting,deleting,displaying.
 *         </b>
 *         </p>
 */
public class IntArr {
    private int[] arr;
    private final int maxNumElem;
    private boolean isMaxNumElemSet = false;
    private boolean isAccNumElem = false;
    private int accNumElem;
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor of the IntArr Class ,it initializes the maximum size of the array
     * 
     * @param maxSize it is the maximum size of the array.
     */
    public IntArr(int maxSize) {
        this.arr = new int[maxSize];
        this.maxNumElem = maxSize;
        this.isMaxNumElemSet = true;
    }

    /**
     * Function to set the number of elements that are getting stored in the
     * array.
     * 
     * @param nElem number of elements.
     */
    public void setNumElem(int nElem) {
        if (nElem <= maxNumElem) {
            this.accNumElem = nElem;
            this.isAccNumElem = true;
        }
    }

    /**
     * Function to get the elements from the user through keyboard.
     * <br>
     * It will get the elements up to the given size.
     */
    public void getElem() {
        if (isAccNumElem) {
            for (int i = 0; i < accNumElem; i++)
                this.arr[i] = sc.nextInt();
        }
    }

    /**
     * Displays the elements in the arrays.
     */
    public void displayElem() {
        System.out.println();
        if (isAccNumElem)
            for (int i = 0; i < accNumElem; i++)
                System.out.print(arr[i] + "\t");
        System.out.println();
    }

    /**
     * Deletes the element in the given position.
     * 
     * @param elePos the position of element to be deleted.
     */
    public void delEleAt(int elePos) {
        if ((elePos <= accNumElem) && (elePos >= 0)) {
            for (int i = elePos; i < accNumElem; i++)
                this.arr[i] = this.arr[i + 1];
            this.accNumElem--;
        }
    }

    /**
     * it appends the element at the last position of the arr.
     * 
     * @param ele the element to be appended.
     */
    public void appendElem(int ele) {
        if (accNumElem < maxNumElem) {
            this.arr[accNumElem] = ele;
            this.accNumElem++;
        }
    }

    /**
     * To insert an element at a certain position of the array.
     * 
     * @param ele    the element to be inserted.
     * @param insPos the position in which the element should be inserted.
     */
    public void insertElem(int ele, int insPos) {
        for (int i = accNumElem; i > insPos; i--)
            arr[i] = arr[i - 1];
        arr[insPos] = ele;
        this.accNumElem++;
    }

    /**
     * To find an element in the array by using linear search method .
     * 
     * @param searchKey the element to search for.
     * @return the position of the element.
     */
    public int findEleLin(int searchKey) {
        int eleFoundAt = -1;
        for (int i = 0; i < accNumElem; i++)
            if (arr[i] == searchKey)
                eleFoundAt = i;
        return eleFoundAt;
    }

    /**
     * To find an element in the array by using binary search method .
     * 
     * @param searchKey the element to search for.
     * @return the position of the element.
     */
    public int findEleBin(int searchKey) {
        this.sortElemSel();
        int eleFoundAt = -1;
        int upBound = accNumElem;
        int lowBound = 0;
        int curs;
        while (lowBound <= upBound) {
            curs = (upBound + lowBound) / 2;
            if (arr[curs] == searchKey) {
                eleFoundAt = curs;
                break;
            } else if (arr[curs] > searchKey)
                upBound = curs - 1;
            else if (arr[curs] < searchKey)
                lowBound = curs + 1;
        }
        return eleFoundAt;
    }

    /**
     * To sort the array using Bubble sort method.
     */
    public void sortElemBbl() {
        int temp;
        for (int i = accNumElem - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
    }

    /**
     * To sort the array using Selection sort method.
     */
    public void sortElemSel() {
        int temp;
        for (int i = 0; i < accNumElem; i++)
            for (int j = i; j < accNumElem; j++)
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
    }
}
