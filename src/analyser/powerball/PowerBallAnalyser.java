package analyser.powerball;

import analyser.AbstractAnalyser;
import analyser.Pattern;
import analyser.PatternKey;
import analyser.TrainResult;
import domain.Frequency;
import domain.draw.PowerBallDraw;
import domain.draw.PowerBallResult;
import util.CsvUtil;

import java.util.*;

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

        calculateFrequency(powerBallDraws);

        createExistMatrix(powerBallDraws);


    }



    @Override
    protected int getMaxNum()
    {
        return PowerBallDraw.MAX_NUM;
    }

    @Override
    protected int getNumOfBall()
    {
       return PowerBallDraw.NUM_OF_BALL;
    }

    public List<PowerBallDraw> getPowerBallDraws()
    {
        return powerBallDraws;
    }
}
