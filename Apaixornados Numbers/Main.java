/**
 * problem: Apaixornados Numbers
 * beecrowd id: 2290
 * date: 28/07/2023
 * author: Leandro Guido Lorenzini Santos
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int n; // quantity of numbers

    public static void printNumbersWithoutPair (String numbers) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(numbers, " ");
        Long [] array = new Long[n];
        Long aux = 0L;
        Long xor = Long.parseLong(tokenizer.nextToken());
        array[0] = xor;
        int i = 1;
        while (tokenizer.hasMoreTokens()) {
            aux = Long.parseLong(tokenizer.nextToken());
            array[i++] = aux;
            xor = xor ^ aux;
        } // end for
        
        long right_most_set_bit = xor & ~ (xor -1);

        long a = 0, b = 0;
        for (i = 0; i < n ; i++) {
            if((array[i] & right_most_set_bit)!=0)
                a ^= array[i];
            else
                b ^= array[i];
        } // end if
        if(a < b) System.out.println(a + " " + b);
        else System.out.println(b + " " + a);
    } // end printNumbersWithoutPair ()

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new FileReader("input.in"));
        String numbersListAsString = "";
        String firstInput = "";
        while ( (firstInput = reader.readLine()) != null ) {
            n = Integer.parseInt(firstInput); // get number quantity
            numbersListAsString = reader.readLine(); // read numbers
            if(numbersListAsString == null) break;
            printNumbersWithoutPair(numbersListAsString);
        } // end while
    } // end main ()
} // end class Main