package analyser.powerball;

import analyser.AbstractTrainer;
import analyser.powerball.worker.PowerBallLinearWorker;
import domain.draw.PowerBallDraw;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 5/02/2015
 * Time: 8:27 AM
 */
public class PowerBallLinearTrainer extends AbstractTrainer
{
    private static final int OFFSET_RANGE = 10000;
    private static final int TIMES_RANGE = 10000;

    private List<PowerBallDraw> draws;

    public PowerBallLinearTrainer(List<PowerBallDraw> draws)
    {
        super();
        this.draws = draws;
    }

    @Override
    protected void multiThreadJob()
    {
        for (int i = -OFFSET_RANGE; i <= OFFSET_RANGE; i++)
        {
            Runnable worker = new PowerBallLinearWorker(i, TIMES_RANGE, (List<PowerBallDraw>) draws);
            executor.execute(worker);
        }
    }
}
