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
}
