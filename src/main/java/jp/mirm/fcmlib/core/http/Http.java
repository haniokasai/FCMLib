package jp.mirm.fcmlib.core.http;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Http {

    public static String post(URL url, PostHeader header, String data) throws IOException {
        byte[] outputBytes = data.getBytes(StandardCharsets.UTF_8);

        HttpURLConnection connection = (HttpURLConnection) ((url.openConnection()));
        connection.setDoOutput(header.isDoOutput());
        connection.setRequestProperty("Content-Type", header.getContentType());
        connection.setRequestProperty("Authorization", header.getAuthorization());
        connection.setRequestProperty("Content-Length", String.valueOf(outputBytes.length));
        connection.setRequestMethod(header.getRequestMethod());
        connection.connect();

        OutputStream os = connection.getOutputStream();
        os.write(outputBytes);
        os.close();

        InputStream input = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        StringBuffer buf = new StringBuffer();
        for (String line; (line = reader.readLine()) != null; ) {
            buf.append(line);
        }

        return buf.toString();
    }

}
