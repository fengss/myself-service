package cn.coderss.user.service;

import cn.coderss.model.XbinResult;
import cn.coderss.user.service.hystrix.UserServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/21
 * Time: 下午2:22
 */
@FeignClient(value = "myself-service-user",fallback = UserServiceHystrix.class)
public interface UserService {
    /**
     * 查询用户
     *
     * @param userName   用户名
     * @return
     */
    @RequestMapping(value = "/getUserByUserName",method = RequestMethod.GET)
    XbinResult getUserByUserName(
            @RequestParam("userName")    String userName
    );


    /**
     * 查询用户
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/getUserByUserId", method = RequestMethod.GET)
    XbinResult getUserByUserId(
            @RequestParam("userId") int userId
    );


    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    XbinResult getUsers();


    /**
     * 查询用户通过年纪
     * @param age
     * @return
     */
    @RequestMapping(value = "/getUserByAge", method = RequestMethod.GET)
    XbinResult getUserByAge(
            @RequestParam("age") int age
    );


    /**
     * 查询用户通过服务器
     * @param server
     * @return
     */
    @RequestMapping(value = "/getUserByServer", method = RequestMethod.GET)
    XbinResult getUserByServer(
            @RequestParam("server") String server
    );

}
