package cn.coderss.college.service;

import cn.coderss.college.service.hystrix.CollegeServiceHystrix;
import cn.coderss.model.XbinResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午2:24
 */
@FeignClient(value = "myself-service-college", url = "http://192.168.3.4:8519", fallback = CollegeServiceHystrix.class)
public interface CollegeService {

    /**
     * 查询学院通过学院编码
     *
     * @param code   编码
     * @return
     */
    @RequestMapping(value = "/getCollegeByCode",method = RequestMethod.GET)
    XbinResult getCollegeByCode(@RequestParam("code") String code);

    /**
     * 查询学院通过学院名称
     *
     * @param name   名称
     * @return
     */
    @RequestMapping(value = "/getCollegeByName",method = RequestMethod.GET)
    XbinResult getCollegeByName(@RequestParam("name") String name);

    /**
     * 查询学院通过服务器名
     *
     * @param server   服务器名
     * @return
     */
    @RequestMapping(value = "/getCollegeByServer",method = RequestMethod.GET)
    XbinResult getCollegeByServer(@RequestParam("server") String server);


    /**
     * ID获取
     * @param id id
     * @return
     */
    @HystrixCollapser(batchMethod = "getCollegeByIds",
            collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "200")},
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL
    )
    @RequestMapping(value = "/getCollegeById", method = RequestMethod.GET)
    XbinResult getCollegeById(@RequestParam("id") Integer id);

    /**
     * ID获取
     * @param ids id
     * @return
     */
    @HystrixCommand
    @RequestMapping(value = "/getCollegeByIds", method = RequestMethod.GET)
    List<XbinResult> getCollegeByIds(@RequestParam("id") List<Integer> ids);
}
