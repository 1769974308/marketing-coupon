package lk.project.marketing.backend.api.controller;

import lk.project.marketing.client.dto.ActivityReqDto;
import lk.project.marketing.client.rpc.ActivityManagementInterface;
import lk.project.marketing.client.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ASUS
 * @date 2022/7/7
 */
@RestController
@RequestMapping("/backend/activity")
public class ActivityManagementController {

    @Autowired
    ActivityManagementInterface activityManagementInterface;

    @PostMapping("/saveActivity")
    public ResponseVO saveActivity(@RequestBody ActivityReqDto activityReqDto){
        return activityManagementInterface.saveActivity(activityReqDto);
    }
}
