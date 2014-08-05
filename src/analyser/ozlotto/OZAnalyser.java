package analyser.ozlotto;

import analyser.AbstractAnalyser;
import comparator.ValueComparator;
import domain.Frequency;
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
        frequency = new Frequency(OZDraw.MAX_NUM);

        for (OZDraw ozDraw : ozDraws)
        {
            frequency.updateFrequency(ozDraw.getNum1());
            frequency.updateFrequency(ozDraw.getNum2());
            frequency.updateFrequency(ozDraw.getNum3());
            frequency.updateFrequency(ozDraw.getNum4());
            frequency.updateFrequency(ozDraw.getNum5());
            frequency.updateFrequency(ozDraw.getNum6());
            frequency.updateFrequency(ozDraw.getNum7());
        }

        //System.out.println(frequency);
        System.out.println(frequency.getSortedFrequency());
    }

}
