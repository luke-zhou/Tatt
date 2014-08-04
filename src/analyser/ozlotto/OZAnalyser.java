package analyser.ozlotto;

import analyser.AbstractAnalyser;
import comparator.ValueComparator;
import domain.OZDraw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Luke on 4/08/2014.
 */
public class OZAnalyser extends AbstractAnalyser
{
    private Map<Integer, Integer> frequency;

    public void analyse(List<OZDraw> OZDraws)
    {
        frequency = new HashMap<Integer, Integer>();
        ValueComparator bvc = new ValueComparator(frequency);
        TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);

        initMap();

        for (OZDraw OZDraw : OZDraws)
        {
            updateFrequency(frequency, OZDraw.getNum1());
            updateFrequency(frequency, OZDraw.getNum2());
            updateFrequency(frequency, OZDraw.getNum3());
            updateFrequency(frequency, OZDraw.getNum4());
            updateFrequency(frequency, OZDraw.getNum5());
            updateFrequency(frequency, OZDraw.getNum6());
            updateFrequency(frequency, OZDraw.getNum7());
        }

        //System.out.println(frequency);
        sortedFrequency.putAll(frequency);
        System.out.println(sortedFrequency);
    }
}
