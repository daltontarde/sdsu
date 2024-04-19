/*
 * Takes in file input of matrices of cities and the cost (in points) of
 * moving between cities. The matrices are put into the genetic algorithm
 * for the Traveling Salesperson up to a degree of twenty-five entries.
 *
 * Program 4: Genetic Algorithms
 * Dalton Tarde
 * CS-310 Section 1
 * December 9, 2020
 */

package edu.sdsu.cs.datastructures;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import static edu.sdsu.cs.datastructures.Genome.highestFitness;
import static java.lang.Integer.parseInt;

public class Driver {

    /**
     * Takes care of File I/O, then initializes
     * the Genome class with Genetic Algorithm
     * for the Traveling Salesman
     *
     * @return void
     */
    public static void main(String[] args) {
        LinkedList<String> matrices = new LinkedList<>();
        String elements;
        int iterator = 0;
        int nodes = 0;
        int[] cityNames = new int[30];
        int[][] prices = new int[30][30];

        if (args.length == 0) { // exit condition
            System.out.println("There was no file passed through the command line!");
            System.exit(1);
        }
        try { // take in file
            File file = new File(args[0]);
            Scanner scan = new Scanner(new FileInputStream(file));
            while (scan.hasNext()){
                elements = scan.next();
                matrices.add(elements);
                iterator++;
                if (iterator % 4 == 0) {
                    nodes++;
                }
            }
            File secondRead = new File(args[0]); // secondRead extrapolates city names and prices individually
            Scanner secondScan = new Scanner(new FileInputStream(file));
            String price;
            int arrayIterator = 1;
            int fileIterator = 1;
            for (int i = 0; i < 30; i++) {
                int startingVal = 0;
                cityNames[i] = startingVal + 4;
            }
            while (scan.hasNext()) { // cityNames[] and prices[][] populated
                for (int i = 0; i < iterator; i++) {
                    for (int j = 0; j < iterator; j++) {
                        if (fileIterator == cityNames[arrayIterator]) {
                            fileIterator++;
                            cityNames[arrayIterator] = Integer.parseInt(secondScan.next());
                            arrayIterator++;
                        }
                        price = secondScan.next();
                        prices[i][j] = parseInt(price);
                        fileIterator++;
                    }
                }
            }
        } catch (IOException ioException) {
            System.err.println("Cannot open file.");
            System.exit(1);
        }

        Collections.reverse(matrices); // flip LinkedList from top to bottom

        // INFORMATION PRINTOUTS:
        System.out.println("Adjacency matrix has been successfully copied to LinkedList!");
        System.out.println();
        System.out.println("Information on Graph Construction:");
        System.out.println(" Amount of Data Points: " + iterator);
        System.out.println(" Amount of Input Nodes (recommended initial population): " + nodes);
        System.out.println();
        System.out.println("What would you like the initial population to be?: ");
        Scanner userInput = new Scanner(System.in);
        int initialPopulation = userInput.nextInt();
        System.out.println("Initial population set to: " + initialPopulation);
        new Genome(matrices, prices, cityNames[0]); // initialize genome
        System.out.println("");

        System.out.println("Most optimal route: ");
        highestFitness(cityNames);

    }
}
