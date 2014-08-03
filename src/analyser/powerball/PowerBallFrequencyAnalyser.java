package analyser.powerball;

import comparator.ValueComparator;
import domain.PowerBallDraw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Luke on 13/05/2014.
 */
public class PowerBallFrequencyAnalyser extends PowerBallAbstractAnalyser
{
    private Map<Integer, Integer> frequency;

    @Override
    public void analyse(List<PowerBallDraw> PowerBallDraws)
    {

            frequency = new HashMap<Integer, Integer>();
            ValueComparator bvc = new ValueComparator(frequency);
            TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);

            initMap();

            for (PowerBallDraw draw : PowerBallDraws)
            {
                updateFrequency(frequency, draw.getNum1());
                updateFrequency(frequency, draw.getNum2());
                updateFrequency(frequency, draw.getNum3());
                updateFrequency(frequency, draw.getNum4());
                updateFrequency(frequency, draw.getNum5());
                updateFrequency(frequency, draw.getNum6());
            }

            System.out.println(frequency);
            sortedFrequency.putAll(frequency);
            System.out.println(sortedFrequency);

    }

    @Override
    public void train(List<PowerBallDraw> PowerBallDraws)
    {

    }

    private void initMap()
    {
        for (int i = 1; i <= PowerBallDraw.MAX_NUM; i++)
        {
            frequency.put(i, 0);
        }
    }

    protected void updateFrequency(Map<Integer, Integer> frequency, Integer num)
    {
        Integer value = frequency.get(num) + 1;
        frequency.put(num, value);
    }
}
