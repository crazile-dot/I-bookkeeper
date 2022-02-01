import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.apache.bookkeeper.bookie.storage.ldb.WriteCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HexFormat;

@RunWith(Parameterized.class)
public class TestWriteCacheClass {

    private ByteBufAllocator allocator;
    private long maxCacheSize;
    private int maxSegmentSize;
    private long ledgerId;
    private long entryId;
    private ByteBuf entry;

    public TestWriteCacheClass(Params params) {
        this.allocator = params.getAllocator();
        this.maxCacheSize = params.getMaxCacheSize();
        this.maxSegmentSize = params.getMaxSegmentSize();
        this.ledgerId = params.getLedgerId();
        this.entryId = params.getEntryId();
        this.entry = params.getEntry();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> configure() throws Exception {
        return Arrays.asList(new Object[][]{ });
    }

    @Test
    public void putTest() {
        WriteCache writeCache = new WriteCache(this.allocator, this.maxCacheSize, this.maxSegmentSize);
        writeCache.put(this.ledgerId, this.entryId, this.entry);
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
