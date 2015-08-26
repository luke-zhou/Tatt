package analyser.ozlotto;

import analyser.Pattern;
import analyser.PatternKey;
import analyser.TrainResult;
import domain.draw.OZDraw;

import java.util.*;

import static util.DebugUtil.consoleLog;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 25/08/2015
 * Time: 10:42 AM
 */
public class OZExistingTrainer extends OZAbstractTrainer
{
    public void train(OZAnalyser analyser)
    {
        //existMatrix = new Boolean[Draws.size()][Draw.MAX_NUM];
        Boolean[][] existMatrix = analyser.getExistMatrix();

        List<OZDraw> ozDraws = analyser.getOzDraws();

        int winCount = 0;
        for (int trainingSize = 250; trainingSize < ozDraws.size(); trainingSize++)
        {
            List<TrainResult> trainResults = generateTrainResults(trainingSize,existMatrix,ozDraws);

            Collections.sort(trainResults);

            Integer[] selection = {
                    trainResults.get(0).getNumber(),
                    trainResults.get(1).getNumber(),
                    trainResults.get(2).getNumber(),
                    trainResults.get(3).getNumber(),
                    trainResults.get(4).getNumber(),
                    trainResults.get(5).getNumber(),
                    trainResults.get(6).getNumber()
            };
            int result = ozDraws.get(trainingSize).checkWin(selection);
            if (result > 0) winCount++;
        }
        consoleLog("\n");
        consoleLog("result:" + (1.0 * winCount / (ozDraws.size() - 250))+"\n");

    }

    private List<TrainResult> generateTrainResults(int trainingSize, Boolean[][] existMatrix, List<OZDraw> draws )
    {
        List<TrainResult> trainResults = new ArrayList<TrainResult>();

        Map<PatternKey, Pattern> patternMap = analysePattern(trainingSize, existMatrix);

        for (int outputNum = 1; outputNum <= OZDraw.MAX_NUM; outputNum++)
        {
            double frequency = 0;
            for (int inputNum = 1; inputNum <= OZDraw.MAX_NUM; inputNum++)
            {
                for (int distance = 1; distance <= 10; distance++)
                {
                    PatternKey key = new PatternKey(inputNum, outputNum, distance);
                    Pattern pattern = patternMap.get(key);
                    OZDraw draw = draws.get(trainingSize - distance);

                    if (draw.hasNum(inputNum))
                    {
                        frequency += 1.0 * pattern.getTt().getMatchedCount() / pattern.getTf().getMatchedCount();
                    }
                    else
                    {
                        //frequency += 1.0*pattern.getFt().getMatchedCount()/pattern.getFf().getMatchedCount();
                    }


                }

                TrainResult trainResult = new TrainResult(outputNum, frequency);
                trainResults.add(trainResult);
            }
        }

        return trainResults;
    }

    private Map<PatternKey, Pattern> analysePattern(int drawSize, Boolean[][] existMatrix)
    {
        Map<PatternKey, Pattern> patternMap = new HashMap<PatternKey, Pattern>();
        for (int distance = 1; distance <= 20; distance++)
        {
            for (int inputNum = 0; inputNum < OZDraw.MAX_NUM; inputNum++)
            {
                for (int outputNum = 0; outputNum < OZDraw.MAX_NUM; outputNum++)
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
//        System.out.println(patternMap.size());
//        System.out.println(existMatrix[drawSize - 2][1]);
//        System.out.println(existMatrix[drawSize - 2][2]);
//        System.out.println(existMatrix[drawSize - 2][3]);
//        System.out.println(existMatrix[drawSize - 2][4]);
//        System.out.println(existMatrix[drawSize - 2][5]);

        return patternMap;
    }

}
