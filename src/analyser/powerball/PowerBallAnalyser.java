package analyser.powerball;

import analyser.AbstractAnalyser;
import analyser.Pattern;
import domain.Frequency;
import domain.draw.PowerBallDraw;
import util.CsvUtil;

import java.util.List;

/**
 * Created by Luke on 13/05/2014.
 */
public class PowerBallAnalyser extends AbstractAnalyser
{
    private List<PowerBallDraw> powerBallDraws;

    private Boolean[][] existMatrix;

    public PowerBallAnalyser(String dataFileName)
    {
        super(dataFileName);
    }

    public void analyse()
    {
        powerBallDraws = CsvUtil.loadPowerData(dataFileName);

        calculateFrequency(powerBallDraws);

        createExistMatrix(powerBallDraws);

    }

    private void calculateFrequency(List<PowerBallDraw> powerBallDraws)
    {
        frequency = new Frequency(PowerBallDraw.MAX_NUM);

        for (PowerBallDraw draw : powerBallDraws)
        {
            frequency.updateFrequency(draw.getNum1());
            frequency.updateFrequency(draw.getNum2());
            frequency.updateFrequency(draw.getNum3());
            frequency.updateFrequency(draw.getNum4());
            frequency.updateFrequency(draw.getNum5());
            frequency.updateFrequency(draw.getNum6());
        }

        //System.out.println(frequency);
        System.out.println(frequency.getSortedFrequency());
    }

    private void createExistMatrix(List<PowerBallDraw> powerBallDraws)
    {
        existMatrix = new Boolean[powerBallDraws.size()][PowerBallDraw.MAX_NUM];

        for (int i =0; i<existMatrix.length;i++)
        {
            for (int j = 0; j < existMatrix[i].length; j++)
            {
                existMatrix[i][j]=false;
            }
        }

        for (int i =0; i<powerBallDraws.size();i++)
        {
            PowerBallDraw draw = powerBallDraws.get(i);
            for (int j = 1; j <= PowerBallDraw.NUM_OF_BALL; j++)
            {
                existMatrix[i][draw.getNum(j)-1]=true;
            }
        }

        analysePattern();
    }

    private void analysePattern()
    {
        //num compare to itself
        for (int distance = 1; distance <= 20; distance++)
        {
            for (int inputNum = 0; inputNum < PowerBallDraw.MAX_NUM; inputNum++)
            {
                for (int outputNum = 0; outputNum < PowerBallDraw.MAX_NUM; outputNum++)
                {
                    Pattern pattern = new Pattern(distance);
                    pattern.setInputNum(inputNum + 1);
                    pattern.setOutputNum(outputNum + 1);
                    for (int draw = 0; draw < powerBallDraws.size() - distance; draw++)
                    {
                        pattern.increaseTotalCount();

                        pattern.updatePatternDetail(existMatrix[draw][inputNum], existMatrix[draw + distance][outputNum]);

                    }
                    System.out.println(pattern);
                }
            }
        }
    }

    public void printOutMatrix()
    {
        for (int i=0;i<PowerBallDraw.MAX_NUM;i++)
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

    public List<PowerBallDraw> getPowerBallDraws()
    {
        return powerBallDraws;
    }
}
