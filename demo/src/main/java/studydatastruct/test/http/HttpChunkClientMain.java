package studydatastruct.test.http;

/**
 * @author wangkai
 * @create 2020/9/25
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HttpChunkClientMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Mirror-Caller", "137000000");
        headers.put("X-Mirror-Called", "10086");
        headers.put("X-Mirror-AgentID", "1000");
        headers.put("X-Mirror-Direction", "inbound");
        headers.put("X-Mirror-CallID", UUID.randomUUID().toString());
        headers.put("X-Mirror-Source", "caller");
        headers.put("X-Mirror-Extension", "1000");
        headers.put("X-Mirror-RingTime", "2020-09-20 10:10:10");
        headers.put("X-Mirror-ConnectedTime", "2020-09-20 10:10:10");

        HttpChunkClient client = new HttpChunkClient(
                "http://139.159.157.90:8189/accessPoint/mirror", headers);

        byte[] buffer = new byte[4096];
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(new File("D:\\1.wav")));

        int realRead = 0;
        while ((realRead = stream.read(buffer)) >= 0) {
            client.writeData(buffer, 0, realRead);
            Thread.sleep(250);
        }
        client.close();
    }
}

