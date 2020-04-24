import java.util.*;
import java.util.List;
import java.util.stream.Collectors;  
import java.util.stream.IntStream;
import java.util.stream.Stream; 

public class listCom {
	public static void main(String[] args) {
		
	// return x square if x % 3 = 0 for x = [0-6]
		// convert a list of object to stream
		List<Integer> ex = Arrays.asList(0,1,2,3,4,5,6)
							.stream()
							.filter(x -> x % 3==0)
    						.map(x -> x * x)
    						// convert to list
    						.collect(Collectors.toList());
    	System.out.println(ex);

    	// used stream without create object
    	List<Integer> ex2 = IntStream.range(0, 7)
    						// must boxed to convert primitives stream to collection
    						.boxed()		
    						.filter(x -> x % 3==0)
    						.map(x -> x * x)
    						.collect(Collectors.toList());
		System.out.println(ex2);
		

	// return Boop if x < 15 else return Beep for x is [10-20]
		IntStream.range(10,21)
							.forEach(s -> System.out.println(s + " = " + ((s < 15) ? "BOOP" : "BEEP")));
		
		List<String> ex3 = IntStream.range(10,21)
							.filter(x -> x < 15)
							.mapToObj(x -> x + " = BEEP")
							.collect(Collectors.toList());
		System.out.println(ex3);
		
		
	// generated random number and sort it
		List<Integer> rand1 = Stream.generate(() -> (new Random()).nextInt(100))
    						.limit(6)
    						.sorted()
    						// convert to list
    						.collect(Collectors.toList());
    	System.out.println(rand1);

    	// Random.ints will return an IntStream (#, low, high)
    	// must boxed for IntStream
		List<Integer> rand2 = new Random()
								.ints( 5, 0, 25 )
								.sorted()
								.boxed()
								.collect( Collectors.toList() );
        System.out.println(rand2);
		
	}
}
