package lk.project.marketing.backend.api.controller;

import lk.project.marketing.backend.api.common.BaseController;
import lk.project.marketing.client.dto.AccountRuleReqDto;
import lk.project.marketing.client.dto.PromotionRuleReqDto;
import lk.project.marketing.client.rpc.PromotionRuleManagementInterface;
import lk.project.marketing.client.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ASUS
 * @date 2022/7/8
 */
@RestController
@RequestMapping("/backend/promotionRule")
public class PromotionRuleManagementController extends BaseController {

    @Autowired
    PromotionRuleManagementInterface promotionRuleManagementInterface;

    /**
     * 新增或修改促销规则
     * @param promotionRuleReqDto
     * @return
     */
    @PostMapping("/savePromotionRule")
    public ResponseVO savePromotionRule(@RequestBody PromotionRuleReqDto promotionRuleReqDto){
        return promotionRuleManagementInterface.savePromotionRule(promotionRuleReqDto);
    }
}
