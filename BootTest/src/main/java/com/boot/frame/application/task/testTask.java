package com.boot.frame.application.task;

import com.secoo.schedule.AbsRunOnceScheduleTaskDeal;
import org.springframework.stereotype.Service;

/**
 * Created by HYF on 2018/4/18.
 */
@Service("testAddressTask")
public class testTask extends AbsRunOnceScheduleTaskDeal {

    @Override
    public boolean execute(String taskParameter, String ownSign) throws Exception {
        try{
            System.out.println("-------testAddressTask-----"+System.currentTimeMillis()+"---testAddressTask----------");
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
