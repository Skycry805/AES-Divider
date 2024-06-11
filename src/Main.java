import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        Polynomial p1 = new Polynomial(Arrays.asList(0, 0, -12, 1)); // 0 + 0x^2 -12x + x^3
        Polynomial p2 = new Polynomial(Arrays.asList(-10, 1)); // -10 + x
        Polynomial[] result = p1.divide(p2);

        System.out.println(result[0].toString());
        System.out.println(result[1].toString());
    }
}