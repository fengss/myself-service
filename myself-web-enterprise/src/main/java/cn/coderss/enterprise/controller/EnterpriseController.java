package cn.coderss.enterprise.controller;

import cn.coderss.enterprise.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午3:02
 */
@RestController
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @RequestMapping("/test")
    public String test(String username, Model model){
        enterpriseService.getEnterpriseByCode("1");
        enterpriseService.getEnterpriseByName("1");
        return enterpriseService.getEnterpriseByServer("1").getData().toString();
    }
}
