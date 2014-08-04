package analyser.ozlotto;

import comparator.ValueComparator;
import domain.OZDraw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 12/03/2014
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class AfterFrequencyAnalyserOZ extends OZAbstractAnalyser
{
    private Map<Integer, Map<Integer, Integer>> afterFrequencyMap;

    @Override
    public void analyse(List<OZDraw> OZDraws)
    {

        afterFrequencyMap = initialMap();

        for (OZDraw OZDraw : OZDraws)
        {
            updateFrequency(OZDraw.getNum1(), OZDraw.getNum2());
            updateFrequency(OZDraw.getNum2(), OZDraw.getNum3());
            updateFrequency(OZDraw.getNum3(), OZDraw.getNum4());
            updateFrequency(OZDraw.getNum4(), OZDraw.getNum5());
            updateFrequency(OZDraw.getNum5(), OZDraw.getNum6());
            updateFrequency(OZDraw.getNum6(), OZDraw.getNum7());
            updateFrequency(OZDraw.getNum7(), OZDraw.getSupply1());
            updateFrequency(OZDraw.getNum7(), OZDraw.getSupply2());
        }

        printResult();
    }

    private void printResult()
    {
        for (int i = 1; i <= 45; i++)
        {
            ValueComparator bvc = new ValueComparator(afterFrequencyMap.get(i));
            TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);
            sortedFrequency.putAll(afterFrequencyMap.get(i));
            System.out.print(i + "####");
            System.out.println(sortedFrequency);
        }
    }

    private void updateFrequency(Integer before, Integer after)
    {
        Map<Integer, Integer> map = afterFrequencyMap.get(before);
        Integer frequency = map.get(after) + 1;
        map.put(after, frequency);
    }

    private Map<Integer, Map<Integer, Integer>> initialMap()
    {
        Map<Integer, Map<Integer, Integer>> afterFrequencyMap = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 1; i <= 45; i++)
        {
            Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
            for (int j = 1; j <= 45; j++)
            {
                frequency.put(j, 0);
            }
            afterFrequencyMap.put(i, frequency);
        }
        return afterFrequencyMap;
    }

    @Override
    public void train(List<OZDraw> OZDraws)
    {
        FrequencyAnalyserOZ frequencyAnalyser = new FrequencyAnalyserOZ();
        frequencyAnalyser.analyse(OZDraws);

        analyse(OZDraws);

        System.out.println("After Frequency:");
        for (int j = TRAIN_SIZE; j < OZDraws.size(); j++)
        {


            Integer[] selection = new Integer[7];
            selection[0] = (int) (Math.random() * 45 + 1);
            //selection[0] = OZDraws.get(j).getNum1();
            for (int i = 0; i < 6; i++)
            {
                ValueComparator bvc = new ValueComparator(afterFrequencyMap.get(selection[i]));
                TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);
                sortedFrequency.putAll(afterFrequencyMap.get(selection[i]));
                selection[i + 1] = selectNumByMap(sortedFrequency, frequencyAnalyser);

            }

            int division = OZDraws.get(j).checkWin(selection);
            if (division > 0)
            {
                accumulateWinPrice(division);
                increaseWinNum();
            }
            increaseTotalNum();
        }

        System.out.println("win:" + win);
        System.out.println("winNum:" + winNum);
        System.out.println("total:" + total);
        System.out.println("total(%):" + 1.0 * win / total);
    }

    private Integer selectNumByMap(TreeMap<Integer, Integer> sortedFrequency, FrequencyAnalyserOZ frequencyAnalyser)
    {
        Integer value=sortedFrequency.firstEntry().getValue();
        Integer frequency=0;
        Integer selectedNum=0;
        for (int i =0; i<sortedFrequency.size();i++)
        {
            Map.Entry<Integer,Integer> entry = sortedFrequency.pollFirstEntry();

            if (entry.getValue() == value
                    && (frequencyAnalyser.getFrequency().get(entry.getKey())>frequency))
            {
                frequency = frequencyAnalyser.getFrequency().get(entry.getKey());
                selectedNum = entry.getKey();
            }
            else {
                break;
            }
        }

        return selectedNum;
    }
}
