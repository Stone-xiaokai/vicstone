package com.macro.mall.pms.service;

import com.macro.mall.dto.HZ_Product;
import com.macro.mall.dto.PmsProductParam;
import com.macro.mall.dto.PmsProductQueryParam;
import com.macro.mall.dto.PmsProductResult;
import com.macro.mall.model.HzProduct;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.request.HzProductRequest;
import io.swagger.models.auth.In;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品管理Service
 * https://gitee.com/zscat-platform/mall on 2018/4/26.
 */
public interface PmsProductService {
    /**
     * 创建商品
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    int create(PmsProductParam productParam);

    /**
     * 根据商品编号获取更新信息
     */
    PmsProductResult getUpdateInfo(Long id);

    /**
     * 更新商品
     */
    @Transactional
    int update(Long id, PmsProductParam productParam);

    /**
     * 分页查询商品
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量修改审核状态
     *
     * @param ids          产品id
     * @param verifyStatus 审核状态
     * @param detail       审核详情
     */
    @Transactional
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 批量修改商品上架状态
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改商品推荐状态
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量修改新品状态
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量删除商品
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 根据商品名称或者货号模糊查询
     */
    List<PmsProduct> list(String keyword);

    int saveProduct(HzProduct hzProduct);

    List<HzProduct> selectProductList(Integer productUserId,Integer selectParam);

    HzProduct selectProductDetail(Integer productId);

    List<HzProduct> selectProductBySmallLei(Integer productSmallCategoryId);

    List<HzProduct> selectProductBySmallLeiPage(Integer productSmallCategoryId,Integer pageSize, Integer pageNum);

    List<HzProduct> selectProductByBigLei(Integer productBigCategoryId);

    List<HzProduct> selectProductBySmallLeiUser(Integer productSmallCategoryId,Integer userId);

    List<HzProduct> selectByMoHu(String productName);

    List<HzProduct> selectByMoHuUser(String productName,Integer userId);

    int deleteProduct(Integer productId);

    List<HzProduct> selectByExample(HzProductRequest hzProductRequest);

    int updateProductStatus(Integer productId,Integer productStatus);

    int updateProductCate(Integer productId,Integer productSmallCate);
}
