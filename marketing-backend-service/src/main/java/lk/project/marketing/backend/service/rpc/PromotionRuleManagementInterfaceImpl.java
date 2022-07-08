package lk.project.marketing.backend.service.rpc;

import lk.project.marketing.backend.service.PromotionRuleManagementService;
import lk.project.marketing.backend.service.rpc.pojo.BaseResponse;
import lk.project.marketing.base.bo.PromotionRuleBo;
import lk.project.marketing.client.dto.PromotionRuleReqDto;
import lk.project.marketing.client.rpc.PromotionRuleManagementInterface;
import lk.project.marketing.client.vo.ResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ASUS
 * @date 2022/7/8
 */
public class PromotionRuleManagementInterfaceImpl extends BaseResponse implements PromotionRuleManagementInterface {
    @Autowired
    private PromotionRuleManagementService promotionRuleManagementService;

    @Override
    public ResponseVO savePromotionRule(PromotionRuleReqDto promotionRuleReqDto) {

        PromotionRuleBo promotionRuleBo = new PromotionRuleBo();
        BeanUtils.copyProperties(promotionRuleReqDto,promotionRuleBo);
        return getFromData(promotionRuleManagementService.savePromotionRule(promotionRuleBo));
    }
}
