package analyser;

/**
 * Created by Luke on 22/08/15.
 */
public class PatternDetail
{
    private boolean inputResult;
    private boolean outputResult;
    private int matchedCount;

    public PatternDetail(boolean inputResult, boolean outputResult)
    {
        this.inputResult = inputResult;
        this.outputResult = outputResult;
        this.matchedCount = 0;
    }

    public void increaseMatchedCount()
    {
        matchedCount++;
    }

    public int getMatchedCount()
    {
        return matchedCount;
    }

    @Override
    public String toString()
    {
        return (inputResult?"1":"0")+"-"+(outputResult?"1":"0")+"("+matchedCount+")";
    }
}
