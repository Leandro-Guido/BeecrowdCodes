/**
 * problem: Lucky Numbers
 * beecrowd id: 2855
 * date: 25/07/2023
 * author: Leandro Guido Lorenzini Santos
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String buffer;
    public static int bufferIndex = 0;

    public static void newBufferFromInput () throws IOException {
        buffer = reader.readLine();
        bufferIndex = 0;
    } // end newBufferFromInput ()

    public static Integer nextIntInBuffer () {
        if(bufferIndex < buffer.length()) {
            char c;
            StringBuilder number = new StringBuilder(7);
            do {
                c = buffer.charAt(bufferIndex++);
                if (Character.isDigit(c)) {
                    number.append(c);
                } // end if
            } while (bufferIndex < buffer.length() && Character.isDigit(c));
            return Integer.parseInt(number.toString());
        } // end if
        return null;
    } // end nextIntInBuffer ()

    public static int getPosOfNumber (int number, int size) throws IOException {
        for (int i = 1; i <= size; i++) {
            if(nextIntInBuffer() == number) {
                return i;
            } // end if
        } // end for
        return -1;
    } // end getPosOfNumber ()

    public static boolean isLuckyNumber (int number, int pos) {
        int counter = 2;
        while (pos > counter - 1) {
            if(pos % counter == 0) return false;
            pos = pos - (pos/counter);
            counter++;
        } // end while
        return true;
    } // end isLuckyNumber ()

    public static void main ( String args[] ) throws IOException {
        String input = "";
        while((input = reader.readLine()) != null) {
            int numbersQuantity = Integer.parseInt(input);
            newBufferFromInput();
            int number = Integer.parseInt(reader.readLine());
            int pos = getPosOfNumber(number, numbersQuantity);
            System.out.println(isLuckyNumber(number, pos) ? "Y" : "N");
        } // end while
    } // end main ()
} // end class Main