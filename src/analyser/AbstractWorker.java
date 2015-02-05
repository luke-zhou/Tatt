package analyser;

import domain.Frequency;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 3/02/2015
 * Time: 2:12 PM
 */
public class AbstractWorker implements Worker
{
    protected double win = 0;
    protected int winNum = 0;
    protected int total = 0;
    protected double differ = 0;

    protected void reset()
    {
        win = 0;
        winNum = 0;
        total = 0;
        differ=0;
    }

    public void printOutResult()
    {
        System.out.println("win:" + win);
        System.out.println("winNum:" + winNum);
        System.out.println("total:" + total);
        System.out.println("avg win(%):" + 1.0 * win / total);
        System.out.println("avg differ(%):" + 1.0 * differ / total);
    }
}
