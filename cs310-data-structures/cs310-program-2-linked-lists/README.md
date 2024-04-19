# [CS-310] Program 2: Linked Lists

## Documentation

`Driver.java` instantiates an adaptation of a Singly [LinkedList](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html) from `SinglyLinkedList.java` (created without looking at the original Java documentation) which is then used by `Driver.java` and `List.java` to show similiar functionality to the original class (**Class LinkedList<E>**).

## Assignment Guidelines

Pointers remain one of the most essential concepts in Computer Science. Most meaningful programs use them in some form. For example, data structures like binary search trees, graphs, and hash tables (with chaining) use them to link data. Consequently, to reinforce your understanding of the topic, this assignment requires you to implement a singly-linked-list from an interface. Additionally, students must build a Driver program with several tests that demonstrate the data structure's correctness.
  
After completing this assignment, students will:

+ Understand the process of dereferencing in their chosen language.
+ Know how to design simple tests to verify an algorithm or method's correctness.
+ Use an interface (or virtual class) to implement a data structure in the object-oriented style.
+ Demonstrate empirical timing with a sequential access data structure.
  
## Requirements
  
Using either Java (1.8+) or C++11, students shall create a generic/template implementation of a singly-linked-list. The required methods and their signatures appear below. Students shall include these methods in either a pure virtual class or interface file. This represents the abstract contract requirements every List must accomplish. As an interface, applications cannot instantiate instances of the List class.

The Singly-Linked-List implementation provided by each student shall implement the methods defined in the List interface. It shall not include any additional public methods or fields. The list should use private, helper methods to accomplish repetitive tasks (or when it helps clean up the code). As the Java design heuristic goes, 'Program to an interface, not an implementation.'

Students may implement the Singly-Linked-List in a variety of ways, but all solutions should be either circular or they should include both a head and tail pointer in the implementation, for we want to be able to quickly add to the list's end. Students may use a 'header' node if they so choose.

The linked list implementation shall support negative list indices. Positive indices specify the list position with 0 as the front, negative indices reflect counting from the rear. Thus, calling get(-1) returns the last item in the list while get(-2) returns the penultimate item. When provided with a list index outside the bounds of the list's size (either positive or negative), the method shall produce an error.

Using the Singly-Linked-List created for this assignment, students shall create a Driver program. The driver program shall declare variables to test of type List, and it shall use polymorphism to fill these pointers in with a Singly-Linked-List. 

For example:
``` List<Pokemon> deck = new SinglyLinkedList<>(); ```
  
The driver program shall perform several functional tests on the data structure to validate its performance. Additionally, the driver shall time (as in the first assignment) the addFirst, addLast, removeFirst, and removeLast methods while providing feedback to the user about the time it took and its observed growth factor.

## Required List methods

+ bool add(E datum): Appends the datum to the END of the list.
+ bool add(List<E> other): Appends every datum, in order, in the other list to the rear of this list.
+ bool addFirst(E datum): Appends the datum to the FRONT of the list.
+ bool addLast(E datum): Appends the datum to the END of the list.
+ void clear(): Resets the list to an empty state. It does not need to override the existing list contents.
+ int count(E target): Returns the number of instances equal to the target value contained in the data structure. Valid return values: 0 -> size()
+ E get(int index): returns the element stored at the specified list index (0=front, -1=rear)
+ bool isEmpty(): returns true only if there is nothing in the list.
+ E remove(int index): removes the item stored at the specified index from the list. (0=front, -1=rear).
+ void reverse(): Reverses the list's direction. This changes the list.
+ E set(int index, E value): mutates the value stored at the specified list index. This function returns the previous value stored at that position.
+ int size(): returns the current number of items stored in the data structure.
+ void sort(): Places the list in its natural order. Java may cast to type Comparable. This changes the list.

## Required Linked List Constructors
  
`default`: A no parameter constructor that instantiates an empty list of the specified type.
copy: A constructor that accepts a List as its only parameter and initializes a new list with identical contents (but different links/pointers. Same data, different address).

## Required Driver Tests:
+ Timing tests noted above.
+ Does add(List) produce correct results? That is, is other at the end? Is the size correct?
+ Prove the remove method works with negative indices. 
+ Use two different methods to prove that clear() works correctly. 
+ Show that the sort method performs correctly.
+ Show that the set method works correctly (use the count() method to do so).
+ Reverse an empty list.
  
## Required Files:
  
`List.cpp` or `List.java`: The interface file.
`SinglyLinkedList.cpp` or `SinglyLinkedList.java`: The concrete class that implements the List interface.
`Driver.cpp` or `Driver.java`: The main program (it may be in the default namespace/package).

## Other Notes:
  
Java students shall place the singly linked list implementation, as well as the List interface file, in the package: edu.sdsu.cs.datastructures
C++ students shall use the namespace: sdsu

Both the interface and implementation must support generic types for the data field.

When sorting, students may use any method so long as they perform the sort themselves. Selection and Insertion sort are absolutely acceptable methods in this assignment. Students should avoid bubble sort, for it produces deplorable timing without any redeeming merits.

Java Students should NOT extend the AbstractSequentialList. Although the class in the JCF provides much of the code required to build a working linked list, it introduces complexity we simply do not require.

Java students shall not use == when testing for equality for the count method. Instead, students shall use the compareTo() method. Students may cast the objects to Comparable to perform this operation.
