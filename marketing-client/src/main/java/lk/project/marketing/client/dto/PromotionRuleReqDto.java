package lk.project.marketing.client.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ASUS
 * @date 2022/7/8
 */
@Data
public class PromotionRuleReqDto implements Serializable {
    /**
     * 促销活动规则ID
     */
    private Long id;
    /**
     * 促销活动ID
     */
    private Long activityId;
    /**
     * 规则名称
     */
    private String ruleName;
    /**
     * 规则类型 0:发放规则;1:使用规则
     */
    private Integer ruleType;
    /**
     * 用户适用条件 json字符串
     */
    private String userCondition;
    /**
     * 商品或服务适用条件 json字符串
     */
    private String skuCondition;
    /**
     * 订单适用条件 json字符串
     */
    private String orderCondition;
    /**
     * 适用时间范围条件 条件表达式
     */
    private String timeCondition;
    /**
     * 其他使用范围条件 json字符串
     */
    private String extrasCondition;
}
