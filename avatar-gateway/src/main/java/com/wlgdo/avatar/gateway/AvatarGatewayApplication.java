package com.wlgdo.avatar.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author lengleng
 * @date 2018年06月21日
 * <p>
 * 网关应用
 */
@SpringCloudApplication
public class AvatarGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvatarGatewayApplication.class, args);
	}
}
