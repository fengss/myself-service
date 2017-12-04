package cn.coderss.user;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/21
 * Time: 下午2:33
 */
@SpringBootApplication
@EnableHystrix
@Configuration
@EnableDiscoveryClient
@MapperScan("cn.coderss.user.mapper")
@EnableApolloConfig(value = "application", order = 10)
public class ServiceUserWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUserWebApplication.class);
    }
}
