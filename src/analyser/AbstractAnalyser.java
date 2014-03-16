package analyser;

import domain.Draw;

import java.util.*;

import comparator.ValueComparator;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 28/02/2014
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractAnalyser
{
    protected static int TRAIN_SIZE = 200;
    protected static int FIRST_DRAW = 604;

    int win = 0;
    int winNum = 0;
    int total = 0;

    abstract public void analyse(List<Draw> draws);
    abstract public void train(List<Draw> draws);

    public void randomTraining(List<Draw> draws)
    {
        System.out.println("Random:");
        int win = 0;
        int winNum = 0;
        int total = 0;
        for (Draw draw : draws)
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
            int division = draw.checkWin7(selection);
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
