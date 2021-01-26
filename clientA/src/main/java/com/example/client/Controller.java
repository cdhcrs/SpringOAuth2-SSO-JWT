/**
 * 北京慧点科技有限公司XCOA产品。
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的。
 *
 * @Date: 2021年01月25日
 * @Copyright: Copyright 2020 © Smartdot Technologies Co., Ltd.
 */
package com.example.client;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 * @author <a href="cendh:xuxk@smartdot.com">cendh</a>
 * @version 1.0, 2021年01月25日}
 */
@RestController
public class Controller {

    @GetMapping("/userInfo")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userInfo( ) {
        return "用户页面";
    }

    @GetMapping("/adminInfo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminInfo( ) {
        return "管理员页面";
    }

}
