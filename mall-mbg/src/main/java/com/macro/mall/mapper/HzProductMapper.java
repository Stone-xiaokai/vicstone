package com.macro.mall.mapper;

import com.macro.mall.model.HzProduct;
import com.macro.mall.model.request.HzProductRequest;
import org.apache.ibatis.annotations.Param;

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

    List<HzProduct> selectByBigLei(Integer productBigCategoryId);

    List<HzProduct> selectBySmallLeiUser(@Param("productSmallCategoryId") Integer productSmallCategoryId,@Param("userId") Integer userId);

    List<HzProduct> selectByMoHu(String productName);

    List<HzProduct> selectByMoHuUser(@Param("productName")String productName,@Param("userId")Integer userId);

    List<HzProduct> selectByExample(HzProductRequest hzProductRequest);

    int updateProductStatus(@Param("productId") Integer id,@Param("productStatus") Integer productStatus);

    int updateProductCate(@Param("productId") Integer id,@Param("productSmallCate") Integer productSmallCate);

}