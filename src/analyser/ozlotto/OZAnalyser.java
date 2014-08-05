package analyser.ozlotto;

import analyser.AbstractAnalyser;
import comparator.ValueComparator;
import domain.OZDraw;
import domain.PowerBallDraw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Luke on 4/08/2014.
 */
public class OZAnalyser extends AbstractAnalyser
{
    private List<OZDraw> ozDraws;

    public OZAnalyser(String dataFileName)
    {
        super(dataFileName);
    }

    public void analyse()
    {
        frequency = new HashMap<Integer, Integer>();
        ValueComparator bvc = new ValueComparator(frequency);
        TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);

        initMap();

        for (OZDraw ozDraw : ozDraws)
        {
            updateFrequency(frequency, ozDraw.getNum1());
            updateFrequency(frequency, ozDraw.getNum2());
            updateFrequency(frequency, ozDraw.getNum3());
            updateFrequency(frequency, ozDraw.getNum4());
            updateFrequency(frequency, ozDraw.getNum5());
            updateFrequency(frequency, ozDraw.getNum6());
            updateFrequency(frequency, ozDraw.getNum7());
        }

        //System.out.println(frequency);
        sortedFrequency.putAll(frequency);
        System.out.println(sortedFrequency);
    }

    @Override
    protected int getMaxDrawNum()
    {
        return OZDraw.MAX_NUM;
    }

}
