package analyser.powerball;

import domain.PowerBallDraw;
import util.MathUtil;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Luke on 1/02/15.
 */
public class PowerBallPiTrainer extends PowerBallAbstractTrainer
{
    public void trainPowerHit(List<PowerBallDraw> powerBallDraws)
    {
        reset();

        System.out.println("Power Ball Hit PI:");

        for (PowerBallDraw draw : powerBallDraws)
        {
            Integer[] selection = new Integer[PowerBallDraw.NUM_OF_BALL];

            int tempSelection;

            for (int i = 0; i < PowerBallDraw.NUM_OF_BALL; i++)
            {
                tempSelection = retrieveNumberFromPi(draw.getNum(i+1));
                tempSelection = isNumberSelected(tempSelection, selection) ? 0 : tempSelection;
                selection[i] = tempSelection;
            }

            double division = draw.checkWinPowerHit(selection);

            accumulateWinPrice(division);
        }

        printOutResult();

    }

    public void train(List<PowerBallDraw> powerBallDraws)
    {
        reset();

        System.out.println("Power Ball PI:");

        for (PowerBallDraw draw : powerBallDraws)
        {
            Integer[] selection = new Integer[PowerBallDraw.NUM_OF_BALL];

            int tempSelection;

            for (int i = 0; i < PowerBallDraw.NUM_OF_BALL; i++)
            {
                tempSelection = retrieveNumberFromPi(draw.getNum(i+1));
                tempSelection = isNumberSelected(tempSelection, selection) ? 0 : tempSelection;
                selection[i] = tempSelection;
            }

            int powderBall = retrieveNumberFromPi(draw.getPowerBall());;
            PowerBallDraw testedDraw = new PowerBallDraw();
            testedDraw.setNum1(selection[0]);
            testedDraw.setNum2(selection[1]);
            testedDraw.setNum3(selection[2]);
            testedDraw.setNum4(selection[3]);
            testedDraw.setNum5(selection[4]);
            testedDraw.setNum6(selection[5]);
            testedDraw.setPowerBall(powderBall);

            double division = draw.checkWin(testedDraw);

            accumulateWinPrice(division);
        }

        printOutResult();

    }

    private boolean isNumberSelected(int tempSelection, Integer[] selection)
    {
        for (Integer num : selection)
        {
            if (num!=null && tempSelection == num) return true;
        }

        return false;
    }


    public int retrieveNumberFromPi(int start)
    {
        Integer number2 = Integer.valueOf(MathUtil.PI_FRACTION.substring(start-1, start + 1));
        Integer number1 = Integer.valueOf(MathUtil.PI_FRACTION.substring(start-1, start));

        if (number2 > 0 && number2 <= PowerBallDraw.MAX_NUM)
        {
            return number2;
        }

        if (number1 > 0 && number1 <= PowerBallDraw.MAX_NUM)
        {
            return number1;
        }

        return 0;

    }

    public void trainPowerHitWithPrime(List<PowerBallDraw> powerBallDraws)
    {
        reset();

        System.out.println("Power Ball Hit PI with Prime:");

        for (PowerBallDraw draw : powerBallDraws)
        {
            Integer[] selection = new Integer[PowerBallDraw.NUM_OF_BALL];

            int tempSelection;

            for (int i = 0; i < PowerBallDraw.NUM_OF_BALL; i++)
            {
                try
                {
                    int prime = MathUtil.getPrime(draw.getNum(i+1));
                    tempSelection = retrieveNumberFromPi(prime);
                    tempSelection = isNumberSelected(tempSelection, selection) ? 0 : tempSelection;
                    selection[i] = tempSelection;
                }
                catch (NotFoundException e)
                {
                    selection[i] = 0;
                }

            }

            double division = draw.checkWinPowerHit(selection);

            accumulateWinPrice(division);
        }

        printOutResult();

    }

    public void trainPowerHitWithPrimeAcc(List<PowerBallDraw> powerBallDraws)
    {
        reset();

        System.out.println("Power Ball Hit PI with Prime:");

        for (PowerBallDraw draw : powerBallDraws)
        {
            Integer[] selection = new Integer[PowerBallDraw.NUM_OF_BALL];

            int tempSelection;
            int sum= 0;
            for (int i = 0; i < PowerBallDraw.NUM_OF_BALL; i++)
            {
                try
                {
                    int prime = MathUtil.getPrime(draw.getNum(i+1));
                    sum += prime;
                    tempSelection = retrieveNumberFromPi(sum);
                    tempSelection = isNumberSelected(tempSelection, selection) ? 0 : tempSelection;
                    selection[i] = tempSelection;
                }
                catch (NotFoundException e)
                {
                    selection[i] = 0;
                }

            }

            double division = draw.checkWinPowerHit(selection);

            accumulateWinPrice(division);
        }

        printOutResult();

    }

    public void trainPowerHitPrime(List<PowerBallDraw> powerBallDraws)
    {
        System.out.println("Power Ball Hit Prime:");

            for (int y = -10000; y <= 10000; y++)
            {
                for (int x = 1; x <= 10000; x++)
                {

                    reset();

                    for (PowerBallDraw draw : powerBallDraws)
                    {
                        Integer[] selection = new Integer[PowerBallDraw.NUM_OF_BALL];

                        int tempSelection;
                        for (int i = 0; i < PowerBallDraw.NUM_OF_BALL; i++)
                        {
                            try
                            {
                                int prime = MathUtil.getPrime(draw.getNum(i + 1));
                                tempSelection =Math.abs ((prime * x + y) % PowerBallDraw.MAX_NUM);
                                selection[i] = tempSelection;
                            } catch (NotFoundException e)
                            {
                                selection[i] = 0;
                            }

                        }

                        double division = draw.checkWinPowerHit(selection);

                        accumulateWinPrice(division);
                    }

                    if ((1.0 * win / total) > 0.05 && winNum>20)
                    {
                        System.out.println("Power Ball Hit Prime:" + x + "|" + y);
                        printOutResult();
                    }
                }
            }

    }
}
