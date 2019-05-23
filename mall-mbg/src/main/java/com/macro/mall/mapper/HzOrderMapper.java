package com.macro.mall.mapper;

import com.macro.mall.dto.OrderProductListResult;
import com.macro.mall.dto.OrderProductResult;
import com.macro.mall.model.HzOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HzOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(HzOrder record);

    int insertSelective(HzOrder record);

    HzOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(HzOrder record);

    int updateByPrimaryKey(HzOrder record);

    List<OrderProductResult> selectProductByUserId(Integer userId);

    List<OrderProductListResult> selectOrderList(OrderProductListResult orderProductListResult);

}