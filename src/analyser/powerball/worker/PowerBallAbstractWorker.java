package analyser.powerball.worker;

import analyser.AbstractWorker;
import domain.draw.PowerBallResult;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 3/02/2015
 * Time: 2:11 PM
 */
public class PowerBallAbstractWorker extends AbstractWorker
{
    public void accumulateWinPrice(PowerBallResult result)
    {
        if (result.getDivision() > 0)
        {
            win += result.getDivision();
            winNum++;
        }
        differ += result.getDiffer();
        total++;
    }
}
