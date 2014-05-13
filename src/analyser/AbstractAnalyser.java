package analyser;

/**
 * Created by Luke on 13/05/2014.
 */
public abstract class AbstractAnalyser
{
    private int win = 0;
    private int winNum = 0;
    private int total = 0;

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

    public int getWin()
    {
        return win;
    }

    public void setWin(int win)
    {
        this.win = win;
    }

    public int getWinNum()
    {
        return winNum;
    }

    public void setWinNum(int winNum)
    {
        this.winNum = winNum;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }
}
