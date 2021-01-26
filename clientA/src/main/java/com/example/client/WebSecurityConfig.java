/**
 * 北京慧点科技有限公司XCOA产品。
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的。
 *
 * @Date: 2021年01月25日
 * @Copyright: Copyright 2020 © Smartdot Technologies Co., Ltd.
 */
package com.example.client;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <p>
 *
 * </p>
 * @author <a href="cendh:xuxk@smartdot.com">cendh</a>
 * @version 1.0, 2021年01月25日}
 */

@EnableOAuth2Sso
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests()
                .anyRequest().authenticated();
    }
}
