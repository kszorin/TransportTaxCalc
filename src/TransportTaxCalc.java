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

    public TransportTaxCalc(int power, int year) {
        this.power = power;
        this.year = year;
    }

    public float calculate() {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(cal.YEAR);

        if (power < 100) {
            return power*POWER_0_100;
        }

        if ((power > 100) && (power <= 150)) {
            return power * POWER_100_150;
        }

        if ((power > 150) && (power <= 200)) {
            if ((currentYear - year) <=5)
                return power * POWER_150_200[0];
            else if (((currentYear - year) > 5) && ((currentYear - year) <= 10))
                return power * POWER_150_200[1];
            else
                return power * POWER_150_200[2];
        }


        return 0;
    }
}
