package analyser.ozlotto;

import analyser.AbstractTrainer;
import domain.OZDraw;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 28/02/2014
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class OZAbstractTrainer extends AbstractTrainer
{
    protected static int TRAIN_SIZE = 400;
    protected static int FIRST_DRAW = 604;

    abstract public void analyse(List<OZDraw> OZDraws);
    abstract public void train(List<OZDraw> OZDraws);

    public void randomTraining(List<OZDraw> OZDraws)
    {
        System.out.println("Random:");
        int win = 0;
        int winNum = 0;
        int total = 0;
        for (OZDraw OZDraw : OZDraws)
        {
            Integer[] selection = new Integer[7];
            int index = 0;

            for (int i =0; i< 7;i++)
            {
                selection[i] = (int)(Math.random()*45+1);
                index++;
                if (index > 6)
                {
                    break;
                }
            }
            int division = OZDraw.checkWin(selection);
            if (division > 0)
            {
                win += division;
                winNum++;
            }
            total++;


        }

        System.out.println("win:" + win);
        System.out.println("winNum:" + winNum);
        System.out.println("total:" + total);
        System.out.println("total(%):" + 1.0 * win / total);

    }


}
