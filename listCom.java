import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream; 

public class listCom {
    /**This main method is used to call our implemented list comprehensions either individually or for one iteration,
     * which will display execution time for a single iteration. Methods, such as getAverageExampleLoop,
     * displays execution time as an average over ten iterations. All exampleList methods are for the
     * list comprehension [x * x for x in range(7) if x % 3 ==0]. The resulting list will include squares
     * in the list that are divisible by 3.
    **/
    public static void main(String[] args) {
       // getAverageExampleLoop(); //range 0..6
       //  getAveBiggerExample(); //range 0..10,000
       // getAveBiggerExampleStreams();
       // getAveExampleStreams();
        getHugeListStreamAve(); //range 0..100,000
       // getHugeListLoopAve();
    } //end Main

    //method to compute average for loop approach for exampleList, range 0..6
    public static void getAverageExampleLoop(){
        long average=0;
        for(int i=0; i<10; i++){
            average+=exampleListLooping();
        }
        System.out.println("\n~Average execution time (ns): " + (average/(long)10));
    }

   //looping approach for exampleList, range 0..6
    public static long exampleListLooping(){
        long start, end, inNano;
        start = System.nanoTime(); //start timing execution of function
        List<Integer> it = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
        List<Integer> sol = new ArrayList<Integer>();
        for(int i =0; i<it.size();i++)
            {
            if (it.get(i) % 3 == 0)
                sol.add(i * i);
            }
        end = System.nanoTime(); //end timing
        inNano = (end-start); //get elapsed time in nanosec
        System.out.println("\n==ExampleList with regular for loop==\nResulting list with loop: " + sol);
        System.out.println("Execution time: " + inNano + " ns");
        return inNano;
    }

    //looping approach for exampleList, range 0..10,000
    public static long biggerExampleListLooping(){
            long start, end, inNano, inMilli;
            ArrayList<Integer> result = new ArrayList<>();
            ArrayList<Integer> ex2 = new ArrayList<>();
                System.out.println("\n==Bigger ExampleList 10000 with Java Stream class using for loop==\n");
            start = System.nanoTime();
            for(int j=0; j<=10000; j++){
                    ex2.add(j);
            }

            for(int i=0; i<ex2.size(); i++){
                if(Math.pow(ex2.get(i),2) %3==0){
                    result.add((int)Math.pow(ex2.get(i),2));
                }
            }
            System.out.print("Resulting list: [");
            for(Integer x: result){
                System.out.print(x + " ");
            }
            System.out.print("]");
            end = System.nanoTime();
            inNano = (end-start);
            inMilli = TimeUnit.NANOSECONDS.toMillis(inNano);
            System.out.println("\nExecution time: " + inMilli + " ms");
            return inMilli;
    }

    //method to get average for bigger exampleList looping approach, range 0..10,000
    public static void getAveBiggerExample(){
        long average=0;
        for(int i=0; i<10; i++){
            average+=biggerExampleListLooping();
        }
        System.out.println("\n~Average execution time (ms): " + (average/(long)10));
    }

    //Java Stream approach for exampleList, range 0..10,000
    public static long biggerExampleListStreams(){
        long start, end, inNano, inMilli;
        start = System.nanoTime();
        List<Integer> ex2 = IntStream.range(0, 10000)
                .boxed()
                .filter(x -> x % 3 == 0)
                .map(x -> x * x)
                .collect(Collectors.toList());
        end = System.nanoTime();
        inNano = (end-start);
        inMilli = TimeUnit.NANOSECONDS.toMillis(inNano);
        System.out.println("\n==Bigger ExampleList with Java Stream class using Java Stream==\nResulting list: " +
                ex2);
        System.out.println("Execution time: " + inMilli + " ms");
        return inMilli;
    }

