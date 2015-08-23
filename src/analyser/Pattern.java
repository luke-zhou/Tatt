package analyser;

/**
 * Created by Luke on 21/08/15.
 */
public class Pattern
{
    private int distance;
    private int inputNum;
    private int outputNum;

    private int totalCount;

    private PatternDetail tt;
    private PatternDetail ff;
    private PatternDetail ft;
    private PatternDetail tf;

    public Pattern(int distance)
    {
        this.distance = distance;
        tt = new PatternDetail(true, true);
        ff = new PatternDetail(false, false);
        ft = new PatternDetail(false, true);
        tf = new PatternDetail(true, false);
        totalCount=0;
    }

    public int getDistance()
    {
        return distance;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    public int getInputNum()
    {
        return inputNum;
    }

    public void setInputNum(int inputNum)
    {
        this.inputNum = inputNum;
    }

    public int getOutputNum()
    {
        return outputNum;
    }

    public void setOutputNum(int outputNum)
    {
        this.outputNum = outputNum;
    }

    public int getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }

    public void increaseTotalCount()
    {
        totalCount++;
    }

    public PatternDetail getTt()
    {
        return tt;
    }

    public PatternDetail getFf()
    {
        return ff;
    }

    public PatternDetail getFt()
    {
        return ft;
    }

    public PatternDetail getTf()
    {
        return tf;
    }

    public void updatePatternDetail(Boolean input, Boolean output)
    {
        if (input && output)
        {
            tt.increaseMatchedCount();
        }
        else if (input && !output)
        {
            tf.increaseMatchedCount();
        }
        else if (!input && output)
        {
            ft.increaseMatchedCount();
        }
        else if (!input && !output)
        {
            ff.increaseMatchedCount();
        }
    }

    @Override
    public String toString()
    {
        return "pattern: " +
                "[i:"+inputNum+"]"+
                "-d:"+distance+"-"+
                "[o:"+outputNum+"]"+
                "-total:"+totalCount+" ( "+
                tt + Math.round(100.0*tt.getMatchedCount()/totalCount) + "%\t" +
                tf + Math.round(100.0*tf.getMatchedCount()/totalCount) + "%\t" +
                ft + Math.round(100.0*ft.getMatchedCount()/totalCount) + "%\t" +
                ff + Math.round(100.0*ff.getMatchedCount()/totalCount) + "%" +
                ")";

    }


}
