package analyser;

/**
 * Created by Luke on 13/05/2014.
 */
public abstract class AbstractAnalyser
{
    public int win = 0;
    public int winNum = 0;
    public int total = 0;

    public void accumulateWinPrice(int division)
    {
        win += division;
    }

    public void increaseWinNum()
    {
        winNum++;
    }

    public void increaseTotalNum()
    {
        total++;
    }

    public void printOutResult()
    {
        System.out.println("win:" + win);
        System.out.println("winNum:" + winNum);
        System.out.println("total:" + total);
        System.out.println("total(%):" + 1.0 * win / total);
    }
}
