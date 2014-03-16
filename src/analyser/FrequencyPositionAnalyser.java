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
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class FrequencyPositionAnalyser extends FrequencyAnalyser
{
    public void frequencyPositionTraining(List<Draw> draws)
    {
        System.out.println("Frequency Position:");
        Map<Integer, Integer> position1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> position2 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> position3 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> position4 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> position5 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> position6 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> position7 = new HashMap<Integer, Integer>();


        for (int i = 1; i <= 45; i++)
        {
            position1.put(i, 0);
            position2.put(i, 0);
            position3.put(i, 0);
            position4.put(i, 0);
            position5.put(i, 0);
            position6.put(i, 0);
            position7.put(i, 0);
        }

        int win = 0;
        int winNum = 0;
        int total = 0;
        for (Draw draw : draws)
        {
            updateFrequency(position1, draw.getNum1());
            updateFrequency(position2, draw.getNum2());
            updateFrequency(position3, draw.getNum3());
            updateFrequency(position4, draw.getNum4());
            updateFrequency(position5, draw.getNum5());
            updateFrequency(position6, draw.getNum6());
            updateFrequency(position7, draw.getNum7());
            if (draw.getId() > FIRST_DRAW+TRAIN_SIZE)
            {
                Integer[] selection = new Integer[7];

                ValueComparator bvc = new ValueComparator(position1);
                TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);
                sortedFrequency.putAll(position1);
                selection[0] = sortedFrequency.firstKey();

                bvc = new ValueComparator(position2);
                sortedFrequency = new TreeMap<Integer, Integer>(bvc);
                sortedFrequency.putAll(position2);
                selection[1] = sortedFrequency.firstKey();

                bvc = new ValueComparator(position3);
                sortedFrequency = new TreeMap<Integer, Integer>(bvc);
                sortedFrequency.putAll(position3);
                selection[2] = sortedFrequency.firstKey();

                bvc = new ValueComparator(position4);
                sortedFrequency = new TreeMap<Integer, Integer>(bvc);
                sortedFrequency.putAll(position4);
                selection[3] = sortedFrequency.firstKey();

                bvc = new ValueComparator(position5);
                sortedFrequency = new TreeMap<Integer, Integer>(bvc);
                sortedFrequency.putAll(position5);
                selection[4] = sortedFrequency.firstKey();

                bvc = new ValueComparator(position6);
                sortedFrequency = new TreeMap<Integer, Integer>(bvc);
                sortedFrequency.putAll(position6);
                selection[5] = sortedFrequency.firstKey();

                bvc = new ValueComparator(position7);
                sortedFrequency = new TreeMap<Integer, Integer>(bvc);
                sortedFrequency.putAll(position7);
                selection[6] = sortedFrequency.firstKey();

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


}
