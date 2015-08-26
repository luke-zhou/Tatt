package analyser.powerball;

import analyser.Pattern;
import analyser.PatternKey;
import analyser.TrainResult;
import domain.draw.PowerBallDraw;
import domain.draw.PowerBallResult;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 24/08/2015
 * Time: 2:16 PM
 */
public class PowerBallExistingTrainer extends PowerBallAbstractTrainer
{
    public void train(PowerBallAnalyser analyser)
    {
        //existMatrix = new Boolean[powerBallDraws.size()][PowerBallDraw.MAX_NUM];
        Boolean[][] existMatrix = analyser.getExistMatrix();

        List<PowerBallDraw> powerBallDraws = analyser.getPowerBallDraws();

        //distance 1 only
        int distance =1;
        for (int trainingSize = 50; trainingSize < powerBallDraws.size(); trainingSize++)
        {
            System.out.println("training for " + trainingSize);
            List<TrainResult> trainResults = new ArrayList<TrainResult>();
            Map<PatternKey, Pattern> patternMap = analysePattern(trainingSize, existMatrix);
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
                        //frequency += 1.0*pattern.getFt().getMatchedCount()/pattern.getFf().getMatchedCount();
                    }
                }

                TrainResult trainResult = new TrainResult(outputNum, frequency);
                trainResults.add(trainResult);
            }

            Collections.sort(trainResults);
//            for (TrainResult trainResult : trainResults)
//            {
//                System.out.print(trainResult+"\t");
//            }
//            System.out.println();

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

    private Map<PatternKey, Pattern> analysePattern(int drawSize,Boolean[][] existMatrix)
    {
        Map<PatternKey, Pattern> patternMap = new HashMap<PatternKey, Pattern>();
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

        return patternMap;
    }

}
