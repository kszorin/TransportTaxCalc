import java.util.Calendar;

/**
 * Created by kszorin on 19.01.2017.
 */
public class TransportTaxCalc {
    public static final int POWER_0_100 = 6;
    public static final int POWER_100_150 = 10;
    public static final float POWER_150_200[] = {30, 22.5f, 15};
    public static final int POWER_200_250[] = {60, 45, 30};
    public static final float POWER_250[] = {150, 112.5f, 75};

    private int power;
    private int year;

    public TransportTaxCalc (int year, int power) {
        this.year = year;
        this.power = power;
    }

    public float calculate() {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(cal.YEAR);

        //мощность < 100
        if (power < 100) {
            return power*POWER_0_100;
        }

        //100 < мощность < 150
        if ((power > 100) && (power <= 150)) {
            return power * POWER_100_150;
        }

        //150 < мощность < 200
        if ((power > 150) && (power <= 200)) {
            //год выпуска <= 5
            if ((currentYear - year) <=5)
                return power * POWER_150_200[0];
            //5 <год выпуска <= 10
            else if (((currentYear - year) > 5) && ((currentYear - year) <= 10))
                return power * POWER_150_200[1];
            //10 < год выпуска
            else
                return power * POWER_150_200[2];
        }

        //200 < мощность < 250
        if ((power > 200) && (power <= 250)) {
            //год выпуска <= 5
            if ((currentYear - year) <=5)
                return power * POWER_200_250[0];
            //5 <год выпуска <= 10
            else if (((currentYear - year) > 5) && ((currentYear - year) <= 10))
                return power * POWER_200_250[1];
            //10 < год выпуска
            else
                return power * POWER_200_250[2];
        }

        //250 < мощность
        if (power > 250) {
            //год выпуска <= 5
            if ((currentYear - year) <=5)
                return power * POWER_250[0];
            //5 <год выпуска <= 10
            else if (((currentYear - year) > 5) && ((currentYear - year) <= 10))
                return power * POWER_250[1];
            //10 < год выпуска
            else
                return power * POWER_250[2];
        }
        return 0;
    }
}
