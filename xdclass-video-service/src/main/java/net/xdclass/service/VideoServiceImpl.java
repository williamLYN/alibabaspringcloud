package net.xdclass.service;

import net.xdclass.damain.Video;
import net.xdclass.dao.VideoMapper;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Override
    public Video findById(int videoId) {
        return videoMapper.findById(videoId);
    }
}
