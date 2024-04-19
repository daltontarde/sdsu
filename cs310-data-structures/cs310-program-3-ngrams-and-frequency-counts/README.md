# [CS-310] Program 3: N-Grams and Frequency Counts

## Documentation

<TBD>

## Assignment Guidelines

Frequency counts serve an important role when analyzing a language. Tools like autocomplete use them when calculating the list of words to recommend. In this assignment, students shall build a program that analyzes an input text file. The program will compute the number of times each word (token) appears in the document.  Additionally, the program will also construct n-grams from the input text. Specifically, it will build a random phrase constructed from n-grams in the text. 

After completing this exercise, students will:

 - Gain foundational experience using a Map/Dictionary in a practical application.
 - Understand the role the Map serves in Computer Science and how it can sometimes simplify an algorithm. 
 - Use command-line arguments in a program to change program behavior at launch. 
 - Read and process data from an arbitrary location on the file system. 
 - Build a basic Object Oriented program 

## Requirements

At program launch, the user shall provide a command line argument indicating the location of the input file to use. If the program fails to find the file, or cannot open it for some reason, the program shall exit with an error message explaining the nature of the problem. If the user fails to provide a command line argument, the program shall terminate with a message describing the correct use of the program. 

Next, the program shall extract the word tokens from the input file. To simplify further analysis, the program shall automatically convert each of these tokens to their lower case equivalent (using built-in functions) and trim off any white space. During this processing, the program may safely ignore new line characters and blank lines. That is, it shall not count a tab or carriage return as a word token. 

Using the list of pre-processed tokens extracted from the text file, the program shall then build a frequency count object. This custom class shall perform the calculations and store the data associated with the input list used when constructing it. 

The Driver program shall then display information about the input text by calling the FrequencyCount object's head and tail methods. These methods return a list of strings representing the most (head) and least (tail) frequent tokens in the object. The Driver program shall use these strings to display information about the most and least frequent tokens in the input file. Additionally, the driver program shall include information about the percentage for each of these most and least frequent tokens. 

After demonstrating correct performance with single words, the program shall construct a frequency count object from the input file using a degree of 4. Thus, the map will contain tokens consisting of four consecutive words (ignore line breaks). Thus, given the following text:

All those moments will be lost in time, like tears in rain. Time to die.

The program extracts the following 4-grams:

"All those moments will" -> 1
"those moments will be" -> 1
"moments will be lost" -> 1
"will be lost in" -> 1
"be lost in time," -> 1
...
"rain. Time to die." -> 1
  
Using this object, the driver program shall use the random token method on the FrequencyCount object to construct a random phrase/poem. To do so, it shall first print one 4-gram on a line, followed by a line with two 4-grams, and concluded with a single 4-gram.  

## FrequencyCount Class

The FrequencyCount class shall use a private Map (e.g., HashMap, TreeMap, etc . . .) containing the tokens as keys and the number of times that token appears in the text as its value. 

When constructing a FrequencyCount object, the user may choose from one of two constructors:

FrequencyCount(List<String> text): The single parameter constructor uses the list parameter as the source text and calculates the frequencies of words contained in it. The class does not preserve the input list, nor does it modify it. 

FrequencyCount(List<String> text, int degree): Constructs a frequency count object from the input text, but rather than always counting words, this constructor builds its map using multiple words in the input list as the keys in its map. This constructor allows the caller to construct a frequency count of bigrams, 3-grams, and 4-grams in the text. Using this constructor with degree=1 behaves exactly as the single parameter constructor FrequencyCount(List). 

List<String> head(): Returns an ordered list (e.g., std::vector, ArrayList, LinkedList, Array) of the top-20, most frequent tokens appearing in the input text file. The item at index 0 shall be the most frequent. In the case of ties with more than 20 items, the program shall simply stop including additional items with the identical count after it fills the return List with 20 items. 

List<String> tail(): Returns an ordered list (e.g., std::vector, ArrayList, LinkedList, Array) of the top-20, least frequent tokens appearing in the input text file. The item at index 0 shall be the most frequent of the least frequent, and the item at index 19 shall be the absolute least frequent item in the original text. In the case of ties with more than 20 items, the program shall simply stop including additional items with the identical count after it fills the return List with 20 items. 

String randomToken(): returns a random token from the keys inside. 

int count(String token): returns the current frequency count for the input token string. Zero if not present. 

int percent(String token): calculates and returns the percentage of the original input text of the token's appearance. A file filled entirely with the word 'the' shall return 1 when asked for the percent of file consists of "the." 

int add(String token): inserts the token parameter into the frequency count map and updates the count for the indicated token by one. If the token does not appear in the map, it shall use a count of one, if it is already present, it shall increment the count for the specified token by 1. This method allows callers to insert items into the FrequencyCount object after its construction. 

## Other Notes

This program only works with ASCII coded files. Frequently, these types of files automatically end in the .txt extension, but this is not a requirement to be an ASCII file. HTML files are also ASCII coded text files. Unfortunately, the colloquial use of "text file" erroneously includes .doc, .docx, .pages, and any other file type created by a word processor. These files are in no way ASCII coded text files. Just because the document contains text does not make it a text file. This program will not work with binary coded files created by word processing applications. It will, however, work with almost all source code files (i.e., .java, .c++, .py, etc . . .). 
