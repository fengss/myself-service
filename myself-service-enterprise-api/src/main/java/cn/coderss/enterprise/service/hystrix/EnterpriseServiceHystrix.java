package cn.coderss.enterprise.service.hystrix;

import cn.coderss.enterprise.service.EnterpriseService;
import cn.coderss.model.XbinResult;
import org.springframework.stereotype.Component;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午2:30
 */
@Component
public class EnterpriseServiceHystrix implements EnterpriseService{

    @Override
    public XbinResult getEnterpriseByCode(String code) {
        return null;
    }

    @Override
    public XbinResult getEnterpriseByName(String name) {
        return null;
    }

    @Override
    public XbinResult getEnterpriseByServer(String server) {
        return null;
    }
}
