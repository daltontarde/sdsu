/*
 * Constructs a private Map, and is able to run tests on the data set,
 * including N-Grams (up to 4), frequency data (as integers and percents),
 * and the ability to add to the existing data set.
 *
 * Program 3: N-Grams and Frequency Counts
 * Dalton Tarde
 * CS-310 Section 1
 * November 20, 2020
 */
package edu.sdsu.cs.datastructures;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencyCount {
    static HashMap<String, Integer> dataSet = new HashMap<>();

    /**
     * Constructor - uses list from Driver in order to calculate
     * the frequencies of the words within the list.
     * Input list is not preserved or modified.
     *
     * @param text
     * @return void
     */
    public FrequencyCount(List<String> text) {
        Map<String, Integer> map = text.parallelStream().
                collect(Collectors.toConcurrentMap(
                        i -> i, i -> 1, Integer::sum));
        map.putAll(dataSet);
    }

    /**
     * Constructor - takes frequency count from list, builds
     * a map using words from input as the keys in the map.
     * <p>
     * Caller can construct a frequency count of 2/3/4-grams,
     * and using a degree of 1 will produce the same output as
     * the default constructor.
     *
     * @param text, degree
     * @return void
     */
    FrequencyCount(List<String> text, int degree) {
        Map<String, Integer> map = text.parallelStream().
                collect(Collectors.toConcurrentMap(
                        i -> i, i -> degree, Integer::sum));
        map.putAll(dataSet);
    }

    /**
     * Returns an ordered list (ArrayList) of the top-20,
     * most frequent tokens appearing in the input
     * <p>
     * The item at index 0 shall be the most frequent.
     * <p>
     * In case of tie: stop populating after 20 iterations
     *
     * @return List<String>
     */
    public static List<String> head() {
        List<Integer> values = dataSet.values().stream().collect(Collectors.toList());
        List<String> keys = dataSet.keySet().stream().collect(Collectors.toList());

        return keys;
    }

    /**
     * Returns an ordered list (ArrayList) of the top-20,
     * least frequent tokens appearing in the input
     *
     * The item at index 0 shall be the most frequent least frequent word.
     * The item at index 19 shall be the absolute least frequent item in the Map
     *
     * In case of tie: stop populating after 20 iterations
     *
     * @return List<String>
     */
    public static List<String> tail() {
        Map<Integer, String> mapInverse =
                dataSet.entrySet()
                        .stream()
                        .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        List<String> values = mapInverse.values().stream().collect(Collectors.toList());
        List<Integer> keys = mapInverse.keySet().stream().collect(Collectors.toList());
        return values;
    }

    /**
     * Returns a random token from the keys of the map
     *
     * @return String
     */
    public static String randomToken () {
        List<String> valuesList = new ArrayList<String>();
        int randomIndex = new Random().nextInt(valuesList.size());
        String randomValue = valuesList.get(randomIndex);
        return randomValue;
    }

    /**
     * Returns the frequency count for a given input token
     *
     * @param token
     * @return int
     */
    public static int count (String token){
        return -1;
    }

    /**
     * Returns the percentage for the amount of appearances
     * of a given input token
     *
     * @param token
     * @return int
     */
    public static int percent (String token){
        return -1;
    }

    /**
     * Add a given input token to the current dataset.
     *
     * @param token
     * @return void
     */
    public static int add (String token){
        dataSet.put(token, 19);
        return -1;
    }
}


