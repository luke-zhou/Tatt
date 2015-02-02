package analyser.powerball;

import analyser.AbstractAnalyser;
import analyser.AbstractTrainer;
import comparator.ValueComparator;
import domain.Frequency;
import domain.OZDraw;
import domain.PowerBallDraw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Luke on 4/08/2014.
 */
public class PowerBallFrequencyTrainer extends PowerBallAbstractTrainer
{

    public void trainPowerHit(List<PowerBallDraw> powerBallDraws)
    {
        reset();

        System.out.println("PowerBall Power Hit Frequency:");
        frequency = new Frequency(PowerBallDraw.MAX_NUM);

        for (PowerBallDraw draw : powerBallDraws)
        {
            if (draw.getId() > FIRST_DRAW + TRAIN_SIZE)
            {
                Map<Integer, Integer> sortedFrequencyMap = frequency.getSortedFrequency();
                Integer[] selection = new Integer[PowerBallDraw.NUM_OF_BALL];
                int index = 0;
                for (Integer selected : sortedFrequencyMap.keySet())
                {
                    selection[index] = selected;
                    index++;
                    if (index >= PowerBallDraw.NUM_OF_BALL)
                    {
                        break;
                    }
                }
                double division = draw.checkWinPowerHit(selection);
                accumulateWinPrice(division);
            }

            frequency.updateFrequency(draw.getNum1());
            frequency.updateFrequency(draw.getNum2());
            frequency.updateFrequency(draw.getNum3());
            frequency.updateFrequency(draw.getNum4());
            frequency.updateFrequency(draw.getNum5());
            frequency.updateFrequency(draw.getNum6());
        }

        printOutResult();
    }


}
