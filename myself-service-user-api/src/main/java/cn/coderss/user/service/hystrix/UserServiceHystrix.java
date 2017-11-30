package cn.coderss.user.service.hystrix;

import cn.coderss.model.XbinResult;
import cn.coderss.user.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/21
 * Time: 下午2:24
 */
@Component
public class UserServiceHystrix implements UserService{
    @Override
    public XbinResult getUserByUserName(String userName) {
        return null;
    }

    @Override
    public XbinResult getUserByUserId(int userId) {
        return null;
    }

    @Override
    public XbinResult getUsers() {
        return null;
    }

    @Override
    public XbinResult getUserByAge(int age) {
        return null;
    }

    @Override
    public XbinResult getUserByServer(String server) {
        return null;
    }
}
