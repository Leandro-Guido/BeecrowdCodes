/**
 * problem: Event
 * beecrowd id: 2172
 * date: 25/07/2023
 * author: Leandro Guido Lorenzini Santos
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int increase = 0;
        int exp = 0;
        int newExp = 0;
        String input;
        do {
            input = reader.readLine();
            increase = Integer.parseInt(input.substring(0, 1));
            newExp = exp = Integer.parseInt(input.substring(2, input.length()));
            if( (increase ) != 0) {
                for (int i = 1; i < increase; i++) newExp = newExp + exp;
                System.out.println(newExp);
            } else break;
        } while(true);
    } // end main ()
} // end class Main