package com.macro.mall.ums.service;

import com.macro.mall.dto.ProductCateCount;
import com.macro.mall.dto.UserCityCount;
import com.macro.mall.model.UmsMember;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品品牌Service
 * https://gitee.com/zscat-platform/mall on 2018/4/26.
 */
public interface UmsMemberService {
    List<UmsMember> listAllMember();

    int createMember(UmsMember UmsMember);

    @Transactional
    int updateMember(Long id, UmsMember UmsMember);

    int deleteMember(Long id);

    int deleteMember(List<Long> ids);

    List<UmsMember> listMember(String keyword, int pageNum, int pageSize);

    UmsMember getMember(Long id);

    UmsMember selectByNameAndPassWord(String username,String password);

    int insertUser(UmsMember umsMember);

    int updateAddressById(String city,Long userId);

    int selectOrderCount();

    int selectProductCount();

    int selectProductCountByStatus(String productStatus);

    int selectUserCount();

    List<ProductCateCount> selectProductCountCate();

    List<UserCityCount> selectUserCityCount();
}
