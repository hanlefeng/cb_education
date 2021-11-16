import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;

public class testvdo {
    public static void main(String[] args) {
        String accessKeyId ="LTAI5tNxmmE58NXcqKfWpgxW";
        String accessKeySecret ="C9anYeqHUGprsDVk0rEnFJvAcj4nIM";
        String title = "6.mp4";
        String fileName = "D:/6.mp4";
        UploadVideoRequest request = new UploadVideoRequest(accessKeyId, accessKeySecret, title, fileName);
        request.setPartSize(2 * 1024 * 1024L);
        request.setTaskNum(1);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadVideoResponse response = uploader.uploadVideo(request);
        System.out.print("VideoId=" + response.getVideoId() + "\n");
    }
}
