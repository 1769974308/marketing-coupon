package lk.project.marketing.backend.service.rpc;

import lk.project.marketing.backend.service.ActivityManagementService;
import lk.project.marketing.backend.service.rpc.pojo.BaseResponse;
import lk.project.marketing.base.bo.ActivityReqBo;
import lk.project.marketing.client.dto.ActivityReqDto;
import lk.project.marketing.client.rpc.ActivityManagementInterface;
import lk.project.marketing.client.vo.ResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ActivityManagementInterfaceImpl extends BaseResponse implements ActivityManagementInterface {

    @Autowired
    private ActivityManagementService activityManagementService;


    @Override
    public ResponseVO saveActivity(ActivityReqDto activityReqDto) {
        ActivityReqBo activityReqBo = new ActivityReqBo();
        BeanUtils.copyProperties(activityReqDto,activityReqBo);
        return getFromData(activityManagementService.saveActivity(activityReqBo));
    }
}
