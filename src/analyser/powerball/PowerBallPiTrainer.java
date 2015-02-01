package analyser.powerball;

import domain.PowerBallDraw;
import util.MathUtil;

import java.util.List;

/**
 * Created by Luke on 1/02/15.
 */
public class PowerBallPiTrainer extends PowerBallAbstractTrainer
{
    public void train(List<PowerBallDraw> powerBallDraws)
    {
        for (PowerBallDraw draw : powerBallDraws)
        {

        }
    }

    public int retrieveNumberFromPi(int start)
    {
        MathUtil.PI_FRACTION.substring(start,start+2);
    }
}
