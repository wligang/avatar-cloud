

package com.wlgdo.avatar.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wlgdo.avatar.common.security.component.Auth2ExceptionSerializer;

/**
 * @author Feify
 * @date 2019/2/1
 */
@JsonSerialize(using = Auth2ExceptionSerializer.class)
public class InvalidException extends PigAuth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
