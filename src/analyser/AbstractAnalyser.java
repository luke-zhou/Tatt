package analyser;

import domain.Frequency;
import domain.PowerBallDraw;

import java.util.Map;

/**
 * Created by Luke on 4/08/2014.
 */
public abstract class AbstractAnalyser
{
    protected Frequency frequency;
    protected String dataFileName;

    public AbstractAnalyser(String dataFileName)
    {
        this.dataFileName = dataFileName;
        analyse();
    }

    protected abstract void analyse();

}
