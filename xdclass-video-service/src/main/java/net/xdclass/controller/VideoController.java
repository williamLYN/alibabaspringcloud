package net.xdclass.controller;

import net.xdclass.damain.Video;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("find_by_id")
    public Object findById(int videoId , HttpServletRequest request){
        Video video =  videoService.findById(videoId);
        video.setServerInfo(request.getServerName()+":"+request.getServerPort());
        return video;
    }

    @PostMapping("save")
    public int save(@RequestBody Video video){
        System.out.println(video.getTitle());
        return 1;
    }
}
