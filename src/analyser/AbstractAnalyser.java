package analyser;

import domain.PowerBallDraw;

import java.util.Map;

/**
 * Created by Luke on 4/08/2014.
 */
public abstract class AbstractAnalyser
{
    protected Map<Integer, Integer> frequency;

    protected void initMap()
    {
        for (int i = 1; i <= getMaxDrawNum(); i++)
        {
            frequency.put(i, 0);
        }
    }

    protected abstract int getMaxDrawNum();
}
