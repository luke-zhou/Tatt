import analyser.ozlotto.FrequencyAnalyserOZ;
import analyser.powerball.PowerBallFrequencyAnalyser;
import domain.OZDraw;
import domain.PowerBallDraw;
import util.CsvUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 27/02/2014
 * Time: 9:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main
{
    private static String OZ_LOTTO_FILE = "data/OzLotto.csv";
    private static String POWER_BALL_FILE = "data/powerball.csv";
    public static void main(String[] args)
    {
        analyseOZ();
        //analysePowerBall();
    }

    private static void analyseOZ()
    {
        List<OZDraw> OZDraws = CsvUtil.loadOZData(OZ_LOTTO_FILE);

        FrequencyAnalyserOZ analyser = new FrequencyAnalyserOZ();
        analyser.randomTraining(OZDraws);
//        analyser.train(OZDraws);
//        analyser.frequency8Training(OZDraws);
//        analyser.frequencyWithSupplyTraining(OZDraws);
        analyser.analyse(OZDraws);
        analyser.frequency9Training(OZDraws);

//        FrequencyPositionAnalyserOZ frequencyPositionAnalyser = new FrequencyPositionAnalyserOZ();
//        frequencyPositionAnalyser.analyse(OZDraws);
////
////        FrequencyPositionAnalyserOZ analyser1 = new FrequencyPositionAnalyserOZ();
////        analyser1.frequencyPositionTraining(OZDraws);
//
//
//        AfterFrequencyAnalyserOZ afterFrequencyAnalyser = new AfterFrequencyAnalyserOZ();
//        //afterFrequencyAnalyser.analyse(OZDraws);
//        afterFrequencyAnalyser.train(OZDraws);
    }

    private static void analysePowerBall()
    {
        List<PowerBallDraw> draws = CsvUtil.loadPowerData(POWER_BALL_FILE);

        PowerBallFrequencyAnalyser analyser = new PowerBallFrequencyAnalyser();
        analyser.randomTraining(draws);
//        analyser.train(OZDraws);
//        analyser.frequency8Training(OZDraws);
//        analyser.frequencyWithSupplyTraining(OZDraws);
        analyser.analyse(draws);
        //analyser.frequency9Training(OZDraws);

//        FrequencyPositionAnalyserOZ frequencyPositionAnalyser = new FrequencyPositionAnalyserOZ();
//        frequencyPositionAnalyser.analyse(OZDraws);
////
////        FrequencyPositionAnalyserOZ analyser1 = new FrequencyPositionAnalyserOZ();
////        analyser1.frequencyPositionTraining(OZDraws);
//
//
//        AfterFrequencyAnalyserOZ afterFrequencyAnalyser = new AfterFrequencyAnalyserOZ();
//        //afterFrequencyAnalyser.analyse(OZDraws);
//        afterFrequencyAnalyser.train(OZDraws);
    }
}
