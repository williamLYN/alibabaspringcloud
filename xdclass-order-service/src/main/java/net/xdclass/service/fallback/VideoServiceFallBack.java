package net.xdclass.service.fallback;

import net.xdclass.damain.Video;
import net.xdclass.service.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceFallBack implements VideoService {

    @Override
    public Video findById(int videoId) {
        Video video  = new Video();
        video.setTitle("备用视频");
        return video;
    }

    @Override
    public int save(Video video) {
        return 0;
    }
}
