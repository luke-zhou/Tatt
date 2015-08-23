package analyser;

/**
 * Created by Luke on 23/08/15.
 */
public class PatternKey
{
    int inputNum;
    int outputNum;
    int distance;

    public PatternKey(int inputNum, int outputNum, int distance)
    {
        this.inputNum = inputNum;
        this.outputNum = outputNum;
        this.distance = distance;
    }

    public PatternKey(Pattern pattern)
    {
        this.inputNum = pattern.getInputNum();
        this.outputNum = pattern.getOutputNum();
        this.distance = pattern.getDistance();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatternKey that = (PatternKey) o;

        if (distance != that.distance) return false;
        if (inputNum != that.inputNum) return false;
        if (outputNum != that.outputNum) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = inputNum;
        result = 31 * result + outputNum;
        result = 31 * result + distance;
        return result;
    }
}
