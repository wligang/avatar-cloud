

package com.wlgdo.avatar.common.log.event;

import com.wlgdo.avatar.admin.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author Feify
 * 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

	public SysLogEvent(SysLog source) {
		super(source);
	}
}
