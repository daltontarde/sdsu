/*
 * Program 1 times the performance of a generic SortedArrayList
 * in order to understand the differences between various
 * complexity classes of operations.
 *
 * Program 1: Empirical Timing
 * Dalton Tarde
 * CS-310 Section 1
 * September 21, 2020
 */

import java.util.AbstractList;
import java.util.Scanner;

/**
 * Implementation of a sorted array class and
 * a driver to time ADT performance.
 *
 */
class SortedArrayList<E> extends AbstractList<E> {
    // Variables:
    int startCapacity;
    int currentCapacity;
    int currentSize = 0;
    E[] storage; // for any generic list

    public SortedArrayList() { // default constructor
    }

    /**
     * Single arg constructor representing initial capacity
     * for the internal array.
     *
     * @param initialCapacity
     */
    public SortedArrayList(int initialCapacity) {
        startCapacity = 0;
        currentCapacity = initialCapacity;
        storage = (E[]) new Object[initialCapacity];
        mainMenu();
    }

    /**
     * Interface for SortedArrayList Driver.
     *
     */
    public void mainMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("Commands (Empirical Timing):");
        System.out.println("    1) add()");
        System.out.println("    2) clear()");
        System.out.println("    3) remove()");
        System.out.println("Commands (Untimed):");
        System.out.println("    4) size()");
        System.out.println("    5) get()");
        System.out.println("    6) getCurrentCapacity()");
        System.out.println("    7) isEmpty()");

        System.out.print("INPUT HERE: ");
        int userResponse = input.nextInt();

