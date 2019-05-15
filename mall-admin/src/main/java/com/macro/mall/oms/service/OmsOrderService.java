package com.macro.mall.oms.service;

import com.macro.mall.dto.*;
import com.macro.mall.model.HzCollect;
import com.macro.mall.model.HzOrder;
import com.macro.mall.model.OmsOrder;
import io.swagger.models.auth.In;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单管理Service
 * https://gitee.com/zscat-platform/mall on 2018/10/11.
 */
public interface OmsOrderService {
    /**
     * 订单查询
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量发货
     */
    @Transactional
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     */
    @Transactional
    int close(List<Long> ids, String note);

    /**
     * 批量删除订单
     */
    int delete(List<Long> ids);

    /**
     * 获取指定订单详情
     */
    OmsOrderDetail detail(Long id);

    /**
     * 修改订单收货人信息
     */
    @Transactional
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * 修改订单费用信息
     */
    @Transactional
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     */
    @Transactional
    int updateNote(Long id, String note, Integer status);

    List<OmsOrder> listALl();

    int inserOrder(HzOrder hzOrder);

    List<OrderProductResult> getOrderDetailList(Integer userId);

    int insertCollect(HzCollect hzCollect);

    List<CollectProductResult> getCollectDetailList(Integer userId);

    int deleteCollect(Integer collectProductId,Integer collectUserId);
}
