package cn.coderss.user.controller;

import cn.coderss.model.XbinResult;
import cn.coderss.user.service.UserDetailServiceImpl;
import cn.coderss.user.service.UserService;
import com.netflix.appinfo.ApplicationInfoManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/21
 * Time: 下午3:16
 */
@Controller
public class AccountController{

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @RequestMapping("/test")
    public String test(String username, Model model){
        XbinResult result = userService.getUserByUserName("tt");
        userService.getUserByAge(10);
        userService.getUserByServer("server");
        userService.getUserByUserId(1);
        userService.getUsers();
        model.addAttribute("data", result.getData().toString());
        return "user";
    }

    @RequestMapping("/data")
    public String getData(){
        return "data";
    }
}
