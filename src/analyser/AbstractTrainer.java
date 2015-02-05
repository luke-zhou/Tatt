package analyser;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 5/02/2015
 * Time: 9:00 AM
 */
public abstract class AbstractTrainer implements Trainer
{
    private final int THREAD_NUM=5;

    protected final ExecutorService executor;

    protected AbstractTrainer()
    {
        executor = Executors.newFixedThreadPool(THREAD_NUM);
    }

    public void train()
    {
        System.out.println("start at: " + (new Date()).toInstant());
        multiThreadJob();
        executor.shutdown();
        while (!executor.isTerminated())
        {
        }
        System.out.println("Finished all work");
        System.out.println("finish at: " + (new Date()).toInstant());
    }

    protected abstract void multiThreadJob();

}
