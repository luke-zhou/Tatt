package analyser.ozlotto;

import domain.OZDraw;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 6/08/2014
 * Time: 9:06 AM
 */
public class OZRandomTrainer extends OZAbstractTrainer
{

    public void train(List<OZDraw> ozDraws)
    {
        System.out.println("Random OZ:");
        for (OZDraw ozDraw : ozDraws)
        {
            Integer[] selection = new Integer[OZDraw.NUM_OF_BALL];
            int index = 0;

            for (Integer number : selection)
            {
                number = (int) (Math.random() * OZDraw.MAX_NUM + 1);
            }
            int division = ozDraw.checkWin(selection);
            accumulateWinPrice(division);
        }
        printOutResult();
    }
}
