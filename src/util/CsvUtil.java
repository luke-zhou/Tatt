package util;

import au.com.bytecode.opencsv.CSVReader;
import domain.Draw;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 28/02/2014
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class CsvUtil
{
    public static List<Draw> loadData(String fileName)
    {
        List<Draw> draws = new ArrayList<Draw>();
        try
        {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            String [] nextLine;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Draw draw = new Draw();
                draw.setId(Integer.valueOf(nextLine[0]));
                draw.setDate(sdf.parse(nextLine[1]));
                draw.setNum1(Integer.valueOf(nextLine[2]));
                draw.setNum2(Integer.valueOf(nextLine[3]));
                draw.setNum3(Integer.valueOf(nextLine[4]));
                draw.setNum4(Integer.valueOf(nextLine[5]));
                draw.setNum5(Integer.valueOf(nextLine[6]));
                draw.setNum6(Integer.valueOf(nextLine[7]));
                draw.setNum7(Integer.valueOf(nextLine[8]));
                draw.setSupply1(Integer.valueOf(nextLine[9]));
                draw.setSupply2(Integer.valueOf(nextLine[10]));

                draws.add(draw);
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ParseException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return draws;
    }
}
