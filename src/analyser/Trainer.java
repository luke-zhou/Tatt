package analyser;

import domain.Draw;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 3/02/2015
 * Time: 2:42 PM
 */
public interface Trainer
{
    public void train(List<? extends Draw> draws);
}
