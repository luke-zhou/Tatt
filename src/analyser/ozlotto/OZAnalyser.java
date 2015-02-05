package analyser.ozlotto;

import analyser.AbstractAnalyser;
import domain.Frequency;
import domain.draw.OZDraw;
import util.CsvUtil;

import java.util.List;

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
        ozDraws = CsvUtil.loadOZData(dataFileName);
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

    public List<OZDraw> getOzDraws()
    {
        return ozDraws;
    }
}
