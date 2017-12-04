package cn.coderss.college.controller;

import cn.coderss.college.service.CollegeService;
import cn.coderss.college.service.MyService;
import cn.coderss.model.XbinResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午2:54
 */
@Controller
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @Autowired
    private MyService service;

    @RequestMapping("/test")
    public String test(String username, Model model){
        XbinResult result = collegeService.getCollegeByServer("1");
        collegeService.getCollegeByName("1");
        collegeService.getCollegeByCode("1");
        model.addAttribute("data", result.getData().toString());
        return "college";
    }


    @RequestMapping("/collapser")
    @ResponseBody
    public String collapser() throws InterruptedException, ExecutionException {
        Future<String> f1 = service.getId("1");
        Future<String> f2 = service.getId("2");
        String result1 = f1.get();
        String result2 = f2.get();

        collegeService.getCollegeById(1);
        collegeService.getCollegeById(2);
        XbinResult result = collegeService.getCollegeById(3);
        System.out.println(result.toString());
        return result1+result2;
    }
}
