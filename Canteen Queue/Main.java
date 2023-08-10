/**
 * problem: Canteen Queue
 * beecrowd id: 1548
 * date: 25/07/2023
 * author: Leandro Guido Lorenzini Santos
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class IntegerCompare implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    } // end compare ()
} // end class IntegerCompare

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static int getNotReorderedQuantity (int numberOfStudents) {
        int notReorderQuantity = 0;
        int grade = 0;
        PriorityQueue<Integer> queueOrdered = new PriorityQueue<Integer>(11, new IntegerCompare());
        Integer [] queueOriginal = new Integer[numberOfStudents];

        // read queue
        for (int i = 0; i < numberOfStudents; i++) {
            grade = Integer.parseInt(sc.next());
            queueOrdered.add(grade);
            queueOriginal[i] = grade;
        } // end for

        // compare queue
        for (int i = 0; i < numberOfStudents; i++) {
            grade = queueOrdered.remove();
            if(queueOriginal[i] == grade) {
                notReorderQuantity++;
            } // end if
        } // end for

        return notReorderQuantity;
        // return notReordererQuantity;
    } // end getNotReorderedQuantity ()

    public static void queuesSolver (int queuesQnt) {
        for (int i = 0; i < queuesQnt; i++) {
            int numberOfStudents = sc.nextInt();
            System.out.println(getNotReorderedQuantity(numberOfStudents));
        } // end for
    } // end queuesSolver ()
    
    public static void main ( String args [] ) {
        int queuesQnt = sc.nextInt();
        queuesSolver(queuesQnt);
        sc.close();
    } // end main ()

} // end class Main