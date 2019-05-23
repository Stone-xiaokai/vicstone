package com.macro.mall.mapper;

import com.macro.mall.dto.ProductCateCount;

import java.util.List;

public interface HomeMapper {
    int selectOrderCount();

    int selectProductCount();

    int selectProductCountByStatus(String productStatus);

    int selectUserCount();

    List<ProductCateCount> selectProductCateCount();
}
