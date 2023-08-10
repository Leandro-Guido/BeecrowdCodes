import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * problem: Identifying Tea
 * beecrowd id: 2006
 * date: 28/07/2023
 * author: Leandro Guido Lorenzini Santos
 */

 class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input;
        while ( (input = reader.readLine()) != null) {
            char tea = input.charAt(0);
            input = reader.readLine();
            byte length = (byte) input.length();
            byte rightAnswers = 0;
            for (int i = 0; i < length; i+=2) {
                if(input.charAt(i) == tea) rightAnswers++;
            } // end for
            System.out.println(rightAnswers);
        } // end while
    } // end main
 } // end class Main