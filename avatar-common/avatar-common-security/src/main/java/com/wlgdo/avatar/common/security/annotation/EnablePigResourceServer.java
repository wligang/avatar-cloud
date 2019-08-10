

package com.wlgdo.avatar.common.security.annotation;

import com.wlgdo.avatar.common.security.component.PigResourceServerAutoConfiguration;
import com.wlgdo.avatar.common.security.component.PigSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @author lengleng
 * @date 2019/03/08
 * <p>
 * 资源服务注解
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({PigResourceServerAutoConfiguration.class, PigSecurityBeanDefinitionRegistrar.class})
public @interface EnablePigResourceServer {

}
