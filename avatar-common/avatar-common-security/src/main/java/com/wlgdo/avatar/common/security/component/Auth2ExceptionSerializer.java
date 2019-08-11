package com.wlgdo.avatar.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.wlgdo.avatar.common.core.constant.CommonConstants;
import com.wlgdo.avatar.common.security.exception.PigAuth2Exception;
import lombok.SneakyThrows;

/**
 * @author Feify
 * @date 2019/8/11
 * <p>
 * OAuth2 异常格式化
 */
public class Auth2ExceptionSerializer extends StdSerializer<PigAuth2Exception> {
	public Auth2ExceptionSerializer() {
		super(PigAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(PigAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", CommonConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}
}
