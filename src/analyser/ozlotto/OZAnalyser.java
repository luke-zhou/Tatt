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
        calculateFrequency(ozDraws);
        createExistMatrix(ozDraws);
    }

    @Override
    protected int getMaxNum()
    {
        return OZDraw.MAX_NUM;
    }

    @Override
    protected int getNumOfBall()
    {
        return OZDraw.NUM_OF_BALL;
    }

    public List<OZDraw> getOzDraws()
    {
        return ozDraws;
    }
}
