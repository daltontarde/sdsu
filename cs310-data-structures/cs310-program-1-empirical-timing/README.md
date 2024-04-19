# [CS-310] Program 1: Empirical Timing

## Documentation

`ArrayDriver.java` uses Java's [System.nanoTime()](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#nanoTime())
function in order to test the performance of a generic SortedArrayList. These test cases allow for a better understanding of how time complexity can change in relation to  various functions.

## Assignment Guidelines

In this assignment, students shall implement a sorted array class and the driver to time its performance for a few, key tasks. At the conclusion of this program, students shall:

- Understand the difference between linear and quadratic timings and some of the behaviors that cause this performance to emerge. This should reveal why these basic structures generally perform poorly in a queue application.
- Perform empirical timing to establish the complexity class of operations.
- Implement a generic/template class in either Java or C++11.
- Build a data structure that implements an Abstract Data Type's performance requirements.
- Write formatted output to the terminal screen.

## Part 1: Generic SortedArrayList

At this point, you should already understand the basics of array use and how to instantiate one. Both Java and C++ include this derived type in the base language, so you do not need to include any additional files to use basic, square-bracket arrays. In this assignment, students will wrap additional functionality around this primitive structure such that it behaves differently. Not only will the data structure the students create support additional methods (e.g., size), but it will always keep its contents in their natural order. Thus, when someone adds the numbers 4, 7, and 1 to an empty SortedArrayList, it actually stores them as: 1, 4, 7. The smallest thing in the list is located at index position 0. The largest thing is at index position size()-1.

Students shall make the data structure generic through the use of a Generic class or template. Thus, the data structure code will support instantiating a sorted array list of Characters, Integers, or Pokemon. Each language differs on how one accomplishes this. Because the array is constantly sorted, however, Java students will need to code the generic class with particular attention to detail, for they must make the contents of the structure Comparable. This frequently emerges as a source of confusion among programming students at this level.

The Comparable type guarantees that objects that implement the interface provide the compareTo() method. This method returns either a negative number, a positive number, or zero. The value it returns reflects the relation between the two objects. None of your solutions should actually implement a compareTo method. Instead, the Java solutions should use the method already on the objects it intends to store inside.

Students using C++ may assume that everything stored in the container includes a < override. This is the only logical operator students may use when sorting their arrays. Thus, objects in the container must all override < or the template fails. None of the solutions shall override the less than operator themselves -- the objects inside the container do so, and we are not implementing those.

In addition to maintaining sorted order at all times, this SortedArrayList automatically expands its capacity (not size) when it fills up. It also shrinks after it detects that it is mostly empty. When the driver attempts to add an item to the structure when its size is at capacity, rather than failing because there is insufficient room, the structure shall increase its capacity. To do so, it must allocate a new backing-array with the expanded capacity and then copy the contents of the old array into the new memory area. Students may use memcopy or System.arraycopy for this operation, or they may do so using a simple for loop.

The new, expanded size should be some multiple of the original capacity. Students may choose to simply double the old capacity in their individual solutions, or they may choose to simply add the original capacity (provided as a constructor parameter) to the current capacity. Both approaches possess benefits and weaknesses, and it remains up to the implementer to define the strategy. Include a note describing how it expands in the comments for the class.

Since we do not wish to waste memory with a mostly empty data structure with a massive capacity, the data structure shall shrink after a remove operation if it detects it is mostly empty. This requires another array reallocation as well as a content copy (memcopy or System.arraycopy). The reduced size shall never go below the initial capacity, and it shall always remain a multiple of the original capacity.

File: SortedArrayList.java or SortedArrayList.cpp

## Required Public Methods

Constructors: The class must include a default constructor (zero arguments) and a constructor that accepts a single argument representing the initial capacity of the internal array.

Destructors: C++ students must create a destructor that frees any allocated heap memory. Java students may safely ignore this requirement.

boolean add(E item)
Inserts the item into the array. The sorted array increases the size of the structure by one and places the new item in its correct position. This may cause a shift in the array's existing contents as the data structure moves everything over to make room for the new item.

int capacity()
Returns the maximum possible number of items the data structure may store (the size of the fuel tank) at the backing-array's current size.

void clear()
Resets the data structure's size to zero.

E get(int index)
Returns, but does not remove, the value of the item stored at position index within the array.

boolean isEmpty()
Returns true if size() == 0 and false under all other conditions.

E remove(int index)
Returns the value of the item stored at position index in the array (assuming it is within bounds) and deletes the item from the array. This may cause the array contents to shift over to fill the hole left by the vacated item.

int size()
This method returns the number of items stored inside the data structure (how much fuel is in the tank).

## Part 2: Complexity and Empirical Timing

Students must create a console-based program that sends text to the terminal screen. This program shall use the SortedArray and perform a number of tests against it. These tests will verify the data structure's accurate performance and allow students to establish the complexity class for several of its major operations. The driver must time and test the methods add, remove, and clear.

Your instructor highly encourages students to create a suite of test functions that the main method simply calls to coordinate the test.

The general approach to an empirical timing test is:

- Establish an initial test size.
- Record the current time as startTime
- Perform the operation under test up to the test size
- Record the current time as endTime
- Store/Display the elapsed time (end-start)
- Double the current test size
- Repeat these steps 2-6 five times

Testing Add (in order):
Students shall create an array of some, initial capacity (size will vary based upon the students' individual computers), and they shall then insert data of increasing size into the structure. This test method shall insert numbers into the data structure in increasing order. That is, the data will already enter in their natural-sorted order. For example: 0, 1, 2, 3, 4, ....., testsize-1

A correctly coded SortedArrayList will perform this operation in linear time.

Testing Add (reverse order):
As above, but the data shall arrive in reverse sorted order: testsize-1, ...., 4, 3, 2, 1, 0

A correctly coded SortedArrayList will perform this operation in quadratic time.

Testing Remove:
The order of the data for remove is irrelevant, so students may build the test structure using either in-order or random data. After building an array up to the current test size, the driver shall time how long it takes to remove everything until isEmpty() returns true.

A correctly coded SortedArrayList will perform this operation in quadratic time.

Testing Clear:
The order of the data for clear is irrelevant, so students may built the test structure with data up to the test size. This tends to be a reoccurring theme, so students should consider creating a helper function that takes the SortedArrayList and a target size as a parameter and fills it with data up to the requested size.

A correctly coded SortedArrayList will perform this operation in constant time.

Screen Output:
Using formatted text, students shall report the results of each phase of each test. Thus, we should see the current test size and time for each timing test. Additionally, starting with the second test size, the program shall report the factor by which the time increased. Thus, the program shall take the current test result and divide it by the previous test result to reveal the multiplicative factor by which the time is increasing (or staying the same). This will reveal if the data structure is hitting its complexity goals.

File: ArrayDriver.java or ArrayDriver.cpp

Required function/method: main

## Other Notes

Students may not use the Array or ArrayList class included in the Java Collections or C++ Standard Library. Additionally, students may not use sorting algorithms included on these objects. That is, students must manually sort the array for full credit.

Students may create any number of private methods or functions to clean the code. Using several small functions to perform a major operation remains good coding practice.

Java students should extend the AbstractList included in the Java Collections Framework for the SortedArrayList. This abstract class includes a lot of source code for additional methods to greatly simplify development time. Specifically, it includes an iterator which cleans the driver code (for part 2) quite nicely.

All functions and methods must include a comment defining their behavior and expected return values.

Source code must adhere to proper naming conventions, and it must use a consistent naming (case) strategy. Properly named variables and descriptive functions simplify the grading process and generally leads to a higher grade.
