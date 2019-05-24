package com.macro.mall.mapper;

import com.macro.mall.dto.ProductCateCount;
import com.macro.mall.dto.UserCityCount;

import java.util.List;

public interface HomeMapper {
    int selectOrderCount();

    int selectProductCount();

    int selectProductCountByStatus(String productStatus);

    int selectUserCount();

    List<ProductCateCount> selectProductCateCount();

    List<UserCityCount> selectUserCityCount();
}
