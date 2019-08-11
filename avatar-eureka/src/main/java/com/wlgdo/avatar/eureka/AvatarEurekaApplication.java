

package com.wlgdo.avatar.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Feify
 * @date 2018年06月21日
 * 服务中心
 */
@EnableEurekaServer
@SpringBootApplication
public class AvatarEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvatarEurekaApplication.class, args);
	}
}
