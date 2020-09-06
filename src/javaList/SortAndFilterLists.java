package javaList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAndFilterLists
{
    ArrayList<String> firstList,secondList,thirdList;
    SortAndFilterLists( ArrayList<ArrayList<String>> listOfLists)
    {
        this.firstList = (listOfLists).get(0);
        firstList.replaceAll(String::toLowerCase);
        this.secondList = (listOfLists).get(1);
        secondList.replaceAll(String::toLowerCase);
        this.thirdList = (listOfLists).get(2);
        thirdList.replaceAll(String::toLowerCase);
    }
    public void wordsAppearMoreThanOneList()
    {
        ArrayList<String> TwoAccuranceList = new ArrayList<>(Collections.emptyList());
        for (String fruit:firstList)
        {
            if(( secondList.contains(fruit)||thirdList.contains(fruit)) &&(!TwoAccuranceList.contains(fruit)))
            {
                TwoAccuranceList.add(fruit);
            }
        }
        for (String fruit:secondList
        ) {
            if( (firstList.contains(fruit)||thirdList.contains(fruit)) && (!TwoAccuranceList.contains(fruit)))
            {
                TwoAccuranceList.add(fruit);
            }
        }
        for (String fruit:thirdList
        ) {
            if( (secondList.contains(fruit)||firstList.contains(fruit)) && (!TwoAccuranceList.contains(fruit)))
            {
                TwoAccuranceList.add(fruit);
            }
        }
        System.out.println("Words that appear in more than one list:");
        System.out.println(TwoAccuranceList);
    }
    public void uniqueWord()
    {
        ArrayList<String> UniqueList = new ArrayList<>(Collections.emptyList());
        for (String fruit:firstList
        ) {
            if(( !secondList.contains(fruit)&& !thirdList.contains(fruit)) &&(!UniqueList.contains(fruit)))
            {
                UniqueList.add(fruit);
            }
        }
        for (String fruit:secondList
        ) {
            if( (!firstList.contains(fruit)&& !thirdList.contains(fruit)) && (!UniqueList.contains(fruit)))
            {
                UniqueList.add(fruit);
            }
        }
        for (String fruit:thirdList
        ) {
            if( (!secondList.contains(fruit)&& !firstList.contains(fruit)) && (!UniqueList.contains(fruit)))
            {
                UniqueList.add(fruit);
            }
        }
        System.out.println("The total number of unique words across all lists:");
        System.out.println(UniqueList);
    }
    public void FiveFrequentWords() {
        List<String> newList = Stream.of(firstList, secondList, thirdList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Set<String> uniqueSet = new HashSet<>(newList);
        HashMap<String, Integer> fruitWithFre = new HashMap<String, Integer>();
        for (String fruit : uniqueSet)
        {
            int value = Collections.frequency(newList, fruit);
            fruitWithFre.put(fruit, value);
        }

        List<Map.Entry<String, Integer>> list = fruitWithFre.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        //System.out.println(list);
        Collections.reverse(list);
        System.out.println("Top five frequent words in the all lists:");
        for (int value = 0; value < 5; value++) {
            System.out.println(list.get(value));
        }
    }
}
