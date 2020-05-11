package com.yuyang.sc.common.util.config;

import com.yuyang.sc.common.util.redis.RedisCacheAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author yuyang
 * @date 2020/5/11 9:52
 * @Description
 */
@Import({RedisCacheAutoConfiguration.class})
public class ServerConfiguration {
}
