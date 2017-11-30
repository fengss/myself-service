package cn.coderss.college.service.hystrix;

import cn.coderss.college.service.CollegeService;
import cn.coderss.model.CollegeModel;
import cn.coderss.model.XbinResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午2:28
 */
@Component
public class CollegeServiceHystrix implements CollegeService{
    @Override
    public XbinResult getCollegeByCode(String code) {
        return null;
    }

    @Override
    public XbinResult getCollegeByName(String name) {
        return null;
    }

    @Override
    public XbinResult getCollegeByServer(String server) {
        return new XbinResult(200,"ok",
                new CollegeModel(1,"hystrix", "hystrix", "hystrix"));
    }

    @Override
    public XbinResult getCollegeById(Integer id) {
        return null;
    }

    @Override
    public List<XbinResult> getCollegeByIds(List<Integer> ids) {
        return null;
    }
}