        switch (userResponse) {
            case 1 -> addTimed();
            case 2 -> clearTimed();
            case 3 -> removeTimed();
            case 4 -> sizeHelper();
            case 5 -> getHelper();
            case 6 -> {
                System.out.println("Current capacity: " + getCurrentCapacity());
                mainMenu();
            }
            case 7 -> {
                System.out.println("Empty? (T/F): " + isEmpty());
                mainMenu();
            }
            default -> {
                System.out.println("Invalid response!");
                mainMenu();
            }
        }
    }

    /**
     * Item is added to the array - data already in the
     * array may be shifted.
     *
     * @param item
     * @return boolean
     */
    @Override
    public boolean add(E item) {
        if (startCapacity < currentCapacity) { // check for limits
            startCapacity++;
            currentSize++;
            this.storage[currentSize] = item;
            return true;
        }
        else {
            return false;
        }
    }
    public void addTimed() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Options:");
        System.out.println("    1) Add one element at a time");
        System.out.println("    2) Double the addition of elements");
        System.out.println("    3) Quadratic addition of elements");
        System.out.println("    4) Insert elements in reverse");
        System.out.println("    5) Go back");
        System.out.print("INPUT HERE: ");
        int optionChoice = scan.nextInt();

        if (optionChoice == 1) {
            // Empirical Time of "Add": Linear
            Integer linear = 0; // set to 0 for ++ iteration
            System.out.print("Empirical Time of add method (linear instance, n++): ");
            System.out.println();
            long startTime;
            long stopTime;
            startTime = System.nanoTime();
            for (int i = 0; i < currentCapacity - 1; i++) {
                System.out.print("Case " + i + ": ");
                startTime = System.nanoTime(); // start timing
                add((E) linear++); // generic
                stopTime = System.nanoTime(); // end timing
                System.out.println(stopTime - startTime);
                System.out.println("  Value stored in Case " + i + ": " + linear);
            }
        }
        else if (optionChoice == 2) {
            // Empirical Time of "Add": Exponential
            Integer exponential = 2; // set to 2 for multiplication
            System.out.print("Empirical Time of add method (exponential instance, n*2): ");
            System.out.println();
            long startTime;
            long stopTime;
            for (int i = 0; i < currentCapacity - 1; i++) {
                System.out.print("Case " + i + ": ");
                startTime = System.nanoTime(); // start timing
                add((E) exponential); // generic
                exponential = (exponential * 2);
                stopTime = System.nanoTime(); // end timing
                System.out.println(stopTime - startTime);
                System.out.println("  Value stored in Case " + i + ": " + exponential);
            }
        }
        else if (optionChoice == 3) {
            // Empirical Time of "Add": Quadratic
            Integer quadratic = 2; // set to 2 for squaring
            System.out.print("Empirical Time of add method (quadratic instance, n^2): ");
            System.out.println();
            long startTime;
            long stopTime;
            for (int i = 0; i < currentCapacity - 1; i++) {
                System.out.print("Case " + i + ": ");
                startTime = System.nanoTime(); // start timing
                add((E) quadratic); // generic
                quadratic = (quadratic * quadratic);
                stopTime = System.nanoTime(); // end timing
                System.out.println(stopTime - startTime);
                System.out.println("  Value stored in Case " + i + ": " + quadratic);
            }
        }
        else if (optionChoice == 4) {
            // Empirical Time of "Add": Reversed
            Integer linearReverse = 0; // set to 0 for ++ iteration
            System.out.print("Empirical Time of add method (reversed): ");
            System.out.println();
            long startTime;
            long stopTime;
            startTime = System.nanoTime();
            int count = 1;
            for (int i = currentCapacity - 1; i > 0; i--) {
                System.out.print("Case " + count + ": ");
                startTime = System.nanoTime(); // start timing
                add((E) linearReverse++); // generic
                stopTime = System.nanoTime(); // end timing
                System.out.println(stopTime - startTime);
                System.out.println("  Value stored in Case " + count + ": " + linearReverse);
                count++;
            }
        }
        else if (optionChoice == 5) {
            // fall through to main menu
        }
        mainMenu();
    }

    /**
     * Data structure size is reset to zero.
     *
     * @param
     * @return void
     */
    @Override
    public void clear() {
        for(int i = 0; i < currentCapacity; i++) {
            storage[i] = null;
        }
        currentSize = 0;
    }

    public void clearTimed() {
            // Empirical Time of "Clear"
            System.out.print("Empirical Time of clear method:");
            System.out.println();
            long startTime;
            long stopTime;
            startTime = System.nanoTime();
            for (int i = 0; i < currentCapacity - 1; i++) {
                startTime = System.nanoTime(); // start timing
                clear();
                stopTime = System.nanoTime(); // end timing
                System.out.print("Case " + i + ": ");
                System.out.print(stopTime - startTime);
                System.out.println();
            }
            mainMenu();
        }

    /**
     * Return value of item stored at given position for index,
     * and then delete item for array - hole may be filled.
     *
     * @param index
     * @return element at E storage[] indice
     */
    @Override
    public E remove (int index) {
        E toReturn = storage[index];

        if (currentCapacity < startCapacity) { // check for limits
            storage[currentSize] = null;
            currentSize--;
            return toReturn;
        }
        return toReturn; // returns *intended* removal
    }

    public void removeTimed() {
        // Empirical Time of "Remove"
        Scanner toRemove = new Scanner(System.in);
        System.out.print("What indice do you want to remove?: ");
        int removal = toRemove.nextInt();
        System.out.println();
        System.out.println("Empirical Time of remove method:");
        System.out.println("NOTE: Only one removal wil be timed.");
        System.out.println();

        if(removal > -1 && removal < currentCapacity){
            long startTime;
            long stopTime;
            startTime = System.nanoTime(); // start timing
            remove(removal);
            stopTime = System.nanoTime(); // end timing
            System.out.print("Case 1, removal of indice " + removal + ": ");
            System.out.print(stopTime - startTime);
            System.out.println();
        }
        else {
            System.out.println("This indice is out of bounds!");
        }
        mainMenu();
    }

    // Getters:
    public int getCurrentCapacity() { return currentCapacity; } // ceiling
    @Override
    public int size() { return currentSize; } // current value, renamed from getSize()
    public void sizeHelper() {
        int sizeToReturn = size();
        System.out.println("Size of storage is: " + sizeToReturn);
        mainMenu();
    }

    /**
     * Grabs value of item stored at position index within the
     * data structure.
     *
     * @param index
     * @return data in E storage[] at given index
     */
    @Override
    public E get(int index) { return storage[index]; }
    public void getHelper() {
        Scanner givenIndex = new Scanner(System.in);

        System.out.print("What index are you looking for?: ");
        int index = givenIndex.nextInt();

        if (index > -1 && index < currentCapacity) {
            E data = get(index);
            System.out.println("Data stored at index " + index + ": " + data);
            mainMenu();
        }
        else {
            System.out.println("This indice is out of bounds!");
        }
        mainMenu();
    }

    /**
     * Returns true if size == 0, else
     * data structure is populated.
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}

public class ArrayDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // User Input:
        System.out.println("Note: All Empirical Timings are calculated in nanoseconds using System.nanoTime() at the start/end of execution.");
        System.out.println();
        System.out.print("Please determine the size of the initial array: ");
        int initial = scan.nextInt();

        SortedArrayList instance = new SortedArrayList(initial); // call to driver
    }
}