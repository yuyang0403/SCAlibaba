package com.yuyang.sc.zuul.config;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.yuyang.sc.common.util.exception.BusinessCode;
import com.yuyang.sc.common.util.exception.MessageHelper;
import com.yuyang.sc.common.util.response.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yuyang
 * @date 2020/5/20 15:39
 * @Description
 */
@RestController
public class ErrorHandlerController implements ErrorController {
 
    /**
     * 出异常后进入该方法，交由下面的方法处理
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }
 
    @RequestMapping("/error")
    public ResponseResult<Void> error(){
        ResponseResult<Void> responseResult=new ResponseResult<>();
        responseResult.setCode(BusinessCode.CODE_1001);
        responseResult.setMessage(MessageHelper.getInstance().getMessage(String.valueOf(BusinessCode.CODE_1001), StringUtils.EMPTY));
        return responseResult;
    }
 
}