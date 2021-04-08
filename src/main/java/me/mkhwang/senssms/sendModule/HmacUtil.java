package me.mkhwang.senssms.sendModule;


import lombok.extern.slf4j.Slf4j;
import me.mkhwang.senssms.util.StringUtil;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Slf4j
public class HmacUtil {
    private static final String SIGNATURE_ALGORITHM = "HmacSHA256";

    /**
     * using apache.commons.comdec
     * @param message
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * ref : https://www.javacodemonk.com/create-hmacsha256-signature-in-java-3421c36d
     */
    public static String generateHmac256(String message, String secret) throws NoSuchAlgorithmException, InvalidKeyException {
        final SecretKeySpec signkey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), SIGNATURE_ALGORITHM);
        Mac mac = Mac.getInstance(SIGNATURE_ALGORITHM);
        mac.init(signkey);

        byte[] rawHmac = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        String encodeBase64String = Base64.encodeBase64String(rawHmac);
        log.info(encodeBase64String);
        return encodeBase64String;
    }

    public static boolean verifySignature(String body, String signatrue) throws InvalidKeyException, NoSuchAlgorithmException {
        if(StringUtil.isEmpty(signatrue) || StringUtil.isEmpty(body)){
            return false;
        }

        String madeSignature = generateHmac256(body, signatrue);
        log.info("signature : {}, made signature : {}", signatrue, madeSignature);

        return signatrue.trim().equals(madeSignature);
    }
}
