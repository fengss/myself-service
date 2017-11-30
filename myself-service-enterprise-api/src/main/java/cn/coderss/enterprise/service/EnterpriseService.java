package cn.coderss.enterprise.service;

import cn.coderss.enterprise.service.hystrix.EnterpriseServiceHystrix;
import cn.coderss.model.XbinResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午2:29
 */
@FeignClient(value = "myself-service-enterprise",fallback = EnterpriseServiceHystrix.class)
public interface EnterpriseService {

    /**
     * 获取企业
     * @param code 企业编码
     * @return
     */
    @RequestMapping(value = "/getEnterpriseByCode",method = RequestMethod.GET)
    XbinResult getEnterpriseByCode(@RequestParam("code") String code);

    /**
     * 获取企业
     * @param name 企业名称
     * @return
     */
    @RequestMapping(value = "/getEnterpriseByName",method = RequestMethod.GET)
    XbinResult getEnterpriseByName(@RequestParam("name") String name);

    /**
     * 获取企业
     * @param server 服务器名
     * @return
     */
    @RequestMapping(value = "/getEnterpriseByServer",method = RequestMethod.GET)
    XbinResult getEnterpriseByServer(@RequestParam("server") String server);
}
