package analyser;

import domain.Frequency;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 3/02/2015
 * Time: 2:12 PM
 */
public class AbstractWorker
{
    public double win = 0;
    public int winNum = 0;
    public int total = 0;

    protected Frequency frequency;


    public void accumulateWinPrice(double division)
    {
        if (division > 0)
        {
            win += division;
            winNum++;
        }
        total++;
    }

    protected void reset()
    {
        win = 0;
        winNum = 0;
        total = 0;
    }

    public void printOutResult()
    {
        System.out.println("win:" + win);
        System.out.println("winNum:" + winNum);
        System.out.println("total:" + total);
        System.out.println("total(%):" + 1.0 * win / total);
    }
}
