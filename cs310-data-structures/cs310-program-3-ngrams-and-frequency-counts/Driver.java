/*
 * Driver class takes care of File I/O
 * and navigating through FrequencyCount.java
 *
 * Program 3: N-Grams and Frequency Counts
 * Dalton Tarde
 * CS-310 Section 1
 * November 20, 2020
 */
package edu.sdsu.cs.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class Driver {
    private static Scanner input;

    /**
     * Takes in user input in order to determine the N-gram
     * the user would like to use on the inputted data set.
     *
     * @param wordList - user input
     */
    public static void startMenu(List<String> wordList) {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("Commands:");
        System.out.println("    1) Calculate word frequency from list: FrequencyCount()");
        System.out.println("    2) Calculate word frequency with degree input ([1-4]grams)");

        System.out.print("INPUT HERE: ");
        int userResponse = scan.nextInt();

        switch (userResponse) {
            case 1 -> defaultFrequency(wordList);
            case 2 -> inputFrequency(wordList);
            default -> {
                System.out.println("Invalid response!");
                startMenu(wordList);
            }
        }
    }

    /**
     * N-gram case for defaultFrequency, a 1-gram.
     * Initializes the FrequencyCount class.
     *
     * @param wordList - user input
     */
    public static void defaultFrequency(List<String> wordList) {
        new FrequencyCount(wordList);
        frequencyData();
    }

    /**
     * N-gram case for N-gram frequencies: [1, bigram, 3-gram, 4-gram].
     * Initializes the FrequencyCount class.
     *
     * @param wordList - user input
     */
    public static void inputFrequency(List<String> wordList) {
        Scanner gramResponse = new Scanner(System.in);
        System.out.print("What frequency count would you like? [1, bigram, 3-gram, 4-gram]: ");
        int degree = gramResponse.nextInt();

        if (degree < 1 || degree > 4) { // out of bounds check
            System.out.println("Frequency count not possible! Please put in a correct frequency count.");
            inputFrequency(wordList);
        }
        new FrequencyCount(wordList, degree);
        frequencyData();
    }

    /**
     * Allows user input after FrequencyCount is initialized,
     * able to check most/least frequent tokens, obtain random ones,
     * check data as integers or percents, and add to the existing dataset.
     *
     */
    public static void frequencyData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to know about your dataset?:");
        System.out.println("Commands:");
        System.out.println("    1) RUN RUBRIC REQUIREMENTS");
        System.out.println("    2) Return the top-20 most frequent tokens.");
        System.out.println("    3) Return the top-20 least frequent tokens.");
        System.out.println("    4) Return a random token from the keys.");
        System.out.println("    5) Return the current frequency count for the input token string. (Zero if not present)");
        System.out.println("    6) Return the percentage of the original input text of the token's appearance.");
        System.out.println("    7) Insert a new item into the FrequencyCount object.");
        System.out.println("    8) Exit program");
        System.out.print("INPUT HERE: ");
        int userResponse = scan.nextInt();

        switch (userResponse) {
            case 1 -> {
                System.out.println("Top 20 most frequent tokens are:");
                System.out.println(FrequencyCount.head());
                System.out.println();
                System.out.println("Top 20 least frequent tokens are:");
                System.out.println(FrequencyCount.tail());
                System.out.println();
            }
            case 2 -> {
                System.out.println("Top 20 most frequent tokens are:");
                System.out.println(FrequencyCount.head());
                System.out.println();
                frequencyData();
            }
            case 3 -> {
                System.out.println("Top 20 least frequent tokens are:");
                System.out.println(FrequencyCount.tail());
                System.out.println();
                frequencyData();
            }
            case 4 -> {
                System.out.println("Random token from the dataset is:");
                System.out.println(FrequencyCount.randomToken());
                System.out.println();
                frequencyData();
            }
            case 5 -> {
                Scanner countInput = new Scanner(System.in);
                System.out.println("What token would you like to obtain the frequency of?: ");
                String countValue = countInput.next();
                System.out.println("Token " + countValue + " has a frequency of: ");
                System.out.println(FrequencyCount.count(countValue));
                frequencyData();
            }
            case 6 -> {
                Scanner percentageInput = new Scanner(System.in);
                System.out.println("What token would you like to obtain the percentage of?: ");
                String percentValue = percentageInput.next();
                System.out.println("Token " + percentValue + " has a percentage of: ");
                System.out.println(FrequencyCount.percent(percentValue));
                frequencyData();
            }
            case 7 -> {
                Scanner addInput = new Scanner(System.in);
                System.out.println("What would you like add as a token?: ");
                String addValue = addInput.next();
                System.out.println("Token " + addValue + " has been added to the original dataset!");
                FrequencyCount.add(addValue);
                frequencyData();
            }
            case 8 -> {
                System.out.println("EXITING PROGRAM, THANK YOU!");
                System.exit(1);
            }
            default -> {
                System.out.println("Invalid response!");
                frequencyData();
            }
        }
    }

    public static void main(String[] args) { // Checks file before moving onto rest of the program
        if (args.length == 0) { // exit condition
            System.out.println("There was no file passed through the command line!");
            System.exit(1);
        }

        try { // take in file
            File text = new File(args[0]);
            input = new Scanner(text);
        } catch (IOException ioException) {
            System.err.println("Cannot open file.");
            System.exit(1);
        }

        String word;
        StringBuffer sb = new StringBuffer();
        while (input.hasNext()) {
            word = input.next();
            sb.append(word);
        }

        String concat = sb.toString();
        List wordList = new ArrayList();
        wordList = Arrays.asList(concat.split(" "));

        startMenu(wordList);
    }


}
