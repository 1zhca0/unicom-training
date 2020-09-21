package pro.yizheng;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.yizheng.config.AliConfiguration;

@SpringBootApplication
public class MainApplication {
    /*
    * AccessKey ID
        LTAI4GAKpmB1ueZHoJ4U2r1i
      AccessKey Secret
        sHHS7Ja9b67MHxTeOBA4O5Ci3Qx8hm
    * */
    public static void main(String[] args) throws ClientException {
        // initial
        DefaultAcsClient client = AliConfiguration.initVodClient("LTAI4GAKpmB1ueZHoJ4U2r1i", "sHHS7Ja9b67MHxTeOBA4O5Ci3Qx8hm");

        SpringApplication.run(MainApplication.class,args);
    }
}
