package analyser.powerball;

import analyser.AbstractTrainer;
import domain.PowerBallDraw;

import java.util.List;

/**
 * Created by Luke on 13/05/2014.
 */
public abstract class PowerBallRandomTrainer extends AbstractTrainer
{
    protected static int TRAIN_SIZE = 400;
    protected static int FIRST_DRAW = 877;

    public void baseLine(List<PowerBallDraw> PowerBallDraws)
    {
        System.out.println("Power Ball Random(Baseline):");

        for (PowerBallDraw draw : PowerBallDraws)
        {
            int[] selection = new int[PowerBallDraw.NUM_OF_NUMBERS];

            for (int i = 0; i < PowerBallDraw.NUM_OF_NUMBERS; i++)
            {
                int tempSelection = (int) (Math.random() * PowerBallDraw.MAX_NUM + 1);
                if(isNumberSelected(tempSelection, selection))
                {
                    i--;
                    continue;
                }
                selection[i] = tempSelection;

            }
            int powderBall = (int) (Math.random() * PowerBallDraw.MAX_POWER_BALL_NUM + 1);
            PowerBallDraw testedDraw = new PowerBallDraw();
            testedDraw.setNum1(selection[0]);
            testedDraw.setNum2(selection[1]);
            testedDraw.setNum3(selection[2]);
            testedDraw.setNum4(selection[3]);
            testedDraw.setNum5(selection[4]);
            testedDraw.setNum6(selection[5]);
            testedDraw.setPowerBall(powderBall);
            int division = draw.checkWin(testedDraw);

            accumulateWinPrice(division);
        }

        printOutResult();

    }

    private boolean isNumberSelected(int tempSelection, int[] selection)
    {
        for (Integer num : selection)
        {
            if (tempSelection == num) return true;
        }

        return false;
    }
}