    //Stream approach to exampleList, range 0..100,000
    public static long hugeExampleListStream(){
        long start, end, inNano, inMilli;
        // used stream without create object
        start = System.nanoTime();

        List<Integer> ex2 = IntStream.range(0, 100000)
                // must boxed to convert primitives stream to collection
                .boxed()
                .filter(x -> x % 3 == 0)
                .map(x -> x * x)
                .collect(Collectors.toList());

        end = System.nanoTime();
        inNano = (end-start);
        inMilli = TimeUnit.NANOSECONDS.toMillis(inNano);
        System.out.println("\n==Bigger ExampleList with Java Stream class using Java Stream==\nResulting list: " +
                ex2);
        System.out.println("Execution time: " + inMilli + " ms");
        return inMilli;
    }

    //get average for Stream approach to exampleList, range 0..10,000
    public static void getAveBiggerExampleStreams(){
        long average=0;
        for(int i=0; i<10; i++){
            average+=biggerExampleListStreams();
        }
        System.out.println("\n~Average execution time (ms): " + (average/(long)10));
    }

    //Stream approach to exampleList, range 0..6
    public static long exampleListStreams(){
        long start, end, inNano, inMilli;
        start = System.nanoTime();
        List<Integer> ex = Arrays.asList(0, 1, 2, 3, 4, 5, 6)
                .stream()
                .filter(x -> x % 3 == 0)
                .map(x -> x * x)
                // convert to list
                .collect(Collectors.toList());
        end = System.nanoTime();
        inNano = (end-start);
        inMilli = TimeUnit.NANOSECONDS.toMillis(inNano);
        System.out.println("\n==ExampleList with Java Stream class==\nResulting list: " + ex);
        System.out.println("Execution time: " + inMilli + " ms");
        return inMilli;
    }

    //diff between exampleListStreams: IntStream range
    public static void exampleListStreams2(){
        long start, end, inNano, inMilli;
        // used stream without create object
        start = System.nanoTime();
        List<Integer> ex2 = IntStream.range(0, 7)
                // must boxed to convert primitives stream to collection
                .boxed()
                .filter(x -> x % 3 == 0)
                .map(x -> x * x)
                .collect(Collectors.toList());

        end = System.nanoTime();
        inNano = (end-start);
        inMilli = TimeUnit.NANOSECONDS.toMillis(inNano);
        System.out.println("\n==ExampleList with Java Stream class using Java Stream==\nResulting list: " +
                     ex2);
        System.out.println("Execution time: " + inMilli + " ms");
    }

    //extra experiments -- return BEEP/BOOP depending on value
    public static void boopBeepListStream() {
        long start, end, inNano, inMilli;
        // return Boop if x < 15 else return Beep for x is [10-20]
        System.out.println("\n==Print BOOP if x is less than 15 and BEEP otherwise using Stream==\nResulting list:\n");

        start = System.nanoTime();

        IntStream.range(10, 21)
                .forEach(s -> System.out.println(s + " = " + ((s < 15) ? "BOOP" : "BEEP")));

        end = System.nanoTime();

        inNano = (end - start);
        inMilli = TimeUnit.NANOSECONDS.toMillis(inNano);
        System.out.println("\nExecution Time : " + inMilli + " ms");
    }

    //extra experiments -- BEEP
    public static void boopBeepListCollectors(){
        long start, end, inNano, inMilli;
        start = System.nanoTime();
        List<String> ex3 = IntStream.range(10, 21)
                .filter(x -> x < 15)
                .mapToObj(x -> x + " = BEEP")
                .collect(Collectors.toList());
        end = System.nanoTime();
        inNano = (end-start);
        inMilli = TimeUnit.NANOSECONDS.toMillis(inNano);
        System.out.println("\n==Print BOOP if x is less than 15 and BEEP otherwise using collectors==\nResulting list: " +
                ex3);
        System.out.println("Execution Time: " + inMilli + " ms");
    }

