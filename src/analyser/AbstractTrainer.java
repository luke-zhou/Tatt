package analyser;

/**
 * Created by Luke on 13/05/2014.
 */
public abstract class AbstractTrainer
{
    public int win = 0;
    public int winNum = 0;
    public int total = 0;

    public void accumulateWinPrice(int division)
    {
        if (division > 0)
        {
            win += division;
            winNum++;
        }
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
