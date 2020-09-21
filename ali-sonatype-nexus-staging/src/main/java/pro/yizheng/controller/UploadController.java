package pro.yizheng.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.yizheng.config.AliConfiguration;

@RequestMapping
public class UploadController {

    @PostMapping
    public void upload() throws ClientException {
        // initial
        DefaultAcsClient client = AliConfiguration.initVodClient("", "")
    }
}
