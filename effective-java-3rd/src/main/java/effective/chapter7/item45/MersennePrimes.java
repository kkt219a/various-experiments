package effective.chapter7.item45;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Stream;


// 스트림을 사용해 처음 20개의 메르센 소수를 생성한다. (274쪽)
public class MersennePrimes {
    static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
        primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                //.forEach(System.out::println);
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }
}
