package analyser.powerball;

import analyser.AbstractAnalyser;
import domain.Frequency;
import domain.PowerBallDraw;
import util.CsvUtil;

import java.util.List;

/**
 * Created by Luke on 13/05/2014.
 */
public class PowerBallAnalyser extends AbstractAnalyser
{
    private List<PowerBallDraw> powerBallDraws;

    public PowerBallAnalyser(String dataFileName)
    {
        super(dataFileName);
    }

    public void analyse()
    {
        powerBallDraws = CsvUtil.loadPowerData(dataFileName);
        frequency = new Frequency(PowerBallDraw.MAX_NUM);

        for (PowerBallDraw draw : powerBallDraws)
        {
            frequency.updateFrequency(draw.getNum1());
            frequency.updateFrequency(draw.getNum2());
            frequency.updateFrequency(draw.getNum3());
            frequency.updateFrequency(draw.getNum4());
            frequency.updateFrequency(draw.getNum5());
            frequency.updateFrequency(draw.getNum6());
        }

        //System.out.println(frequency);
        System.out.println(frequency.getSortedFrequency());

    }

    public List<PowerBallDraw> getPowerBallDraws()
    {
        return powerBallDraws;
    }
}
