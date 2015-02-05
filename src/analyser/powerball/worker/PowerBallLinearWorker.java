package analyser.powerball.worker;

import domain.draw.PowerBallDraw;
import domain.draw.PowerBallResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 5/02/2015
 * Time: 8:22 AM
 */
public class PowerBallLinearWorker extends PowerBallAbstractWorker implements Runnable
{
    private int offset;
    private int times;
    private List<PowerBallDraw> draws;

    public PowerBallLinearWorker(int offset, int times, List<PowerBallDraw> draws)
    {
        this.offset = offset;
        this.times = times;
        this.draws = draws;
    }

    public PowerBallLinearWorker(int offset, List<PowerBallDraw> draws)
    {
        this.offset = offset;
        this.draws = draws;
    }

    public void run()
    {
        if (offset % 1000 == 0) System.out.println("Power Ball Hit Linear: (offset:" + offset + ")");

        for (int x = 2049; x <= 2049; x++)
        {
            for (int z = 13; z < 14; z++)
            {
                reset();
                PowerBallDraw previous = null;
                for (PowerBallDraw draw : draws)
                {
                    if (previous == null)
                    {
                        previous = draw;
                        continue;
                    }

                    Integer[] selection = new Integer[PowerBallDraw.NUM_OF_BALL];

                    int tempSelection;
                    for (int i = 0; i < PowerBallDraw.NUM_OF_BALL; i++)
                    {
                        tempSelection = (Math.abs((previous.getNum(i + 1) * x + offset) % PowerBallDraw.MAX_NUM) + z) % PowerBallDraw.MAX_NUM;
                        selection[i] = tempSelection;
                    }

                    PowerBallResult result = draw.checkWinPowerHit(selection);

                    System.out.println(draw.toStringOrdered());
                    for (int i = 0; i < 6; i++)
                    {
                        System.out.print(selection[i]+":");
                    }
                    System.out.println();
                    System.out.println(result);
                    System.out.println();

                    accumulateWinPrice(result);

                    previous = draw;
                }

//                if ((1.0 * win / total) > 1 || winNum > 35)
                if (winNum > 38)
                {
                    System.out.println();
                    System.out.println("Power Ball Hit Linear:" + x + "|" + offset + "|" + z);
                    printOutResult();
                }
            }
        }
    }

}
