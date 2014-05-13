import analyser.ozlotto.FrequencyAnalyserOZ;
import domain.OZDraw;
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
    public static void main(String[] args)
    {
        List<OZDraw> OZDraws = CsvUtil.loadData(OZ_LOTTO_FILE);

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
}
