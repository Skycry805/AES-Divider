import java.util.ArrayList;
import java.util.List;

public class Polynomial
{
    private List <Integer> polynom;
    Polynomial (List<Integer> polynom )
    {
        this.polynom = polynom;
    }
    public Polynomial [] divide(Polynomial divisor)
    {
        List <Integer> quotient = new ArrayList<>();
        List <Integer> remainder = new ArrayList<>();
        List <Integer> div = divisor.getPolynom();


        int zahl = (polynom.size()-1) - (div.size()-1);

        for (int i=1; i <= polynom.size()-1; i++)
        {
            if (div.size()-polynom.size()>=0)
            {
                throw new IllegalArgumentException();
            } else if (isNull(divisor))
            {
                throw new IllegalArgumentException();
            } else
            {
                // Unterschied von Divisor und divident bestimmen
                int x = polynom.get(polynom.size()-i)/(div.get(1));
                // Das Ergebnis bauen
                quotient.add(0,x);
                // Das Poylnom anpassen
                int y = div.get(0)*quotient.get(0);
                // Abfrage ob Divisor + oder - hat
                if(div.get(1) < 0) {
                    polynom.set((polynom.size()-(i+1)), polynom.get(polynom.size()-(i+1))+(y*quotient.get(i-1)));
                } else if(div.get(1) > 0)
                {
                    polynom.set((polynom.size()-(i+1)), polynom.get(polynom.size()-(i+1))-(y*quotient.get(i-1)));
                }
            }
        }
        // Die Ausgabe bauen
        remainder.add(0,polynom.get(0));
        Polynomial quo = new Polynomial(quotient);
        Polynomial rem = new Polynomial(remainder);
        return new Polynomial[]{quo, rem};



    }
    public String toString ()
    {
        StringBuilder build = new StringBuilder();

        if (polynom.get(0) != 0)
        {
            for (int i=0;i<polynom.size();i++)
            {
                if (i==0)
                {
                    build.append(polynom.get(i));
                }
                else
                {
                    build.insert(0, polynom.get(i) + "x^" + i + " + ");
                }
            }
        }
        return build.toString();
    }

    public List<Integer> getPolynom()
    {
        return polynom;
    }

    private boolean isNull(Polynomial input)
    {
        for (int i=0;i<input.getPolynom().size();i++)
        {
            if (input.getPolynom().get(i) != 0)
            {
                return false;
            }
        }
        return true;
    }
}
