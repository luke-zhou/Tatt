import analyser.AbstractAnalyser;
import analyser.AfterFrequencyAnalyser;
import analyser.FrequencyAnalyser;
import analyser.FrequencyPositionAnalyser;
import domain.Draw;
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
        List<Draw> draws = CsvUtil.loadData(OZ_LOTTO_FILE);

        FrequencyAnalyser analyser = new FrequencyAnalyser();
        analyser.randomTraining(draws);
//        analyser.train(draws);
//        analyser.frequency8Training(draws);
//        analyser.frequencyWithSupplyTraining(draws);
        analyser.analyse(draws);

        FrequencyPositionAnalyser frequencyPositionAnalyser = new FrequencyPositionAnalyser();
        frequencyPositionAnalyser.analyse(draws);
//
//        FrequencyPositionAnalyser analyser1 = new FrequencyPositionAnalyser();
//        analyser1.frequencyPositionTraining(draws);


        AfterFrequencyAnalyser afterFrequencyAnalyser = new AfterFrequencyAnalyser();
        //afterFrequencyAnalyser.analyse(draws);
        afterFrequencyAnalyser.train(draws);
    }
}
