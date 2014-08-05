package domain;

import comparator.ValueComparator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Luke on 5/08/2014.
 */
public class Frequency
{
    private int size;

    protected Map<Integer, Integer> frequencyMap;

    public Frequency(int size)
    {
        this.size = size;
        initMap();
    }

    protected void initMap()
    {
        frequencyMap = new HashMap<Integer, Integer>();
        for (int i = 1; i <= size; i++)
        {
            frequencyMap.put(i, 0);
        }
    }

    public void updateFrequency(Integer num)
    {
        Integer value = frequencyMap.get(num) + 1;
        frequencyMap.put(num, value);
    }

    public Map<Integer,Integer> getSortedFrequency()
    {
        ValueComparator bvc = new ValueComparator(frequencyMap);
        TreeMap<Integer, Integer> sortedFrequencyMap = new TreeMap<Integer, Integer>(bvc);
        sortedFrequencyMap.putAll(frequencyMap);
        return sortedFrequencyMap;
    }

}
