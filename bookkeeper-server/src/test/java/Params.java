import java.nio.ByteBuffer;

public class Params {
    private ByteBuffer[] testBuf;
    private long position;
    private byte[] masterKey;
    private int fileInfoVersionToWrite;
    private int size;
    private boolean bestEffort;
    private long fileSize;

    public Params(
            ByteBuffer[] testBuf, long position, byte[] masterkey, int fileInfoVersionToWrite,
            int size, boolean bestEffort, long fileSize) {
        this.testBuf = testBuf;
        this.position = position;
        this.masterKey = masterkey;
        this.fileInfoVersionToWrite = fileInfoVersionToWrite;
        this.size = size;
        this.bestEffort = bestEffort;
        this.fileSize = fileSize;
    }

    public Params() {

    }

    public ByteBuffer[] getTestBuf() {
        return testBuf;
    }

    public long getPosition() {
        return position;
    }

    public byte[] getMasterKey() {
        return masterKey;
    }

    public int getFileInfoVersionToWrite() {
        return fileInfoVersionToWrite;
    }

    public int getSize() {
        return size;
    }

    public boolean isBestEffort() {
        return bestEffort;
    }

    public long getFileSize() {
        return fileSize;
    }

}
