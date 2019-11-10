package com.lan.running.mapper;

import com.lan.running.bean.Log;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/11/6 11:26
 */
public interface LogMapper {
    int addLog(Log log);
    
    List<Log> getLogs();
    
    int getAllLoginLogs(String type);
    
    int getYesterdayLoginLogs(String type);

    int getTodayLoginLogs(String type);
    
    int getSevenDaysLogs(String type);

    int getThirtyDaysLogs(String type);
}
