package domain.draw;

import domain.draw.Draw;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 27/02/2014
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class OZDraw extends Draw
{
    public static int MAX_NUM = 45;
    public static int NUM_OF_BALL = 7;

    private Integer num1;
    private Integer num2;
    private Integer num3;
    private Integer num4;
    private Integer num5;
    private Integer num6;
    private Integer num7;
    private Integer supply1;
    private Integer supply2;

    public int checkWin9(Integer[] nums)
    {
        int division1 = checkWin8(new Integer[]{nums[0],nums[1],nums[2],nums[3],nums[4],nums[5],nums[6],nums[7]});
        int division2 = checkWin8(new Integer[]{nums[0],nums[1],nums[2],nums[3],nums[4],nums[5],nums[6],nums[8]});
        int division3 = checkWin8(new Integer[]{nums[0],nums[1],nums[2],nums[3],nums[4],nums[5],nums[8],nums[7]});
        int division4 = checkWin8(new Integer[]{nums[0],nums[1],nums[2],nums[3],nums[4],nums[8],nums[6],nums[7]});
        int division5 = checkWin8(new Integer[]{nums[0],nums[1],nums[2],nums[3],nums[8],nums[5],nums[6],nums[7]});
        int division6 = checkWin8(new Integer[]{nums[0],nums[1],nums[2],nums[8],nums[4],nums[5],nums[6],nums[7]});
        int division7 = checkWin8(new Integer[]{nums[0],nums[1],nums[8],nums[3],nums[4],nums[5],nums[6],nums[7]});
        int division8 = checkWin8(new Integer[]{nums[0],nums[8],nums[2],nums[3],nums[4],nums[5],nums[6],nums[7]});
        int division9 = checkWin8(new Integer[]{nums[8],nums[1],nums[2],nums[3],nums[4],nums[5],nums[6],nums[7]});

        return division1+division2+division3+division4+division5+division6+division7+division8+division9;

    }

    public int checkWin8(Integer[] nums)
    {
        int division1 = checkWin(new Integer[]{nums[0], nums[1], nums[2], nums[3], nums[4], nums[5], nums[6]});
        int division2 = checkWin(new Integer[]{nums[0], nums[1], nums[2], nums[3], nums[4], nums[5], nums[7]});
        int division3 = checkWin(new Integer[]{nums[0], nums[1], nums[2], nums[3], nums[4], nums[7], nums[6]});
        int division4 = checkWin(new Integer[]{nums[0], nums[1], nums[2], nums[3], nums[7], nums[5], nums[6]});
        int division5 = checkWin(new Integer[]{nums[0], nums[1], nums[2], nums[7], nums[4], nums[5], nums[6]});
        int division6 = checkWin(new Integer[]{nums[0], nums[1], nums[7], nums[3], nums[4], nums[5], nums[6]});
        int division7 = checkWin(new Integer[]{nums[0], nums[7], nums[2], nums[3], nums[4], nums[5], nums[6]});
        int division8 = checkWin(new Integer[]{nums[7], nums[1], nums[2], nums[3], nums[4], nums[5], nums[6]});

        return division1+division2+division3+division4+division5+division6+division7+division8;
    }

    public int checkWin(Integer[] nums)
    {
        Integer[] thisDraw = new Integer[7];
        thisDraw[0] = num1;
        thisDraw[1] = num2;
        thisDraw[2] = num3;
        thisDraw[3] = num4;
        thisDraw[4] = num5;
        thisDraw[5] = num6;
        thisDraw[6] = num7;

        Arrays.sort(thisDraw);
        Arrays.sort(nums);

        int count = 0;

        for (int j = 0, i = 0; i < 7 && j < 7; )
        {
            if (thisDraw[i] < nums[j])
            {
                i++;
            }
            else if (thisDraw[i] == nums[j])
            {
                count++;
                i++;
                j++;
            }
            else if (thisDraw[i] > nums[j])
            {
                j++;
            }
        }


        boolean supply = false;
        for (Integer i : nums)
        {
            if (i == supply1 || i == supply2)
            {
                supply = true;
            }
        }


        if (count == 3 && supply)
        {
            return 1;//division 7
        }
        else if (count == 4)
        {
            return 2;//division 6
        }
        else if (count == 5 && !supply)
        {
            return 4; //division 5
        }
        else if (count == 5 && supply)
        {
            return 28; //division 4
        }
        else if (count == 6 && !supply)
        {
            return 300; //division 3
        }
        else if (count == 6 && supply)
        {
            return 6000; //division 2
        }
        else if (count == 7)
        {
            return 1200000; //division 2
        }

        return 0;

    }

    @Override
    public String toString()
    {
        return "OZDraw{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", num3=" + num3 +
                ", num4=" + num4 +
                ", num5=" + num5 +
                ", num6=" + num6 +
                ", num7=" + num7 +
                ", supply1=" + supply1 +
                ", supply2=" + supply2 +
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

    public Integer getNum7()
    {
        return num7;
    }

    public void setNum7(Integer num7)
    {
        this.num7 = num7;
    }

    public Integer getSupply1()
    {
        return supply1;
    }

    public void setSupply1(Integer supply1)
    {
        this.supply1 = supply1;
    }

    public Integer getSupply2()
    {
        return supply2;
    }

    public void setSupply2(Integer supply2)
    {
        this.supply2 = supply2;
    }
}
