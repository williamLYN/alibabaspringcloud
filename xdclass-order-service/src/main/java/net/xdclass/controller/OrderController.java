package net.xdclass.controller;

import net.xdclass.damain.VideoOrder;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import net.xdclass.damain.Video;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("api/v1/video_order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Qualifier("net.xdclass.service.VideoService")
    private VideoService videoService;

    @RequestMapping("/save")
    public Object save(int videoId){
        //Video video = restTemplate.getForObject("http://localhost:9000/api/v1/video/find_by_id?videoId="+videoId,Video.class);
        //List<ServiceInstance> list = discoveryClient.getInstances("xdclass-video-service");

        //ServiceInstance serviceInstance = list.get(0);
        //Video video = restTemplate.getForObject("http://xdclass-video-service/api/v1/video/find_by_id?videoId="+videoId,Video.class);

        Video video = videoService.findById(videoId);
        VideoOrder videoOrder  = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(new Date());
        videoOrder.setServerInfo(video.getServerInfo());
        return videoOrder;
    }

/*    @RequestMapping("/save")
    public Object save(@RequestBody Video video){
       int row =  videoService.save(video);
       return new HashMap<>().put("rows",row);
    }*/

    //int temp = 0;
    @RequestMapping("/list")
    public Object list(HttpServletRequest request) {
/*        temp++;
        if(temp%3 == 0){
            throw new RuntimeException();
        }*/
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("post",request.getServerPort()+"");
        return map;
    }
}
