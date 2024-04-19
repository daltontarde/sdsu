/*
 * Driver will instantiate the Singly Linked List
 * with several functional tests that demonstrate the
 * data structure and its correctness.
 * Timed: addFirst, addLast, removeFirst, removeLast
 *
 * Program 2: Linked List
 * Dalton Tarde
 * CS-310 Section 1
 * October 30, 2020
 */

package edu.sdsu.cs.datastructures;

import java.util.Scanner;

public class Driver extends SinglyLinkedList {

    public static void main(String[] args) {
        System.out.println("Which test case would you like to instantiate?");
        System.out.println("    1:  [TIMED] add() - Append datum to the end of the list");
        System.out.println("    2:  add(other list) - Append every datum, in order, in the other list to the rear of this list");
        System.out.println("    3:  [TIMED] addFirst() - Append datum to the front of the list");
        System.out.println("    4:  clear() - Resets the list to an empty state");
        System.out.println("    5:  count(target) - Return number of instances of target");
        System.out.println("    6:  get(index) - Return element stored at specified list index");
        System.out.println("    7:  isEmpty() - Returns true if there is nothing in the list");
        System.out.println("    8:  remove(index) - Removes the item stored at the specified index of the list");
        System.out.println("    9:  reverse() - Reverses the list's direction, changing the list");
        System.out.println("   10:  set(index, value) - Mutates value stored at given index, then returns the previous value");
        System.out.println("   11:  size() - Returns number of items stored in the data structure");
        System.out.println("   12:  sort() - Places the list in its natural order, changing the list, using type Comparable");
        System.out.println("   13:  Run rubric timed cases (addFirst, addLast, removeFirst, and removeLast): ");

        System.out.println("Please enter a number corresponding to the test case you want to run: ");
        Scanner scan = new Scanner(System.in);
        int driverChoice = scan.nextInt();
        switch (driverChoice) {
            case 1 -> addLast(); // add() in SinglyLinkedList.java
            case 2 -> addSecondList();
            case 3 -> addFirst(); //
            case 4 -> clearDriver(); //
            case 5 -> countDriver();
            case 6 -> getDriver();
            case 7 -> isEmptyDriver();
            case 8 -> removeLast();
            case 9 -> removeFirst();
            case 10 -> reverseDriver();
            case 11 -> setDriver();
            case 12 -> sizeDriver();
            case 13 -> sortDriver();
            case 14 -> rubricDriver();
            default -> {
                System.out.println("Invalid response!");
            }
        }
    }

    public static void addLast() {
        System.out.print("Empirical Time of add() (datum append to end of the list): ");
        System.out.println();
        long startTime;
        long stopTime;
        startTime = System.nanoTime();

        stopTime = System.nanoTime(); // end timing
        System.out.println(stopTime - startTime);
    }

    public static void addFirst() {
        System.out.print("Empirical Time of addFirst() (datum append to beginning of the list): ");
        System.out.println();
        long startTime;
        long stopTime;
        startTime = System.nanoTime();

        stopTime = System.nanoTime(); // end timing
        System.out.println(stopTime - startTime);
    }

    public static void removeLast() {
        System.out.print("Empirical Time of removeLast() (datum removed from end of the list):");
        System.out.println();
        long startTime;
        long stopTime;
        startTime = System.nanoTime();

        stopTime = System.nanoTime(); // end timing
        System.out.println(stopTime - startTime);
    }

    public static void removeFirst() {
        System.out.print("Empirical Time of removeFirst() (datum removed from start of the list): ");
        System.out.println();
        long startTime;
        long stopTime;
        startTime = System.nanoTime();

        stopTime = System.nanoTime(); // end timing
        System.out.println(stopTime - startTime);
    }

    public static void addSecondList() {
        System.out.print("Not implemented");
    }

    public static void clearDriver() {
        //
        System.out.print("Data structure has been cleared!");
    }

    public static void countDriver() {
        Scanner countInput = new Scanner(System.in);
        System.out.print("What value would you like to count?: ");
        int val = countInput.nextInt();
    }

    public static void reverseDriver() {

    }

    public static void getDriver() {

    }

    public static void isEmptyDriver() {

    }

    public static void setDriver() {

    }

    public static void sizeDriver() {

    }

    public static void sortDriver() {

    }

    public static void rubricDriver() {
        addFirst();
        addLast();
        removeFirst();
        removeLast();
    }
}
