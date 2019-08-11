

package com.wlgdo.avatar.auth;


import com.wlgdo.avatar.common.security.annotation.EnablePigFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author Feify
 * @date 2018年06月21日
 * 认证授权中心
 */
@SpringCloudApplication
@EnablePigFeignClients
public class AvatarAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvatarAuthApplication.class, args);
	}
}
