package com.macro.mall.mapper;

import com.macro.mall.dto.CollectProductResult;
import com.macro.mall.model.HzCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HzCollectMapper {
    int deleteByPrimaryKey(Integer collectId);

    int insert(HzCollect record);

    int insertSelective(HzCollect record);

    HzCollect selectByPrimaryKey(Integer collectId);

    int updateByPrimaryKeySelective(HzCollect record);

    int updateByPrimaryKey(HzCollect record);

    List<CollectProductResult> selectProductByUserId(Integer userId);

    int deleteByProductIdAndUserId(@Param("collectProductId") Integer collectProductId, @Param("collectUserId") Integer collectUserId);
}