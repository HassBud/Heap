import java.util.Random;

public class BenchmarkPQ {


    public static int[] unSorted(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n * 5)+1;
        }
        return array;
    }

    public static void main(String[] arg) {

        int[] sizes = {100,200,400, 800, 1600, 3200, 6400, 10000, 15000, 25000, 50000, 100000, 160000};

        System.out.printf("# Priority queue benchmarking\n");
        System.out.printf("#%7s%9s%10s%10s%10s\n", "n", "add O(1)", "add2 O(n)", "remove O(n)", "remove2 O(1) ");
        for ( int n : sizes) {

            System.out.printf("%8d", n);

            int k = 10;

            int[] list = unSorted(n);

            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {

                FirstPriorityQueue pq1 = new FirstPriorityQueue();

                long t0 = System.nanoTime();
                for (int numb:list){
                    pq1.add(numb);
                }
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;

            }
            System.out.printf("%10.2f" , (min/n));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                SecondPriorityQueue pq2 = new SecondPriorityQueue();

                long t0 = System.nanoTime();
                for (int numb:list) {
                    pq2.add(numb);
                }
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%10.2f" , (min/n));


            min = Double.POSITIVE_INFINITY;








        }


    }


}

