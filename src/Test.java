import util.MathUtil;

/**
 * Created by Luke on 19/09/2014.
 */
public class Test
{
    public static void main(String[] args)
    {
        System.out.println(MathUtil.getPIFraction());


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
