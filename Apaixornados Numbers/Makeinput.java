import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

class Makeinput {
    public static void main(String[] args) throws IOException {
        FileWriter wr = new FileWriter("input.in");

        int n  = 1000;
        long x = 0;
        long y = 0;

        ArrayList<Long> array = new ArrayList<Long>(n);
        LinkedList<Long> accumulator = new LinkedList<Long>();
        Random random = new Random(1);

        for (int i = 0; i < 100; i++) {
            y = x = random.nextLong(-999999999999L, 999999999999L);
            if(!array.contains(x)) {
                array.add(x);
                accumulator.addLast(y);
            } else i--;
        }

        for (int i = 100; i < (n - 100); i++) {
            y = x = random.nextLong(-999999999999L, 999999999999L);
            if(!array.contains(x)) {
                array.add(x);
                array.add(accumulator.removeFirst());
                i++;
                accumulator.addLast(x);
            } else {
                i--;
            }
        }

        for (int i = (n-100); i < n; i++) {
            array.add(accumulator.removeFirst());
        }

        if(!array.contains(60L)) {
            System.out.println(array.get(50));
            array.set(50, 60L);
            System.out.println(array.get(500));
            array.set(500, 60L);
        }

        System.out.println("tamanho final = " + array.size());

        long xors = 0;
        for (int i = 0; i < n; i++) {
            xors ^= array.get(i);
        }

        System.out.println("xors = " + xors);

        wr.write(n+"\n");
        wr.write(array.toString().replaceAll("\\[", "").replaceAll("\\]","").replaceAll(",",""));
        wr.write("\n0\n");
        wr.close();
    }
}
