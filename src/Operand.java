import java.util.Objects;

public class Operand {
    private final String sentence;
    private String numerator;
    private String denominator;

    private int numeratorValue;
    private int denominatorValue;

    public int getDenominatorValue() {
        return denominatorValue;
    }

    public void setDenominatorValue(int denominatorValue) {
        this.denominatorValue = denominatorValue;
    }

    public int getNumeratorValue() {
        return numeratorValue;
    }

    public void setNumeratorValue(int numeratorValue) {
        this.numeratorValue = numeratorValue;
    }

    public Operand(String _sentence) {
        sentence = _sentence;
        try {
            parseSentence();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void parseSentence() throws Exception {
        String[] words = sentence.split(" ");

        if (words.length < 2 || words[0].isEmpty()) {
            throw new Exception("Operando invalido");
        }

        //definir numerador y denominador

        numerator = words[0];
        denominator = words[1];

        // obtener valor numerico de numerador

        String numeratorFirstMatch = "";
        for (String match : numeratorMatchesSmall) {
            if (numerator.equals(match)) {
                numeratorFirstMatch = match;
            }
        }

        if (numeratorFirstMatch.isEmpty()) {

            // valores mayores a 15

            String dec = "";
            for (String match : numberMatchesDec) {
                if (numerator.contains(match)) {
                    dec = match;
                }
            }

            throw new Exception("Unimplemented in values higher than 15");

        } else {
            // valores menores a 16
            switch (numeratorFirstMatch) {
                case "un":
                    numeratorValue = 1;
                    break;
                case "dos":
                    numeratorValue = 2;
                    break;
                case "tres":
                    numeratorValue = 3;
                    break;
                case "cuatro":
                    numeratorValue = 4;
                    break;
                case "cinco":
                    numeratorValue = 5;
                    break;
                case "seis":
                    numeratorValue = 6;
                    break;
                case "siete":
                    numeratorValue = 7;
                    break;
                case "ocho":
                    numeratorValue = 8;
                    break;
                case "nueve":
                    numeratorValue = 9;
                    break;
                case "diez":
                    numeratorValue = 10;
                    break;
                case "once":
                    numeratorValue = 11;
                    break;
                case "doce":
                    numeratorValue = 12;
                    break;
                case "trece":
                    numeratorValue = 13;
                    break;
                case "catorce":
                    numeratorValue = 14;
                    break;
                case "quince":
                    numeratorValue = 15;
                    break;
            }
        }


        if(numeratorValue == 1) {
            denominator = denominator + "s";
        }

        String denominatorFirstMatch = "";
        for(String match: denominatorMatchesSmall) {
            if(denominator.equals(match)) {
                denominatorFirstMatch = match;
            }
        }
        if(denominatorFirstMatch.isEmpty()) {
            throw new Exception("Unimplemented denominator values higher than 15");
        }
        else {
            switch (denominatorFirstMatch) {
                case "enteros":
                    denominatorValue = 1;
                    break;
                case "medios":
                    denominatorValue = 2;
                    break;
                case "tercios":
                    denominatorValue = 3;
                    break;
                case "cuartos":
                    denominatorValue = 4;
                    break;
                case "quintos":
                    denominatorValue = 5;
                    break;
                case "sextos":
                    denominatorValue = 6;
                    break;
                case "septimos":
                    denominatorValue = 7;
                    break;
                case "octavos":
                    denominatorValue = 8;
                    break;
                case "novenos":
                    denominatorValue = 9;
                    break;
                case "decimos":
                    denominatorValue = 10;
                    break;
                case "onceavos":
                    denominatorValue = 11;
                    break;
                case "doceavos":
                    denominatorValue = 12;
                    break;
                case "treceavos":
                    denominatorValue = 13;
                    break;
                case "catorceavos":
                    denominatorValue =14;
                    break;
                case "quinceavos":
                    denominatorValue = 15;
                    break;
            }
        }
    }

    private String[] numberMatchesDec = new String[]{
            "diesi",
            "veinti",
            "treintai",
            "cuarentai",
            "cincuentai",
            "sesentai",
            "setentai",
            "ochentai",
            "noventai",
    };


    private String[] numeratorMatchesSmall = new String[]{
            "un",
            "dos",
            "tres",
            "cuatro",
            "cinco",
            "seis",
            "siete",
            "ocho",
            "nueve",
            "diez",
            "once",
            "doce",
            "trece",
            "catorce",
            "quince"
    };

    private String[] denominatorMatchesSmall = new String[] {
            "enteros",
            "medios",
            "tercios",
            "cuartos",
            "quintos",
            "sextos",
            "septimos",
            "octavos",
            "novenos",
            "decimos",
            "onceavos",
            "doceavos",
            "treceavos",
            "catorceavos",
            "quinceavos",
    };
}
