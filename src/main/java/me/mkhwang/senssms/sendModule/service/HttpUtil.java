package me.mkhwang.senssms.sendModule.service;


import lombok.extern.slf4j.Slf4j;
import me.mkhwang.senssms.sendModule.response.parser.ResponseData;
import me.mkhwang.senssms.sendModule.types.ServiceConstants;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Slf4j
public class HttpUtil {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static ResponseData httpSendRequest(String method, String requestUri, String requestData, Map<String, String> headers) throws IOException {
        URL url = new URL(requestUri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(ServiceConstants.HTTP_CONNECT_TIMEOUT);
        con.setReadTimeout(ServiceConstants.HTTP_READ_TIMEOUT);
        if(headers != null && !headers.isEmpty()) {
            for (String key : headers.keySet()) {
                con.setRequestProperty(key, headers.get(key));
            }
        }
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setUseCaches(false);
        con.setRequestMethod(method);


        if(requestData != null) {
            DataOutputStream outputStream = new DataOutputStream(con.getOutputStream());
            outputStream.write(requestData.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        }

        int responseCode = con.getResponseCode();

        BufferedReader in;
        if (responseCode != 202) {
            in = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
        }else {
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        }
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null){
            response.append(inputLine).append(LINE_SEPARATOR);
        }
        in.close();

        return new ResponseData(responseCode, response.toString());
    }

}
