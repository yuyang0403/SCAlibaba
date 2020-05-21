package com.yuyang.sc.zuul.config;

import com.alibaba.csp.sentinel.adapter.gateway.zuul2.fallback.ZuulBlockFallbackManager;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.csp.sentinel.adapter.servlet.config.WebServletConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author yuyang
 * @date 2020/5/21 14:41
 * @Description
 */
@Configuration
public class ZuulConfig {

	@PostConstruct
	public void doBlockPageConfig() {
		// 设置限流后返回的消息
		WebServletConfig.setBlockPage("/block/error");
	}
}