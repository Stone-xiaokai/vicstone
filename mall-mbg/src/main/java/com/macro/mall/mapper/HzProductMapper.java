package com.macro.mall.mapper;

import com.macro.mall.model.HzProduct;

import java.util.List;

public interface HzProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(HzProduct record);

    int insertSelective(HzProduct record);

    HzProduct selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(HzProduct record);

    int updateByPrimaryKey(HzProduct record);

    List<HzProduct> selectByIsUser(Integer productUserId);

    List<HzProduct> selectByIsNotUser(Integer productUserId);

    List<HzProduct> selectBySmallLei(Integer productSmallCategoryId);

    List<HzProduct> selectByMoHu(String productName);
}