package domain;

import java.util.Arrays;

/**
 * Created by Luke on 13/05/2014.
 */
public class PowerBallDraw extends Draw
{
    public static int MAX_NUM = 40;
    public static int MAX_POWER_BALL_NUM = 20;
    public static int NUM_OF_BALL = 6;

    private Integer num1;
    private Integer num2;
    private Integer num3;
    private Integer num4;
    private Integer num5;
    private Integer num6;
    private Integer powerBall;

    public int checkWinPowerHit(Integer[] selections)
    {
        Integer[] thisDraw = new Integer[NUM_OF_BALL];

        thisDraw[0] = num1;
        thisDraw[1] = num2;
        thisDraw[2] = num3;
        thisDraw[3] = num4;
        thisDraw[4] = num5;
        thisDraw[5] = num6;

        Integer[] testedDraw = selections;

        Arrays.sort(thisDraw);
        Arrays.sort(testedDraw);

        int count = 0;

        for (int j = 0, i = 0; i < NUM_OF_BALL && j < NUM_OF_BALL; )
        {
            if (thisDraw[i] < testedDraw[j])
            {
                i++;
            }
            else if (thisDraw[i] == testedDraw[j])
            {
                count++;
                i++;
                j++;
            }
            else if (thisDraw[i] > testedDraw[j])
            {
                j++;
            }
        }


        boolean powerBallCheck = true;


        if (count == 2 && powerBallCheck)
        {
            return 1;//division 8
        }
        else if (count == 4)
        {
            return 2;//division 7
        }
        else if (count == 3 && powerBallCheck)
        {
            return 3; //division 6
        }
        else if (count == 4 && powerBallCheck)
        {
            return 5; //division 5
        }
        else if (count == 5 && !powerBallCheck)
        {
            return 10; //division 4
        }
        else if (count == 5 && powerBallCheck)
        {
            return 500; //division 3
        }
        else if (count == 6 && !powerBallCheck)
        {
            return 3500; //division 2
        }
        else if (count == 6 && powerBallCheck)
        {
            return 500000; //division 1
        }
        return 0;
    }

    public int checkWin(PowerBallDraw draw)
    {
        Integer[] thisDraw = new Integer[NUM_OF_BALL];

        thisDraw[0] = num1;
        thisDraw[1] = num2;
        thisDraw[2] = num3;
        thisDraw[3] = num4;
        thisDraw[4] = num5;
        thisDraw[5] = num6;

        Integer[] testedDraw = new Integer[NUM_OF_BALL];
        testedDraw[0] = draw.getNum1();
        testedDraw[1] = draw.getNum2();
        testedDraw[2] = draw.getNum3();
        testedDraw[3] = draw.getNum4();
        testedDraw[4] = draw.getNum5();
        testedDraw[5] = draw.getNum6();

        Arrays.sort(thisDraw);
        Arrays.sort(testedDraw);

        int count = 0;

        for (int j = 0, i = 0; i < NUM_OF_BALL && j < NUM_OF_BALL; )
        {
            if (thisDraw[i] < testedDraw[j])
            {
                i++;
            }
            else if (thisDraw[i] == testedDraw[j])
            {
                count++;
                i++;
                j++;
            }
            else if (thisDraw[i] > testedDraw[j])
            {
                j++;
            }
        }

        int division=0;

        boolean powerBallCheck = powerBall == draw.powerBall;


        if (count == 2 && powerBallCheck)
        {
            division= 1;//division 8
        }
        else if (count == 4)
        {
            division= 2;//division 7
        }
        else if (count == 3 && powerBallCheck)
        {
            division= 3; //division 6
        }
        else if (count == 4 && powerBallCheck)
        {
            division= 5; //division 5
        }
        else if (count == 5 && !powerBallCheck)
        {
            division= 10; //division 4
        }
        else if (count == 5 && powerBallCheck)
        {
            division= 500; //division 3
        }
        else if (count == 6 && !powerBallCheck)
        {
            division= 3500; //division 2
        }
        else if (count == 6 && powerBallCheck)
        {
            division= 500000; //division 1
        }
        return division/MAX_POWER_BALL_NUM;

    }

    @Override
    public String toString()
    {
        return "PowerBallDraw{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", num3=" + num3 +
                ", num4=" + num4 +
                ", num5=" + num5 +
                ", num6=" + num6 +
                ", powerBall=" + powerBall +
                '}';
    }

    public Integer getNum1()
    {
        return num1;
    }

    public void setNum1(Integer num1)
    {
        this.num1 = num1;
    }

    public Integer getNum2()
    {
        return num2;
    }

    public void setNum2(Integer num2)
    {
        this.num2 = num2;
    }

    public Integer getNum3()
    {
        return num3;
    }

    public void setNum3(Integer num3)
    {
        this.num3 = num3;
    }

    public Integer getNum4()
    {
        return num4;
    }

    public void setNum4(Integer num4)
    {
        this.num4 = num4;
    }

    public Integer getNum5()
    {
        return num5;
    }

    public void setNum5(Integer num5)
    {
        this.num5 = num5;
    }

    public Integer getNum6()
    {
        return num6;
    }

    public void setNum6(Integer num6)
    {
        this.num6 = num6;
    }

    public Integer getPowerBall()
    {
        return powerBall;
    }

    public void setPowerBall(Integer powerBall)
    {
        this.powerBall = powerBall;
    }
}
