package cn.coderss.enterprise.service.impl;

import cn.coderss.enterprise.service.EnterpriseService;
import cn.coderss.model.CollegeModel;
import cn.coderss.model.EnterpriseModel;
import cn.coderss.model.XbinResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午2:43
 */
@Api(value = "API - CollegeServiceImpl", description = "college 服务")
@RestController
@RefreshScope
public class EnterpriseServiceImpl implements EnterpriseService{

    @Value("${info.server}")
    private String server;

    @Override
    @ApiOperation("查询企业通过企业编码")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "code", value = "", required = true, dataType = "String"),
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
    public XbinResult getEnterpriseByCode(String code) {
        return new XbinResult(200, "ok", new EnterpriseModel(1, "企业1", "20", this.server));
    }

    @Override
    @ApiOperation("查询企业通过企业名称")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "name", value = "", required = true, dataType = "String"),
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
    public XbinResult getEnterpriseByName(String name) {
        return new XbinResult(200, "ok", new EnterpriseModel(1, "企业1", "20", this.server));
    }

    @Override
    @ApiOperation("查询企业通过服务器名")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "server", value = "", required = true, dataType = "String"),
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
    public XbinResult getEnterpriseByServer(String server) {
        return new XbinResult(200, "ok", new EnterpriseModel(1, "企业1", "20", this.server));
    }
}
