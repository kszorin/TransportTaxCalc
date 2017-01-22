import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kszorin on 19.01.2017.
 */
public class TransportTaxCalcTest {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int year, power;

        System.out.print ("Введите год выпуска авто: ");
        str = br.readLine();
        year = Integer.parseInt(str);

        System.out.print ("Введите мощность авто: ");
        str = br.readLine();
        power = Integer.parseInt(str);

        TransportTaxCalc calc = new TransportTaxCalc(year, power);
        System.out.printf ("Сумма налога составит %.2f руб: ", calc.calculate());
    }
}
