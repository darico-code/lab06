package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMENTS = 100_000;
    private static final int READS = 1000;
    private static final int START = 1000;
    private static final int END = 2000;
    private static final long AFRICA_POPULATION = 1_110_635_000L;
    private static final long AMERICAS_POPULATION = 972_005_000L;
    private static final long ANTARCTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final long EUROPE_POPULATION = 742_452_000L;
    private static final long OCEANIA_POPULATION = 38_304_000L;

    private UseListsAndMaps() {
    }   

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> firstColl = new ArrayList<>();
        for(int i=START; i<END; i++){
            firstColl.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> secondColl = new LinkedList<>(firstColl);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer temp=firstColl.get(firstColl.size()-1);
        firstColl.set(firstColl.size()-1, firstColl.get(0));
        firstColl.set(0, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(var el : firstColl){
            System.out.println(el);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long timeArrayList = System.nanoTime();
        long timeLinkedList;
        for(int i=0; i< ELEMENTS; i++){
            firstColl.add(0, i);
        }
        timeArrayList = System.nanoTime() - timeArrayList;
        timeLinkedList = System.nanoTime();
        for(int i=0; i< ELEMENTS ; i++){
            secondColl.add(0, i);
        }
        timeLinkedList = System.nanoTime() - timeLinkedList;
        System.out.println(
            "INSERTION TIME: for ArrayList: " 
                + timeArrayList
                + " ns, "
                + "for LinkedList: "
                + timeLinkedList
                + " ns."); 

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        timeArrayList= System.nanoTime();
        for(int i=0; i<READS; i++){
            firstColl.get((firstColl.size()-1)/2);
        }
        timeArrayList = System.nanoTime() - timeArrayList;
        timeLinkedList = System.nanoTime();
        for(int i=0; i<READS; i++){
            secondColl.get((firstColl.size()-1)/2);
        }
        timeLinkedList = System.nanoTime();
        System.out.println(
            "READING TIME for ArrayList: " 
                + timeArrayList
                + " ns, "
                + "for LinkedList: "
                + timeLinkedList
                + " ns."); 
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> map = new HashMap<>();
        map.put("Africa", AFRICA_POPULATION);
        map.put("Americas", AMERICAS_POPULATION);
        map.put("Antarctica", ANTARCTICA_POPULATION);
        map.put("Asia", ASIA_POPULATION);
        map.put("Europe", EUROPE_POPULATION);
        map.put("Oceania", OCEANIA_POPULATION);
        /*
         * 8) Compute the population of the world
         */
        Long population=0L;
        for(final Long p : map.values()){
            population = population + p;
        }
        System.out.println("Population of the world: " + population);
    }
}