    //extra experiments -- sort random numbers
    public static void sortRandom1(){
        long start, end, inNano, inMilli;
        // generated random number and sort it
        start = System.nanoTime();
        List<Integer> rand1 = Stream.generate(() -> (new Random()).nextInt(100))
                .limit(6)
                .sorted()
                // convert to list
                .collect(Collectors.toList());
        end = System.nanoTime();
        inNano = (end-start);
        inMilli = TimeUnit.NANOSECONDS.toMillis(inNano);
        System.out.println("\n==Sort random list of 6 integers using Java Stream==\nResulting list: " + rand1);
        System.out.println("Execution time: " + inMilli + " ms");
    }

    //extra experiments -- sort random list
    public static void sortRandom2(){
        long start, end, inNano, inMilli;
        // Random.ints will return an IntStream (#, low, high)
        start = System.nanoTime();
        List<Integer> rand2 = new Random()
                .ints(5, 0, 25)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        end = System.nanoTime();
        inNano = (end-start);
        inMilli = TimeUnit.NANOSECONDS.toMillis(inNano);
        System.out.println("\n==Sort random list again==\nResulting list: " + rand2);
        System.out.println("Execution Time: " + inMilli + " ms");
    }

    //extra experiments -- returns execution time for 1 iteration
    public static long sortRandom3(){
        long start, end;
        // run 100 time, generated randomly 10000 integer for sorting
            start = System.nanoTime(); //start timer for this iteration
            List<Integer> rand3 = new Random()
                    .ints(10000) //10000 random ints
                    .sorted()
                    .boxed()
                    .collect(Collectors.toList());
            end= System.nanoTime(); //end timer for this iteration
            return (end-start);
    }

    //extra experiments -- sortRandom3 100 times
    public static void sortRandom100Times(){
        long nanoSum=0, inNanoAve, inMilliAve;
        for(int i=0; i<100; i++){
            nanoSum+=sortRandom3();
       }
        inNanoAve = (nanoSum/(long) 100);
        inMilliAve = TimeUnit.NANOSECONDS.toMillis(inNanoAve);
        System.out.println("\n==Sort random list of 10000 integers==\nAverage execution time: " + inMilliAve + " ms");
    }

    //looping approach to exampleList, range 0..100,000
    public static long hugeExampleListLooping(){
        long start, end, inNano, inMilli;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> ex2 = new ArrayList<>();
        System.out.println("\n==Bigger ExampleList 10000 with Java Stream class using for loop==\n");
        // used stream without create object
        start = System.nanoTime();
        for(int j=0; j<=100000; j++){
            ex2.add(j);
        }
        for(int i=0; i<ex2.size(); i++){
            if(Math.pow(ex2.get(i),2) %3==0){
                result.add((int)Math.pow(ex2.get(i),2));
                //System.out.print(result.get(i) + " ");
            }
        }
        System.out.print("Resulting list: [");
        for(Integer x: result){
            System.out.print(x + " ");
        }
        System.out.print("]");
        end = System.nanoTime();
        inNano = (end-start);
        inMilli = TimeUnit.NANOSECONDS.toMillis(inNano);
        System.out.println("\nExecution time: " + inMilli + " ms");
        return inMilli;
    }

    //get get average time for Stream approach to exampleList, range 0..6
    public static void getAveExampleStreams(){
        long average=0;
        for(int i=0; i<10; i++){
            average+=exampleListStreams();
        }
        System.out.println("\n~Average execution time (ms): " + (average/(long)10));
    }

    //get average time for Stream approach to exampleList, range 0..100,000
    public static void getHugeListStreamAve(){
        long average=0;
        for(int i=0; i<10; i++){
            average+=hugeExampleListStream();
        }
        System.out.println("\n~Average execution time 100000 (ms): " + (average/(long)10));
    }

    //get average time for looping approach to exampleList, range 0..10,000
    public static void getHugeListLoopAve(){
        long average=0;
        for(int i=0; i<10; i++){
            average+=hugeExampleListLooping();
        }
        System.out.println("\n~Average execution time 100000 (ms): " + (average/(long)10));
    }

}//end listCom
