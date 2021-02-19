package net.xdclass.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@Component
public class XdclassUrlBlockHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        Map<String,Object> info = new HashMap<>();
        if(e instanceof FlowException){
            info.put("code",-1);
            info.put("msg","限流");
        }
        else if(e instanceof DegradeException){
            info.put("code",-2);
            info.put("msg","降级");
        }
        else if(e instanceof ParamFlowException){
            info.put("code",-3);
            info.put("msg","热点");
        }
        else if(e instanceof SystemBlockException){
            info.put("code",-4);
            info.put("msg","系统");
        }
        else if(e instanceof AuthorityException){
            info.put("code",-5);
            info.put("msg","授权");
        }

        httpServletResponse.setStatus(200);
        httpServletResponse.setHeader("context-type","application/json;charaset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(info));


    }
}
