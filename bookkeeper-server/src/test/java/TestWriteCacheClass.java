import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HexFormat;

@RunWith(Parameterized.class)
public class TestWriteCacheClass {

    public TestWriteCacheClass() {

    }

    @Parameterized.Parameters
    public static Collection<Object[]> configure() throws Exception {
        return Arrays.asList(new Object[][]{ });
    }

    @Test
    public void putTest() {

    }

    @Test
    public void getTest() {

    }

    @Test
    public void getLastEntryTest() {

    }

    @Test
    public void clearTest() {

    }
}
