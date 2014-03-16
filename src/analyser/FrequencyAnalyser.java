package analyser;

import comparator.ValueComparator;
import domain.Draw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 12/03/2014
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class FrequencyAnalyser extends AbstractAnalyser
{
    public void analyse(List<Draw> draws)
    {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        ValueComparator bvc = new ValueComparator(frequency);
        TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);

        for (int i = 1; i <= 45; i++)
        {
            frequency.put(i, 0);
        }

        for (Draw draw : draws)
        {
            updateFrequency(frequency, draw.getNum1());
            updateFrequency(frequency, draw.getNum2());
            updateFrequency(frequency, draw.getNum3());
            updateFrequency(frequency, draw.getNum4());
            updateFrequency(frequency, draw.getNum5());
            updateFrequency(frequency, draw.getNum6());
            updateFrequency(frequency, draw.getNum7());
        }

        System.out.println(frequency);
        sortedFrequency.putAll(frequency);
        System.out.println(sortedFrequency);
    }

    public void frequencyWithSupply(List<Draw> draws)
    {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        ValueComparator bvc = new ValueComparator(frequency);
        TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);

        for (int i = 1; i <= 45; i++)
        {
            frequency.put(i, 0);
        }

        for (Draw draw : draws)
        {
            updateFrequency(frequency, draw.getNum1());
            updateFrequency(frequency, draw.getNum2());
            updateFrequency(frequency, draw.getNum3());
            updateFrequency(frequency, draw.getNum4());
            updateFrequency(frequency, draw.getNum5());
            updateFrequency(frequency, draw.getNum6());
            updateFrequency(frequency, draw.getNum7());
            updateFrequency(frequency, draw.getSupply1());
            updateFrequency(frequency, draw.getSupply2());
        }

        System.out.println(frequency);
        sortedFrequency.putAll(frequency);
        System.out.println(sortedFrequency);
    }

    public void train(List<Draw> draws)
    {
        System.out.println("Frequency7:");
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        ValueComparator bvc = new ValueComparator(frequency);
        TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);

        for (int i = 1; i <= 45; i++)
        {
            frequency.put(i, 0);
        }

        int win = 0;
        int winNum = 0;
        int total = 0;
        for (Draw draw : draws)
        {
            updateFrequency(frequency, draw.getNum1());
            updateFrequency(frequency, draw.getNum2());
            updateFrequency(frequency, draw.getNum3());
            updateFrequency(frequency, draw.getNum4());
            updateFrequency(frequency, draw.getNum5());
            updateFrequency(frequency, draw.getNum6());
            updateFrequency(frequency, draw.getNum7());
            if (draw.getId() > FIRST_DRAW+TRAIN_SIZE)
            {
                sortedFrequency.clear();
                sortedFrequency.putAll(frequency);
                Integer[] selection = new Integer[7];
                int index = 0;
                for (Integer selected : sortedFrequency.keySet())
                {
                    selection[index] = selected;
                    index++;
                    if (index > 6)
                    {
                        break;
                    }
                }
                int division = draw.checkWin7(selection);
                if (division > 0)
                {
                    win += division;
                    winNum++;
                }
                total++;

            }
        }

        System.out.println("win:" + win);
        System.out.println("winNum:" + winNum);
        System.out.println("total:" + total);
        System.out.println("total(%):" + 1.0 * win / total);

    }

    public void frequency8Training(List<Draw> draws)
    {
        System.out.println("Frequency8:");
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        ValueComparator bvc = new ValueComparator(frequency);
        TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);

        for (int i = 1; i <= 45; i++)
        {
            frequency.put(i, 0);
        }

        int win = 0;
        int winNum = 0;
        int total = 0;
        for (Draw draw : draws)
        {
            updateFrequency(frequency, draw.getNum1());
            updateFrequency(frequency, draw.getNum2());
            updateFrequency(frequency, draw.getNum3());
            updateFrequency(frequency, draw.getNum4());
            updateFrequency(frequency, draw.getNum5());
            updateFrequency(frequency, draw.getNum6());
            updateFrequency(frequency, draw.getNum7());
            if (draw.getId() > FIRST_DRAW+TRAIN_SIZE)
            {
                sortedFrequency.clear();
                sortedFrequency.putAll(frequency);
                Integer[] selection = new Integer[8];
                int index = 0;
                for (Integer selected : sortedFrequency.keySet())
                {
                    selection[index] = selected;
                    index++;
                    if (index > 7)
                    {
                        break;
                    }
                }
                int division = draw.checkWin8(selection);
                if (division > 0)
                {
                    win += division;
                    winNum++;
                }
                total++;

            }
        }

        System.out.println("win:" + win);
        System.out.println("winNum:" + winNum);
        System.out.println("total:" + total);
        System.out.println("total(%):" + 1.0 * win/8 / total);

    }

    public void frequencyWithSupplyTraining(List<Draw> draws)
    {
        System.out.println("Frequency with Supply:");
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        ValueComparator bvc = new ValueComparator(frequency);
        TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);

        for (int i = 1; i <= 45; i++)
        {
            frequency.put(i, 0);
        }

        int win = 0;
        int winNum = 0;
        int total = 0;
        for (Draw draw : draws)
        {
            if (draw.getId() > FIRST_DRAW+TRAIN_SIZE)
            {
                sortedFrequency.clear();
                sortedFrequency.putAll(frequency);
                Integer[] selection = new Integer[7];
                int index = 0;
                for (Integer selected : sortedFrequency.keySet())
                {
                    selection[index] = selected;
                    index++;
                    if (index > 6)
                    {
                        break;
                    }
                }
                int division = draw.checkWin7(selection);
                if (division > 0)
                {
                    win += division;
                    winNum++;
                }
                total++;

            }

            updateFrequency(frequency, draw.getNum1());
            updateFrequency(frequency, draw.getNum2());
            updateFrequency(frequency, draw.getNum3());
            updateFrequency(frequency, draw.getNum4());
            updateFrequency(frequency, draw.getNum5());
            updateFrequency(frequency, draw.getNum6());
            updateFrequency(frequency, draw.getNum7());
            updateFrequency(frequency, draw.getSupply1());
            updateFrequency(frequency, draw.getSupply2());

        }

        System.out.println("win:" + win);
        System.out.println("winNum:" + winNum);
        System.out.println("total:" + total);
        System.out.println("total(%):" + 1.0 * win / total);

    }

    protected void updateFrequency(Map<Integer, Integer> frequency, Integer num)
    {
        Integer value = frequency.get(num) + 1;
        frequency.put(num, value);
    }
}
