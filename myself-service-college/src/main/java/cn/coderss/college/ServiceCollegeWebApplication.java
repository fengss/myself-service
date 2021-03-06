package cn.coderss.college;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午2:33
 */
@SpringBootApplication
@EnableHystrix
@Configuration
@EnableDiscoveryClient
@EnableApolloConfig(value = "application", order = 10)
public class ServiceCollegeWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCollegeWebApplication.class);
    }
}
