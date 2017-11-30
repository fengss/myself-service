package cn.coderss.zipkin;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/25
 * Time: 下午1:00
 */
@SpringBootApplication
@EnableZipkinServer //启动ZipkinServer段
@EnableApolloConfig
public class ZipkinServer {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServer.class, args);
    }
}