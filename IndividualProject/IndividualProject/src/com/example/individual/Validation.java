package com.example.individual;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Validation {

    public static final int INVALID = -1;
    public static final int VISA = 0;
    public static final int MASTERCARD = 1;
    public static final int AMERICAN_EXPRESS = 2;
    public static final int DISCOVER = 3;

    private static final String[] cardNames = { "Visa", "Mastercard",
            "American Express", "Discover" };

    /**
     * Valid a Credit Card number
     */
    public static boolean validCC(String number){
        int CardID;
        if ((CardID = getCardID(number)) != -1){
            return validCCNumber(number);}
        return false;
    }

    /**
     * Get the Card type returns the credit card type INVALID = -1; VISA = 0;
     * MASTERCARD = 1; AMERICAN_EXPRESS = 2; DISCOVER = 3
     */
    public static int getCardID(String number) {
        int valid = INVALID;

        String digit1 = number.substring(0, 1);
        String digit2 = number.substring(0, 2);
        String digit3 = number.substring(0, 3);
        String digit4 = number.substring(0, 4);

        if (isNumber(number)) {
            /*
             * ----* VISA prefix=4* ---- length=13 or 16 (can be 15 too!?!
             * maybe)
             */
            if (digit1.equals("4")) {
                if (number.length() == 13 || number.length() == 16)
                    valid = VISA;
            }
            /*
             * ----------* MASTERCARD prefix= 51 ... 55* ---------- length= 16
             */
            else if (digit2.compareTo("51") >= 0 && digit2.compareTo("55") <= 0) {
                if (number.length() == 16)
                    valid = MASTERCARD;
            }

            /*
             * ----* DISCOVER card prefix = 60* -------- lenght = 16* left as an
             * exercise ...
             */
            else if (digit4.equals("6011")) {
                if (number.length() == 16)
                    valid = DISCOVER;
            }
            /*
             * ----* AMEX prefix=34 or 37* ---- length=15
             */
            else if (digit2.equals("34") || digit2.equals("37")) {
                if (number.length() == 15)
                    valid = AMERICAN_EXPRESS;
            }

        }

        return valid;

    }

    public static boolean isNumber(String n) {
        try {
            double d = Double.valueOf(n);
            return true;
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static String getCardName(int id) {
        return (id > -1 && id < cardNames.length ? cardNames[id] : "");
    }

    public static boolean validCCNumber(String n) {
        try {
            /*
             * * known as the LUHN Formula (mod10)
             */
            int j = n.length();

            String[] s1 = new String[j];
            for (int i = 0; i < n.length(); i++)
                s1[i] = "" + n.charAt(i);

            int checksum = 0;

            for (int i = s1.length - 1; i >= 0; i -= 2) {
                int k = 0;

                if (i > 0) {
                    k = Integer.valueOf(s1[i - 1]).intValue() * 2;
                    if (k > 9) {
                        String s = "" + k;
                        k = Integer.valueOf(s.substring(0, 1)).intValue()
                                + Integer.valueOf(s.substring(1)).intValue();
                    }
                    checksum += Integer.valueOf(s1[i]).intValue() + k;
                } else
                    checksum += Integer.valueOf(s1[0]).intValue();
            }
            return ((checksum % 10) == 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String args[]) throws Exception {

        File f= new File("C:/Users/Checkout/Downloads/input_file.json");
        String Name = f.getName();
        Parser parser=ParserFactory.getParser(Name);
        ArrayList<String> aCardArr = parser.parse("C:/Users/Checkout/Downloads/input_file.json");
        System.out.println("Card number : "+ aCardArr);
        ArrayList<String> str1= new ArrayList<>();
        for (String aCard: aCardArr
             ) {
            if(!aCard.equals("")) {
                int cardType = getCardID(aCard);
                CreditCard card = null;
                CardFactory cardFactory = new CardFactory();

                if ((validCC(aCard))) {

                    card = cardFactory.getCard(cardType, aCard);
                    System.out.println("This is a " + getCardName(cardType) + " card. "
                            + card.toString());
                    str1.add(aCard+","+ cardType);


                }

                else{
                    System.out.println("This card is invalid or unsupported!");
                if(getCardName(cardType).equals("")){
                    str1.add(aCard+","+ "This card is invalid or unsupported!");
                }
                else{
                    str1.add(aCard+","+ getCardName(cardType));}}

            }
            }
        if(Name.endsWith(".csv"))
            parser.write("C:/Users/Checkout/Downloads/output.csv",str1);
        else if(Name.endsWith(".xml"))
            parser.write("C:/Users/Checkout/Downloads/output.xml",str1);
        else
            parser.write("C:/Users/Checkout/Downloads/output.json",str1);

    }
}
