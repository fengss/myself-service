package cn.coderss.college.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/30
 * Time: 下午1:53
 */
@Service
public class MyService {
    Logger logger = LoggerFactory.getLogger(MyService.class);

    @HystrixCollapser(batchMethod = "getIds",
            collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "200")},
            scope = GLOBAL)
    public Future<String> getId(String id){
        System.out.println("getId");
        return null;
    }

    @HystrixCommand
    public List<String> getIds(List<String> ids){
        System.out.println("executing on thread id: "+ Thread.currentThread().getName() + ", id:"+ids.toString());
        return ids.stream().map(data->String.valueOf(Integer.valueOf(data)+1)).collect(Collectors.toList());
    }
}
