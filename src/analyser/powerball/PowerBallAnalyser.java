package analyser.powerball;

import analyser.AbstractAnalyser;
import analyser.Pattern;
import analyser.PatternKey;
import analyser.TrainResult;
import domain.Frequency;
import domain.draw.PowerBallDraw;
import domain.draw.PowerBallResult;
import util.CsvUtil;

import java.util.*;

/**
 * Created by Luke on 13/05/2014.
 */
public class PowerBallAnalyser extends AbstractAnalyser
{
    private List<PowerBallDraw> powerBallDraws;

    private Boolean[][] existMatrix;
    private Map<PatternKey, Pattern> patternMap;

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

        //distance 1 only
        int distance =1;
        for (int trainingSize = 50; trainingSize <= powerBallDraws.size(); trainingSize++)
        {
            System.out.println("training for " + trainingSize);
            List<TrainResult> trainResults = new ArrayList<TrainResult>();
            analysePattern(trainingSize);
            for (int outputNum = 1; outputNum <= PowerBallDraw.MAX_NUM; outputNum++)
            {
                double frequency = 0;
                for (int inputNum = 1; inputNum <= PowerBallDraw.MAX_NUM; inputNum++)
                {
                    PatternKey key = new PatternKey(inputNum, outputNum, distance);
                    Pattern pattern = patternMap.get(key);
                    PowerBallDraw draw = powerBallDraws.get(trainingSize-1);
                    //System.out.println(draw);
                    if (draw.hasNum(inputNum))
                    {
                        frequency += 1.0*pattern.getTt().getMatchedCount()/pattern.getTf().getMatchedCount();
                    }
                    else{
                        frequency += 1.0*pattern.getFt().getMatchedCount()/pattern.getFf().getMatchedCount();
                    }
                }

                TrainResult trainResult = new TrainResult(outputNum, frequency);
                trainResults.add(trainResult);
            }

            Collections.sort(trainResults);
            for (TrainResult trainResult : trainResults)
            {
                System.out.print(trainResult+"\t");
            }
            System.out.println();

            Integer[] selection ={
                    trainResults.get(0).getNumber(),
                    trainResults.get(1).getNumber(),
                    trainResults.get(2).getNumber(),
                    trainResults.get(3).getNumber(),
                    trainResults.get(4).getNumber(),
                    trainResults.get(5).getNumber()
            };
            PowerBallResult result = powerBallDraws.get(trainingSize).checkWinPowerHit(selection);
            System.out.println("result:"+result);
        }
    }

    private void analysePattern(int drawSize)
    {
        patternMap = new HashMap<PatternKey, Pattern>();
        for (int distance = 1; distance <= 20; distance++)
        {
            for (int inputNum = 0; inputNum < PowerBallDraw.MAX_NUM; inputNum++)
            {
                for (int outputNum = 0; outputNum < PowerBallDraw.MAX_NUM; outputNum++)
                {
                    Pattern pattern = new Pattern(distance);
                    pattern.setInputNum(inputNum + 1);
                    pattern.setOutputNum(outputNum + 1);
                    for (int draw = 0; draw < drawSize - distance; draw++)
                    {
                        pattern.increaseTotalCount();

                        pattern.updatePatternDetail(existMatrix[draw][inputNum], existMatrix[draw + distance][outputNum]);

                    }
                    //if(pattern.getOutputNum()==31&&pattern.getDistance()==1)System.out.println(pattern);
                    patternMap.put(new PatternKey(pattern), pattern);

                }
            }
        }
        //System.out.println(patternMap.size());
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
