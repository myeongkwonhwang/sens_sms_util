package me.mkhwang.senssms.sendModule;

import me.mkhwang.senssms.sendModule.request.model.Messages;
import me.mkhwang.senssms.sendModule.request.model.SendMessageRequest;
import me.mkhwang.senssms.sendModule.service.SensClient;
import me.mkhwang.senssms.sendModule.service.SensConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URLEncoder;
import java.util.Collections;

/**
 * Created by mkhwang on 2021/04/09
 * Email : orange2652@gmail.com
 * Github : http://github.com/myeongkwonhwang
 */
@SpringBootTest
public class SendModuleTest {

    @Value("${api.naver.servId}")
    private String servId;
    @Value("${api.naver.accessKeyId}")//qYYJ9B8zgG1q726b8b3t
    private String accessKeyId;
    @Value("${api.naver.secretKey}")
    private String secretKey;

    @Test
    public void sendTest() throws Exception {
        Messages messages = Messages.builder().content("testtesttest").to("").subject("계약").build();

        SendMessageRequest sendMessageRequest = new SendMessageRequest("", "계약", "testtesttest",
                Collections.singletonList(messages));
        String encode = URLEncoder.encode(servId);
        SensConfig sensConfig = new SensConfig(servId, accessKeyId, secretKey);
        SensClient sensClient = new SensClient(sensConfig);
        sensClient.sendMessage(sendMessageRequest);
    }
}
