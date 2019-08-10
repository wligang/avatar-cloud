
package com.wlgdo.avatar.common.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lengleng
 * @date 2019/2/1
 * RestTemplate
 */
@Configuration
public class RestTemplateConfig {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
