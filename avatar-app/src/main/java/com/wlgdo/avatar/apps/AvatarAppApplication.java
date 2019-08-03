
package com.wlgdo.avatar.apps;


import com.wlgdo.avatar.common.security.annotation.EnablePigFeignClients;
import com.wlgdo.avatar.common.security.annotation.EnablePigResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author lengleng
 * @date 2018年06月21日
 * 用户统一管理系统
 */
@EnablePigResourceServer
@EnablePigFeignClients
@SpringCloudApplication
public class AvatarAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(AvatarAppApplication.class, args);
	}

}
