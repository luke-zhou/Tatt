package analyser;

import java.util.Comparator;

/**
 * Created by Luke on 23/08/15.
 */
public class TrainResult implements Comparable<TrainResult>
{
    private int number;
    private double frequency;

    public TrainResult(int number, double frequency)
    {
        this.number = number;
        this.frequency = frequency;
    }

    public int getNumber()
    {
        return number;
    }

    public double getFrequency()
    {
        return frequency;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainResult that = (TrainResult) o;

        if (Double.compare(that.frequency, frequency) != 0) return false;
        if (number != that.number) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = number;
        temp = Double.doubleToLongBits(frequency);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(TrainResult trainResult)
    {
        //reverse order
        if (this.frequency==trainResult.frequency) return 0;

        return -1*(this.frequency>trainResult.frequency?1:-1);
    }

    @Override
    public String toString()
    {
        return number+":"+Math.round(frequency*100);
    }
}
