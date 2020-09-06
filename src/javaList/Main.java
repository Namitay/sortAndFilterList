package javaList;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main (String[]args)
    {
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
        ArrayList<String> firstList = new ArrayList<>(Arrays.asList("banana", "mango", "blueberry", "banana", "apple","cherry","fig"));
        listOfLists.add(firstList);

        ArrayList<String> secondList = new ArrayList<>(Arrays.asList("banana", "strawberry", "peach", "blueberry", "orange","grape","pear"));
        listOfLists.add(secondList);

        ArrayList<String> thirdList = new ArrayList<>(Arrays.asList("apple", "strawberry", "peach", "pineapple", "orange", "peach","cherry"));
        listOfLists.add(thirdList);

        SortAndFilterLists sortFruit = new SortAndFilterLists(listOfLists);
        sortFruit.wordsAppearMoreThanOneList();
        sortFruit.uniqueWord();
        sortFruit.FiveFrequentWords();
    }

}
/*
	Testcases to test the code -> All test cases are passed
	1. Verify user should get fruits which appear in more than one list.
	2. Verify user should get the total number of unique words across all lists.
	3. Verify user should get the top five frequent words in all lists.
	4. Verify if user enters empty string in the list.
    5. Verify if user enters one empty list in the main list.
    6. Verify if user enters all empty list in the main list.
    7. Verify if user enters some fruits in lowercase and some fruits in uppercase.
    8. Verify if user enters same fruits in the list many times.

 */
