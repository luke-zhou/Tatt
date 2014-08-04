package analyser.powerball;

import analyser.AbstractAnalyser;
import comparator.ValueComparator;
import domain.PowerBallDraw;
import util.CsvUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Luke on 13/05/2014.
 */
public class PowerBallAnalyser extends AbstractAnalyser
{

    private String dataFileName;
    private List<PowerBallDraw> powerBallDraws;

    public PowerBallAnalyser(String dataFileName)
    {
        this.dataFileName = dataFileName;
        analyse();
    }

    public void analyse()
    {
        powerBallDraws = CsvUtil.loadPowerData(dataFileName);
        frequency = new HashMap<Integer, Integer>();
        ValueComparator bvc = new ValueComparator(frequency);
        TreeMap<Integer, Integer> sortedFrequency = new TreeMap<Integer, Integer>(bvc);

        initMap();

        for (PowerBallDraw draw : powerBallDraws)
        {
            updateFrequency(frequency, draw.getNum1());
            updateFrequency(frequency, draw.getNum2());
            updateFrequency(frequency, draw.getNum3());
            updateFrequency(frequency, draw.getNum4());
            updateFrequency(frequency, draw.getNum5());
            updateFrequency(frequency, draw.getNum6());
        }

        //System.out.println(frequency);
        sortedFrequency.putAll(frequency);
        System.out.println(sortedFrequency);

    }



    protected void updateFrequency(Map<Integer, Integer> frequency, Integer num)
    {
        Integer value = frequency.get(num) + 1;
        frequency.put(num, value);
    }

    public List<PowerBallDraw> getPowerBallDraws()
    {
        return powerBallDraws;
    }
}
