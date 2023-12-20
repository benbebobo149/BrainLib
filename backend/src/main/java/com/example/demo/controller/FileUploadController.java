import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("https://api.imgur.com/3/image");
        httppost.setHeader("Authorization", "Client-ID {your-client-id}");

        // HttpEntity reqEntity = MultipartEntityBuilder.create()
        //         .addBinaryBody("image", file.getInputStream(), ContentType.create(file.getContentType()), file.getOriginalFilename())
        //         .build();

        // httppost.setEntity(reqEntity);

        // HttpResponse response = httpclient.execute(httppost);
        // HttpEntity resEntity = response.getEntity();

        // if (resEntity != null) {
        //     String responseString = EntityUtils.toString(resEntity);
        //     // Parse the responseString to get the image link
        //     // Return the image link
        // }

        return null;
    }
}