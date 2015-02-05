package analyser.powerball;

import domain.draw.PowerBallDraw;
import domain.draw.PowerBallResult;

import java.util.List;

/**
 * Created by Luke on 13/05/2014.
 */
public class PowerBallRandomTrainer extends PowerBallAbstractTrainer
{
    public void train(List<PowerBallDraw> powerBallDraws)
    {
        reset();

        System.out.println("Power Ball Random(Baseline):");

        for (PowerBallDraw draw : powerBallDraws)
        {
            Integer[] selection = pickNumber();

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

    public void trainPowerHit(List<PowerBallDraw> powerBallDraws)
    {
        reset();

        System.out.println("Power Ball Hit Random(Baseline):");

        for (PowerBallDraw draw : powerBallDraws)
        {
            Integer[] selection = pickNumber();

            PowerBallResult result = draw.checkWinPowerHit(selection);

            accumulateWinPrice(result.getDivision());
        }

        printOutResult();

    }

    private Integer[] pickNumber()
    {
        Integer[] selection = new Integer[PowerBallDraw.NUM_OF_BALL];

        for (int i = 0; i < PowerBallDraw.NUM_OF_BALL; i++)
        {
            int tempSelection = (int) (Math.random() * PowerBallDraw.MAX_NUM + 1);
            if(isNumberSelected(tempSelection, selection))
            {
                i--;
                continue;
            }
            selection[i] = tempSelection;

        }

        return selection;
    }

    private boolean isNumberSelected(int tempSelection, Integer[] selection)
    {
        for (Integer num : selection)
        {
            if (num!=null && tempSelection == num) return true;
        }

        return false;
    }
}
