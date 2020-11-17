package com.sinoiov.yqzjj.common.util.config;

import com.sinoiov.yqzjj.common.util.exception.MessageHelper;
import com.sinoiov.yqzjj.common.util.exception.ServiceHandlerExceptionResolver;
import org.springframework.context.annotation.Bean;

/**
 * @author sinoiov
 * @date 2020/5/11 9:52
 * @Description
 */

public class ServerConfiguration {

    /**
     * 统一异常处理
     */
    @Bean
    public ServiceHandlerExceptionResolver serviceHandlerExceptionResolver() {
        return new ServiceHandlerExceptionResolver();
    }

    @Bean
    public MessageHelper messageHelper() {
        return new MessageHelper();
    }
}
