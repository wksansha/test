package studydatastruct.test.http;

/**
 * @author wangkai
 * @create 2020/9/25
 */
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpChunkClient {
    private HttpURLConnection connection;
    private OutputStream outputStream;

    public HttpChunkClient(String uri, Map<String, String> extraHeader) throws IOException {
        URL url = new URL(uri);

        connection = (HttpURLConnection) url.openConnection();
        extraHeader.forEach(connection::addRequestProperty);
        connection.setChunkedStreamingMode(1024);
        connection.setRequestProperty("Content-Type", "application/octet-stream");
        connection.setDoOutput(true);

        outputStream = connection.getOutputStream();
    }

    public void writeData(byte[] buffer) throws IOException {
        outputStream.write(buffer);
    }

    public void writeData(byte[] buffer, int offset, int count) throws IOException {
        outputStream.write(buffer, offset, count);
    }

    public void close() throws IOException {
        outputStream.close();
        connection.disconnect();
    }
}
