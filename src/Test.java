import analyser.powerball.PowerBallPiTrainer;
import util.MathUtil;
import util.exception.NotFoundException;

/**
 * Created by Luke on 19/09/2014.
 */
public class Test
{
    public static void main(String[] args) throws NotFoundException
    {
        PowerBallPiTrainer trainer = new PowerBallPiTrainer();
        int number = trainer.retrieveNumberFromPi(16);
        System.out.println(number);
        System.out.println(MathUtil.getPrime(16));
        System.out.println(MathUtil.PI_FRACTION.substring(16-1));


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
