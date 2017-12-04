package cn.coderss.user;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/21
 * Time: 下午2:08
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
@EnableApolloConfig(value = "application", order = 10)
public class UserWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserWebApplication.class);
    }
}
