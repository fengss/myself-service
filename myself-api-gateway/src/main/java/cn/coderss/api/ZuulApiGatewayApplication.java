package cn.coderss.api;

import cn.coderss.common.utils.TestA;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午5:44
 */
@SpringBootApplication
@EnableZuulProxy
//@EnableApolloConfig(value = "application", order = 10)
public class ZuulApiGatewayApplication extends WebMvcConfigurerAdapter implements CommandLineRunner{
    @Autowired
    TestA testA;

    public static void main(String[] args) {
        SpringApplication.run(ZuulApiGatewayApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void run(String... args) throws Exception {
        testA.test();
    }
}
