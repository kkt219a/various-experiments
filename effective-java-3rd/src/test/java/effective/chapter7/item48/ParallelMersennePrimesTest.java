package effective.chapter7.item48;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static effective.chapter7.item48.ParallelMersennePrimes.primes;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static org.junit.jupiter.api.Assertions.*;

class ParallelMersennePrimesTest {

    @Test
    public void parallelStream() throws Exception {
        IntStream.rangeClosed(0,25_000_000).boxed().parallel()
                        .forEach((a)-> a+=1);
    }

    @Test
    public void parallelStreamOrdered() throws Exception {
        IntStream.rangeClosed(0,25_000_000).boxed().parallel()
                .forEachOrdered((a)-> a+=1);
    }

//    @Test
//    public void stream() throws Exception {
//        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
//                .filter(mersenne -> mersenne.isProbablePrime(50))
//                .limit(15)
//                .forEach(System.out::println);
//    }
}