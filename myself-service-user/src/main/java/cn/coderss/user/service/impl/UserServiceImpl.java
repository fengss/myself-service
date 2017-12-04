package cn.coderss.user.service.impl;

import cn.coderss.mapper.ActivityMapper;
import cn.coderss.model.ActivityExample;
import cn.coderss.model.UserModel;
import cn.coderss.model.XbinResult;
import cn.coderss.user.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/21
 * Time: 下午2:41
 */
@Api(value = "API - UserServiceImpl", description = "user 服务")
@RestController
@RefreshScope
public class UserServiceImpl implements UserService {

    @Value("${info.server}")
    private String server;

    @Autowired
    ActivityMapper mapper;

    @Override
    @ApiOperation("查询用户通过用户名")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "userName", value = "", required = true, dataType = "String"),
            }
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public XbinResult getUserByUserName(String userName) {
        return new XbinResult(200, "ok", new UserModel(1, "张三", 20, "张三号", this.server));
    }

    @Override
    @ApiOperation("查询用户通过ID")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "userId", value = "1", required = true, dataType = "int"),
            }
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public XbinResult getUserByUserId(int userId) {
        return new XbinResult(200, "ok", new UserModel(1, "张三", 20, "张三号", this.server));
    }

    @Override
    @ApiOperation("查询所有用户")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public XbinResult getUsers() {
        return new XbinResult(200, "ok", new UserModel(1, "张三", 20, "张三号", this.server));
    }

    @Override
    @ApiOperation("查询用户通过年纪")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "age", value = "1", required = true, dataType = "int"),
            }
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public XbinResult getUserByAge(int age) {
        return new XbinResult(200, "ok", new UserModel(1, "张三", 20, "张三号", this.server));
    }

    @Override
    @ApiOperation("查询用户通过服务器")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "server", value = "1", required = true, dataType = "String"),
            }
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successful — 请求已完成"),
                    @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
                    @ApiResponse(code = 401, message = "未授权客户机访问数据"),
                    @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
                    @ApiResponse(code = 500, message = "服务器不能完成请求")
            }
    )
    public XbinResult getUserByServer(String server) {
        return new XbinResult(200, "ok",
                mapper.selectByExample(new ActivityExample()));
    }
}
