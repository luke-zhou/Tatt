package analyser.powerball.worker;

import domain.PowerBallDraw;
import util.MathUtil;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 3/02/2015
 * Time: 12:29 PM
 */
public class PowerBallPrimeWorker extends PowerBallAbstractWorker implements Runnable
{
    private int offset;
    private List<PowerBallDraw> draws;

    public PowerBallPrimeWorker(int offset, List<PowerBallDraw> draws)
    {
        this.offset = offset;
        this.draws = draws;
    }

    public void run()
    {
        if (offset%1000==0)System.out.println("Power Ball Hit Prime: (offset:" + offset + ")");

        for (int x = 1; x <= 10000; x++)
        {
            for (int z = 1; z < PowerBallDraw.MAX_NUM; z++)
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

                        try
                        {
                            int prime = MathUtil.getPrime(previous.getNum(i + 1));
                            tempSelection = (Math.abs((prime * x + offset) % PowerBallDraw.MAX_NUM)+z) % PowerBallDraw.MAX_NUM;
                            selection[i] = tempSelection;
                        }
                        catch (NotFoundException e)
                        {
                            selection[i] = 0;
                        }

                    }

                    double division = draw.checkWinPowerHit(selection);

                    accumulateWinPrice(division);

                    previous = draw;
                }

//                if ((1.0 * win / total) > 1 || winNum > 35)
                if (winNum > 36)
                {
                    System.out.println();
                    System.out.println("Power Ball Hit Prime:" + x + "|" + offset +"|"+z);
                    printOutResult();
                }
            }
        }
    }

}
