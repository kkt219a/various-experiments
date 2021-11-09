package effective.chapter7.item48;

import org.junit.jupiter.api.Test;

import static effective.chapter7.item48.ParallelMersennePrimes.primes;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static org.junit.jupiter.api.Assertions.*;

class ParallelMersennePrimesTest {

    @Test
    public void parallelStream() throws Exception {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .parallel() // 스트림 병렬화
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(15)
                .forEach(System.out::println);
    }

    @Test
    public void parallelStreamOrdered() throws Exception {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .parallel() // 스트림 병렬화
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(15)
                .forEachOrdered(System.out::println);
    }

//    @Test
//    public void stream() throws Exception {
//        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
//                .filter(mersenne -> mersenne.isProbablePrime(50))
//                .limit(15)
//                .forEach(System.out::println);
//    }
}