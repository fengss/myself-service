package cn.coderss.turbine;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午12:46
 */
@SpringBootApplication
@EnableTurbine
@EnableApolloConfig(value = "application", order = 10)
public class TurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class);
    }
}

