package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.MemberProductCollection;

import java.util.List;

/**
 * 会员收藏Service
 * https://gitee.com/zscat-platform/mall on 2018/8/2.
 */
public interface MemberCollectionService {
    int addProduct(MemberProductCollection productCollection);

    int deleteProduct(Long memberId, Long productId);

    List<MemberProductCollection> listProduct(Long memberId,int type);
}
