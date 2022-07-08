package lk.project.marketing.backend.service.impl;

import lk.project.marketing.backend.repository.PromotionRuleManagementRepository;
import lk.project.marketing.backend.service.PromotionRuleManagementService;
import lk.project.marketing.base.bo.PromotionRuleBo;
import lk.project.marketing.base.entity.PromotionRule;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by alexlu on 2018/10/29.
 */
@Service
public class PromotionRuleManagementServiceImpl implements PromotionRuleManagementService {

    @Autowired
    PromotionRuleManagementRepository promotionRuleManagementRepository;

    @Override
    public Boolean savePromotionRule(PromotionRuleBo promotionRuleBo) {
        PromotionRule promotionRule = new PromotionRule();
        BeanUtils.copyProperties(promotionRuleBo,promotionRule);
        return promotionRuleManagementRepository.insertOrUpdate(promotionRule);
    }
}
