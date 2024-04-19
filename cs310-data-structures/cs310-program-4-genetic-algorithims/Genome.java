package edu.sdsu.cs.datastructures;

import java.util.*;

public class Genome {
    LinkedList<String> genome;
    int[][] travelPrices;
    int startingCity;
    int fitness;

    /**
     * Constructor for Genome using data
     * from Driver File I/O
     *
     * @return void
     */
    public Genome(LinkedList<String> permutationOfCities, int[][] prices, int startingCity) {
        this.genome = permutationOfCities;
        this.travelPrices = prices;
        this.startingCity = startingCity;
        this.fitness = this.computeFitness();

        generateRandomPath(this.genome);
        System.out.println("Random path generated...");

        int iterator = 0;
        int mutation = 0;
        int temp = 0;
        int[] totalCosts = new int[startingCity];
        Random rand = new Random();
        for(int i = 0; i < genome.size(); i++) {
            iterator++;
            totalCosts[i] = temp;
            System.out.println("[Generation " + temp + "] ~ cost for this gen path is " + temp);
            System.out.println();
        }
    }

    /**
     * Calculates fitness for a given
     * section of data
     *
     * @return void
     */
    public int computeFitness() {
        fitness = 0;
        int currentCity = startingCity;

        for (int i = 0; i < genome.size(); i++) {
            fitness += travelPrices[currentCity][i];
            currentCity = i;
        }

        return fitness;
    }

    /**
     * Generates a random path through
     * the cities and prices
     *
     * @return void
     */
    public static void generateRandomPath(LinkedList<String> listOfCities) {
        for (int cityCount = 1; cityCount <= 30; cityCount++) {
            listOfCities.add(Integer.toString(cityCount));
        }
        Collections.shuffle(listOfCities);
        System.out.println(listOfCities);
    }

    /**
     * Uses all prices with city and given generation
     * depth to calculate the total cost
     *
     * @return int
     */
    public static int calculateTotalCost(LinkedList<String> listOfCities, int[][] matrices) {
        int currCity = 0;
        int nextCity = 0;
        int currIndex = 0;
        int nextIndex = 0;
        int totalCost = 0;
        for (int traversal = 0; traversal < 30; traversal++) {
            currCity = Integer.parseInt(listOfCities.get(currIndex));
            nextCity = Integer.parseInt(listOfCities.get(nextIndex));
            totalCost += matrices[currCity - 1][nextCity - 1];
            currIndex++;
            nextIndex++;
        }
        return totalCost;
    }

    /**
     * Gives variation for city mutation
     * with regard to prices in the genetic alg
     *
     * @return void
     */
    public static void mutate(LinkedList<String> listOfCities) {
        Random rand = new Random();
        int randIndex = rand.nextInt(30);
        int swapIndex = rand.nextInt(30);
        Collections.swap(listOfCities, randIndex, swapIndex);
    }

    /**
     * Finds the variation with the highest fitness
     * (most efficient)
     *
     * @return void
     */
    public static void highestFitness(int[] arr) {
        int lowestCost = arr[0];
        int generationIteration = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < lowestCost) {
                lowestCost = arr[i];
                generationIteration = i++;
            }
        }
    }
}

