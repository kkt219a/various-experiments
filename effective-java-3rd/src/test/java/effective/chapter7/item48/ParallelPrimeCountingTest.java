package effective.chapter7.item48;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.LongStream;

import static effective.chapter7.item48.ParallelMersennePrimes.primes;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static org.junit.jupiter.api.Assertions.*;

class ParallelPrimeCountingTest {
    @Test
    public void parallelStream() throws Exception {
        long count = LongStream.rangeClosed(2, 10000000)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
        System.out.println("count = " + count);
    }

    @Test
    public void stream() throws Exception {
        long count = LongStream.rangeClosed(2, 10000000)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
        System.out.println("count = " + count);
    }
}