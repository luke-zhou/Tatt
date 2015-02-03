package analyser.powerball;

import analyser.Trainer;
import analyser.powerball.worker.PowerBallPrimeWorker;
import domain.Draw;
import domain.PowerBallDraw;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 3/02/2015
 * Time: 12:29 PM
 */
public class PowerBallPrimeTrainer implements Trainer
{
    @Override
    public void train(List<? extends Draw> draws)
    {

        System.out.println("start at: "+(new Date()).toInstant());
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = -10000; i <= 10000; i++)
        {
            Runnable worker = new PowerBallPrimeWorker(i, (List<PowerBallDraw>) draws);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated())
        {
        }
        System.out.println("Finished all work");
        System.out.println("finish at: "+(new Date()).toInstant());
    }

}
