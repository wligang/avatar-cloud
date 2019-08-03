
package com.wlgdo.avatar.codegen;

import com.wlgdo.avatar.common.security.annotation.EnablePigFeignClients;
import com.wlgdo.avatar.common.security.annotation.EnablePigResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;


@EnablePigFeignClients
@EnablePigResourceServer
@SpringCloudApplication
public class AvatarCodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvatarCodeGenApplication.class, args);
	}
}
