package com.lan.running.service.impl;

import com.lan.running.bean.Log;
import com.lan.running.mapper.LogMapper;
import com.lan.running.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Vlan
 * Date: 2019/11/6 12:48
 */
@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogMapper logMapper;
    
    @Override
    public List<Log> getLogs() {
        return logMapper.getLogs();
    }

    @Override
    public int getYesterdayLoginLogs() {
        return logMapper.getYesterdayLoginLogs("登录");
    }

    @Override
    public int getSevenDaysLogs() {
        return logMapper.getSevenDaysLogs("登录");
    }

    @Override
    public List getAnalysisLogs() {
        Map<String,Object> dataMap1 = new HashMap<>();
        ArrayList list = new ArrayList();
        dataMap1.put("value",logMapper.getAllLoginLogs("登录"));
        dataMap1.put("name","总访问量");
        Map<String,Object> dataMap2 = new HashMap<>();
        dataMap2.put("value",logMapper.getThirtyDaysLogs("登录"));
        dataMap2.put("name","前三十天访问量");
        Map<String,Object> dataMap3 = new HashMap<>();
        dataMap3.put("value",logMapper.getSevenDaysLogs("登录"));
        dataMap3.put("name","前七天访问量");
        Map<String,Object> dataMap4 = new HashMap<>();
        dataMap4.put("value",logMapper.getYesterdayLoginLogs("登录"));
        dataMap4.put("name","前一天访问量");
        Map<String,Object> dataMap5 = new HashMap<>();
        dataMap5.put("value",logMapper.getTodayLoginLogs("登录"));
        dataMap5.put("name","今日访问量");
        list.add(dataMap1);
        list.add(dataMap2);
        list.add(dataMap3);
        list.add(dataMap4);
        list.add(dataMap5);
        return list;
    }
}
