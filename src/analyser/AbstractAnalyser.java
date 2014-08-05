package analyser;

import domain.PowerBallDraw;

import java.util.Map;

/**
 * Created by Luke on 4/08/2014.
 */
public abstract class AbstractAnalyser
{
    protected Map<Integer, Integer> frequency;
    protected String dataFileName;

    public AbstractAnalyser(String dataFileName)
    {
        this.dataFileName = dataFileName;
        analyse();
    }

    protected void initMap()
    {
        for (int i = 1; i <= getMaxDrawNum(); i++)
        {
            frequency.put(i, 0);
        }
    }

    protected void updateFrequency(Map<Integer, Integer> frequency, Integer num)
    {
        Integer value = frequency.get(num) + 1;
        frequency.put(num, value);
    }

    protected abstract int getMaxDrawNum();

    protected abstract void analyse();
}
