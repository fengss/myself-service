package cn.coderss.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/12/4
 * Time: 上午10:56
 */
@RestController
public class SecurityController {

    @RequestMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user(){
        return "user";
    }


    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "admin";
    }
}
