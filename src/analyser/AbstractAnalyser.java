package analyser;

import domain.Frequency;
import domain.draw.Draw;
import domain.draw.PowerBallDraw;

import java.util.List;

/**
 * Created by Luke on 4/08/2014.
 */
public abstract class AbstractAnalyser
{
    protected Frequency frequency;
    protected String dataFileName;
    protected Boolean[][] existMatrix;

    public AbstractAnalyser(String dataFileName)
    {
        this.dataFileName = dataFileName;
        analyse();
    }

    protected abstract void analyse();

    private void initExistMatrix()
    {
        for (int i =0; i<existMatrix.length;i++)
        {
            for (int j = 0; j < existMatrix[i].length; j++)
            {
                existMatrix[i][j]=false;
            }
        }
    }

    protected abstract int getMaxNum();
    protected abstract int getNumOfBall();


    protected void createExistMatrix(List<? extends Draw> draws)
    {
        existMatrix = new Boolean[draws.size()][getMaxNum()];

        initExistMatrix();

        for (int i =0; i<draws.size();i++)
        {
            Draw draw = draws.get(i);
            for (int j = 1; j <= getNumOfBall(); j++)
            {
                existMatrix[i][draw.getNum(j)-1]=true;
            }
        }
    }

    protected void calculateFrequency(List<? extends Draw> draws)
    {
        frequency = new Frequency(getMaxNum());

        for (Draw draw : draws)
        {
            for (int i = 1; i <= getNumOfBall(); i++)
            {
                frequency.updateFrequency(draw.getNum(i));

            }
        }

        //System.out.println(frequency);
        System.out.println(frequency.getSortedFrequency());
    }

    public void printOutMatrix()
    {
        for (int i=0;i<getMaxNum();i++)
        {
            System.out.print((i+1)+"\t");
        }
        System.out.println();
        for (Boolean[] draw : existMatrix)
        {
            for (Boolean num : draw)
            {
                System.out.print((num?"1":"0")+"\t");
            }
            System.out.println();
        }
    }

    public Boolean[][] getExistMatrix()
    {
        return existMatrix;
    }
}
