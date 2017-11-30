package cn.coderss.college.service.impl;

import cn.coderss.college.service.CollegeService;
import cn.coderss.model.CollegeModel;
import cn.coderss.model.XbinResult;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午2:35
 */
@Api(value = "API - CollegeServiceImpl", description = "college 服务")
@RestController
@RefreshScope
public class CollegeServiceImpl implements CollegeService{

    @Value("${info.server}")
    private String server;
    Logger logger = LoggerFactory.getLogger(CollegeServiceImpl.class);

    @Override
    @ApiOperation("查询学院通过学院编码")
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
    public XbinResult getCollegeByCode(String code) {
        return new XbinResult(200, "ok", new CollegeModel(1, "学院1", "20", this.server));
    }

    @Override
    @ApiOperation("查询学院通过学院名")
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
    public XbinResult getCollegeByName(String name) {
        return new XbinResult(200, "ok", new CollegeModel(1, "学院1", "20", this.server));
    }

    @Override
    @ApiOperation("查询学院通过服务名")
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
    public XbinResult getCollegeByServer(String server){
//        return new XbinResult(200, "ok", new CollegeModel(1, "学院1", "20", this.server));
        throw new RuntimeException("这是一个错误");
    }

    @Override
    @ApiOperation("id获取")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "id", value = "", required = true, dataType = "int"),
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
    public XbinResult getCollegeById(Integer id) {
        logger.info("getCollegeById:"+id.toString());
        return new XbinResult(200, "ok", new CollegeModel(1, "getCollegeById", "20", this.server));
    }

    @Override
    @ApiOperation("ids获取")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "ids", value = "", required = true, dataType = "List"),
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
    public List<XbinResult> getCollegeByIds(List<Integer> ids) {
        logger.info("Thread.name:"+Thread.currentThread().getName());
        List<XbinResult> list = new ArrayList<XbinResult>();
        for (Integer id : ids){
            list.add(new XbinResult(200, "ok", new CollegeModel(id, "ids", "20", this.server)));
        }
        return list;
    }
}
