package net.xdclass.dao;
import net.xdclass.damain.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoMapper {
    @Select("select * from video where id = #{VideoId}")
    Video findById(@Param("VideoId") int VideoId);


}
