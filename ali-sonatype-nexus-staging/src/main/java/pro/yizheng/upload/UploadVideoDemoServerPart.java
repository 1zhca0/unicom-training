package pro.yizheng.upload;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.*;
import com.aliyun.vod.upload.resp.*;

import java.util.Date;


public class UploadVideoDemoServerPart {

    private static final String accessKeyId = "LTAI4GAKpmB1ueZHoJ4U2r1i";
    private static final String accessKeySecret = "sHHS7Ja9b67MHxTeOBA4O5Ci3Qx8hm";
    private static String fileName = "C:\\Users\\unicom\\Desktop\\test.mp4";
    private static String title = "file-" + new Date().getTime();

    public static void main(String[] args) {
        testUploadVideo(accessKeyId, accessKeySecret, title, fileName);
    }

    private static void testUploadVideo(String accessKeyId, String accessKeySecret, String title, String fileName) {
        UploadVideoRequest request = new UploadVideoRequest(accessKeyId, accessKeySecret, title, fileName);
        request.setPartSize(2 * 1024 * 1024L);
        request.setTaskNum(1);
        UploadVideoResponse response = new UploadVideoImpl().uploadVideo(request);
        System.out.print("RequestId=" + response.getRequestId() + "\n");  //请求视频点播服务的请求ID
        if (response.isSuccess()) {
            System.out.print("VideoId=" + response.getVideoId() + "\n");
        } else {
            /* 如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因 */
            System.out.print("VideoId=" + response.getVideoId() + "\n");
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
        }
    }
}