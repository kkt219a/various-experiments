package effective.chapter7.item48;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {
    @Test
    public void random() throws Exception {
        Random random = new Random();
        random.ints(100_000_000)
                .parallel()
                .forEach(a->a+=1);
    }
    @Test
    public void threadLocalRandom() throws Exception {
        ThreadLocalRandom.current()
                .ints(1_000_000_000)
                .parallel()
                .forEach(a->a+=1);
    }
    @Test
    public void SplittableRandom() throws Exception {
        SplittableRandom sr = new SplittableRandom();
        sr.ints(1_000_000_000)
                .parallel()
                .forEach(a->a+=1);
    }

}
