import analyser.powerball.PowerBallPiTrainer;
import domain.draw.PowerBallDraw;
import domain.draw.PowerBallResult;
import util.MathUtil;
import util.exception.NotFoundException;

import java.util.Date;

/**
 * Created by Luke on 19/09/2014.
 */
public class Test
{
    public static void main(String[] args) throws NotFoundException
    {


    }

    void temp1()
    {
        PowerBallDraw draw = new PowerBallDraw();
        draw.setNum1(1);
        draw.setNum2(2);
        draw.setNum3(3);
        draw.setNum4(4);
        draw.setNum5(5);
        draw.setNum6(6);
        Integer[] selection = {7, 8, 9, 10, 11, 12};
        PowerBallResult result = draw.checkWinPowerHit(selection);

        System.out.println(result.getDivision());
        System.out.println(result.getDiffer());

    }

    void temp() throws NotFoundException
    {
        PowerBallPiTrainer trainer = new PowerBallPiTrainer();
        int number = trainer.retrieveNumberFromPi(16);
        System.out.println(number);
        System.out.println(MathUtil.getPrime(16));
        System.out.println(MathUtil.PI_FRACTION.substring(16-1));

        System.out.println(-46%45);

        System.out.println((new Date()).toString());
    }

    int IndexOfLastOccurence(String A, String B){
        String aReverse = new StringBuilder(A).reverse().toString();
        String bReverse = new StringBuilder(B).reverse().toString();
        int index = aReverse.indexOf(bReverse);
        return index!=-1?aReverse.length()-index-bReverse.length():index;

    }

    int sum(int upperLimit)
    {
        int three = (upperLimit-1)/3;
        int five = (upperLimit-1)/5;
        int fifteen = upperLimit/15;
        return (three+1)*three/2*3+(five+1)*five/2*5-(fifteen+1)*fifteen/2*3*5;

    }
}
