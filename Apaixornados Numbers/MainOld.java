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
import java.util.HashSet;
import java.util.StringTokenizer;

class MainOld {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void printApaxornadosNumbers (String numbers) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(numbers, " ");
        HashSet<Long> set = new HashSet<Long>();
        Long aux = 0L;
        while (tokenizer.hasMoreTokens()) {
            aux = Long.parseLong(tokenizer.nextToken());
            if(!set.add(aux)) {
                set.remove(aux);
            } // end if
        } // end for
        Long [] pair = new Long [2];
        set.toArray(pair);
        if(pair[0] < pair[1]) {
            System.out.println(pair[0] + " " + pair[1]);
        } else {
            System.out.println(pair[1] + " " + pair[0]);
        } // end if
    } // end printApaxornadosNumbers ()

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new FileReader("input.in"));
        String numbersListAsString = "";
        while ( true ) {
            reader.readLine(); // skip not necessary input
            numbersListAsString = reader.readLine(); // read numbers
            if(numbersListAsString == null) break;
            printApaxornadosNumbers(numbersListAsString);
        } // end while
    } // end main ()
} // end class Main
