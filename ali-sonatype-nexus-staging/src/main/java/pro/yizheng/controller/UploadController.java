package pro.yizheng.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.yizheng.config.AliConfiguration;

@RestController
public class UploadController {

    /*
    * AccessKey ID
        LTAI4GAKpmB1ueZHoJ4U2r1i
      AccessKey Secret
        sHHS7Ja9b67MHxTeOBA4O5Ci3Qx8hm
    * */

    @GetMapping("/upload")
    public String upload() throws ClientException {
        // initial
        DefaultAcsClient client = AliConfiguration.initVodClient("LTAI4GAKpmB1ueZHoJ4U2r1i", "sHHS7Ja9b67MHxTeOBA4O5Ci3Qx8hm");
        CreateUploadVideoResponse response = new CreateUploadVideoResponse();
        try {
            response = AliConfiguration.createUploadVideo(client);
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("VideoId = " + response.getVideoId() + "\n");
        System.out.print("UploadAddress = " + response.getUploadAddress() + "\n");
        System.out.print("UploadAuth = " + response.getUploadAuth() + "\n");
        System.out.print("RequestId = " + response.getRequestId() + "\n");



        return "succ";
    }



}
