

package com.wlgdo.avatar.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wlgdo.avatar.common.security.component.Auth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author Feify
 * @date 2019/2/1
 * 自定义OAuth2Exception
 */
@JsonSerialize(using = Auth2ExceptionSerializer.class)
public class PigAuth2Exception extends OAuth2Exception {
	@Getter
	private String errorCode;

	public PigAuth2Exception(String msg) {
		super(msg);
	}

	public PigAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
