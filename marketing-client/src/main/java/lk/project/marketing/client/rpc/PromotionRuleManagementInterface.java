package lk.project.marketing.client.rpc;

import lk.project.marketing.client.dto.AccountRuleReqDto;
import lk.project.marketing.client.dto.PromotionRuleReqDto;
import lk.project.marketing.client.vo.ResponseVO;

/**
 * @author ASUS
 * @date 2022/7/8
 */
public interface PromotionRuleManagementInterface {

    /**
     * 新增或更新促销规则
     * @param promotionRuleReqDto
     * @return
     */
    ResponseVO savePromotionRule(PromotionRuleReqDto promotionRuleReqDto);
}
