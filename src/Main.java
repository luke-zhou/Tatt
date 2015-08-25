import analyser.ozlotto.FrequencyTrainerOZ;
import analyser.ozlotto.OZAnalyser;
import analyser.ozlotto.OZExistingTrainer;
import analyser.powerball.*;
import analyser.powerball.worker.PowerBallLinearWorker;
import domain.draw.PowerBallDraw;

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
    private static String OZ_LOTTO_FILE = "data/OzLotto1070.csv";
    private static String POWER_BALL_FILE = "data/powerball1005.csv";
    public static void main(String[] args)
    {
        analyseOZ();
//        analysePowerBall();
    }

    private static void analyseOZ()
    {
        OZAnalyser analyser = new OZAnalyser(OZ_LOTTO_FILE);
        analyser.printOutMatrix();

        System.out.println(analyser.getExistMatrix().length);

        OZExistingTrainer trainer = new OZExistingTrainer();
        trainer.train(analyser);
        //FrequencyTrainerOZ baseLine = new FrequencyTrainerOZ();
        //baseLine.train(analyser.getOzDraws());

//        FrequencyTrainerOZ analyser = new FrequencyTrainerOZ();
//        analyser.randomTraining(OZDraws);
////        analyser.train(OZDraws);
////        analyser.frequency8Training(OZDraws);
////        analyser.frequencyWithSupplyTraining(OZDraws);
//        analyser.analyse(OZDraws);
//        analyser.frequency9Training(OZDraws);

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
        PowerBallAnalyser analyser = new PowerBallAnalyser(POWER_BALL_FILE);
        analyser.printOutMatrix();

        System.out.println(analyser.getExistMatrix().length);
//        PowerBallRandomTrainer baseLine = new PowerBallRandomTrainer();
//        baseLine.train(analyser.getPowerBallDraws());
//        baseLine.trainPowerHit(analyser.getPowerBallDraws());
//        PowerBallFrequencyTrainer frequencyTrainer = new PowerBallFrequencyTrainer();
//        frequencyTrainer.trainPowerHit(analyser.getPowerBallDraws());
//        PowerBallPiTrainer piTrainer = new PowerBallPiTrainer();
//        piTrainer.trainPowerHit(analyser.getPowerBallDraws());
//        piTrainer.train(analyser.getPowerBallDraws());
//        piTrainer.trainPowerHitWithPrime(analyser.getPowerBallDraws());
//        piTrainer.trainPowerHitWithPrimeAcc(analyser.getPowerBallDraws());
//        PowerBallPrimeTrainer primeTrainer = new PowerBallPrimeTrainer();
//        primeTrainer.train(analyser.getPowerBallDraws());
//        PowerBallLinearTrainer trainer = new PowerBallLinearTrainer(analyser.getPowerBallDraws());
//        PowerBallLinearWorker worker = new PowerBallLinearWorker(-9997, 1, analyser.getPowerBallDraws());
//        worker.run();

    }
}
