package util;

import au.com.bytecode.opencsv.CSVReader;
import domain.draw.OZDraw;
import domain.draw.PowerBallDraw;

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
    public static List<OZDraw> loadOZData(String fileName)
    {
        List<OZDraw> OZDraws = new ArrayList<OZDraw>();
        try
        {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            String [] nextLine;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                OZDraw OZDraw = new OZDraw();
                OZDraw.setId(Integer.valueOf(nextLine[0]));
                OZDraw.setDate(sdf.parse(nextLine[1]));
                OZDraw.setNum1(Integer.valueOf(nextLine[2]));
                OZDraw.setNum2(Integer.valueOf(nextLine[3]));
                OZDraw.setNum3(Integer.valueOf(nextLine[4]));
                OZDraw.setNum4(Integer.valueOf(nextLine[5]));
                OZDraw.setNum5(Integer.valueOf(nextLine[6]));
                OZDraw.setNum6(Integer.valueOf(nextLine[7]));
                OZDraw.setNum7(Integer.valueOf(nextLine[8]));
                OZDraw.setSupply1(Integer.valueOf(nextLine[9]));
                OZDraw.setSupply2(Integer.valueOf(nextLine[10]));

                OZDraws.add(OZDraw);
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

        return OZDraws;
    }

    public static List<PowerBallDraw> loadPowerData(String fileName)
    {
        List<PowerBallDraw> draws = new ArrayList<PowerBallDraw>();
        try
        {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            String [] nextLine;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            reader.readNext();
            while ((nextLine = reader.readNext()) != null)
            {
                try
                {
                    PowerBallDraw draw = new PowerBallDraw();
                    draw.setId(Integer.valueOf(nextLine[0]));
                    draw.setDate(sdf.parse(nextLine[1]));
                    draw.setNum1(Integer.valueOf(nextLine[2]));
                    draw.setNum2(Integer.valueOf(nextLine[3]));
                    draw.setNum3(Integer.valueOf(nextLine[4]));
                    draw.setNum4(Integer.valueOf(nextLine[5]));
                    draw.setNum5(Integer.valueOf(nextLine[6]));
                    draw.setNum6(Integer.valueOf(nextLine[7]));
                    draw.setPowerBall(Integer.valueOf(nextLine[8]));
                    draws.add(draw);
                } catch (Exception e)
                {

                }
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return draws;
    }
}
