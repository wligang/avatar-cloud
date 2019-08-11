package com.wlgdo.avatar.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 网关应用
 */
@SpringCloudApplication
public class AvatarGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvatarGatewayApplication.class, args);
	}
}
