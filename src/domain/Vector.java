package domain;

import domain.exception.VectorException;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 5/02/2015
 * Time: 12:04 PM
 */
public class Vector
{
    private Integer[] dimensions;

    public Vector(Integer[] dimensions)
    {
        this.dimensions = dimensions;
    }

    public Double getLength()
    {
        Integer sum =0;
        for (Integer dimension : dimensions)
        {
            sum += dimension*dimension;
        }

        return Math.sqrt(sum);
    }

    public Vector minus(Vector other) throws VectorException
    {
        if (this.dimensions.length != other.dimensions.length) throw new VectorException("different dimension");

        Integer[] results = new Integer[this.dimensions.length];
        for (int i = 0; i < results.length; i++)
        {
            results[i] = this.dimensions[i] - other.dimensions[i];
        }

        return new Vector(results);
    }

    public Double dotProduct(Vector other) throws VectorException
    {
        if (this.dimensions.length != other.dimensions.length) throw new VectorException("different dimension");

        Integer sum = 0;
        for (int i = 0; i < this.dimensions.length; i++)
        {
           sum +=this.dimensions[i]*other.dimensions[i];
        }

        return Double.valueOf(sum);

    }
}
