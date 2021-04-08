package me.mkhwang.senssms.sendModule.types;

/**
 * Created by mkhwang on 2021/04/08.
 */
public class ServiceConstants {

    //HEADER
    public static final String HEADER_TIMESTAMP = "x-ncp-apigw-timestamp";
    public static final String HEADER_ACCESSKEY = "x-ncp-iam-access-key";
    public static final String HEADER_SIGNATURE_V = "x-ncp-apigw-signature-v2";

    //HTTP Settings
    public static final int HTTP_CONNECT_TIMEOUT = 30000;
    public static final int HTTP_READ_TIMEOUT = 30000;

    public static final String API_URI = "https://sens.apigw.ntruss.com";
    public static final String API_MESSAGESERVICE = "/sms/v2/services/";
    public static final String SEND_MESSAGE_URI = "/messages";

}
