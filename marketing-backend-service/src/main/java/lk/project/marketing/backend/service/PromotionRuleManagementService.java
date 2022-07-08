package lk.project.marketing.backend.service;

import lk.project.marketing.base.bo.ActivityReqBo;
import lk.project.marketing.base.bo.PromotionRuleBo;

/**
 * 促销规则后台管理服务
 * Created by luchao on 2018/12/25.
 */
public interface PromotionRuleManagementService {


    Boolean savePromotionRule(PromotionRuleBo promotionRuleBo);
}
