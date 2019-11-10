package com.lan.running.controller;

import com.lan.running.bean.Log;
import com.lan.running.service.LogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Vlan
 * Date: 2019/11/6 12:49
 */

@RestController
@RequestMapping("/log")
public class LogController {
    
    @Resource
    private LogService logService;
    
    @RequestMapping("/all")
    public Map<String,Object> getLogs(Integer page, Integer limit){
        List<Log> logs = logService.getLogs();
        List<Log> logs1 = null;
        int page1 = logs.size()/limit;
        if(logs.size() % limit !=0 && page1+1==page){
            logs1 = logs.subList(page * limit - limit, logs.size());
        }else {
            logs1 = logs.subList(page * limit - limit, page * limit-1);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",logs.size());
        map.put("data",logs1);
        return map;
    }

    @RequestMapping("/logAnalysis")
    public List getAnalysisLogs(){
        return logService.getAnalysisLogs();
    }
    
    
}
