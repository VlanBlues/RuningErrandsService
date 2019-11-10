package com.lan.running.service;

import com.lan.running.bean.Log;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/11/6 12:47
 */
public interface LogService {
    List<Log> getLogs();

    int getYesterdayLoginLogs();

    int getSevenDaysLogs();

    List getAnalysisLogs();
}
