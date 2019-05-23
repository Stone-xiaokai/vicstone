package com.macro.mall.pms.controller;

import com.macro.mall.dto.*;
import com.macro.mall.model.HzProduct;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.request.HzProductRequest;
import com.macro.mall.pms.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理Controller
 * https://gitee.com/zscat-platform/mall on 2018/4/26.
 */
@Controller
@Api(tags = "PmsProductController", description = "商品管理")
@RequestMapping("/product")
public class PmsProductController {
    @Autowired
    private PmsProductService productService;

    @ApiOperation("创建商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:create')")
    public Object create(@RequestBody PmsProductParam productParam, BindingResult bindingResult) {
        int count = productService.create(productParam);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("根据商品id获取商品编辑信息")
    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:read')")
    public Object getUpdateInfo(@PathVariable Long id) {
        PmsProductResult productResult = productService.getUpdateInfo(id);
        return new CommonResult().success(productResult);
    }

    @ApiOperation("更新商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:update')")
    public Object update(@PathVariable Long id, @RequestBody PmsProductParam productParam, BindingResult bindingResult) {
        int count = productService.update(id, productParam);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
//    @PreAuthorize("hasAuthority('pms:product:read')")
    public Object getList(PmsProductQueryParam productQueryParam,
                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = productService.list(productQueryParam, pageSize, pageNum);
        return new CommonResult().pageSuccess(productList);
    }
    @ApiOperation("查询商品")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
//    @PreAuthorize("hasAuthority('pms:product:read')")
    public Object selectByExample(@RequestBody HzProductRequest hzProductRequest) {
        List<HzProduct> productList = productService.selectByExample(hzProductRequest);
        return new CommonResult().pageSuccess(productList);
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    @ResponseBody
    public Object getList(String keyword) {
        List<PmsProduct> productList = productService.list(keyword);
        return new CommonResult().success(productList);
    }

    @ApiOperation("批量修改审核状态")
    @RequestMapping(value = "/update/verifyStatus", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:update')")
    public Object updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("verifyStatus") Integer verifyStatus,
                                     @RequestParam("detail") String detail) {
        int count = productService.updateVerifyStatus(ids, verifyStatus, detail);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }
    @ApiOperation("保存商品")
    @RequestMapping(value = "/save/product", method = RequestMethod.POST)
    @ResponseBody
    public Object saveProduct(HzProduct hzProduct) {
        System.out.println(hzProduct.getProductName());
        int count = productService.saveProduct(hzProduct);
        return new CommonResult().success(count);
    }

    @ApiOperation("根据用户id查询商品")
    @RequestMapping(value = "/select/product/{productUserId}/{isOrIsNot}", method = RequestMethod.GET)
    @ResponseBody
    public Object selectProduct(@PathVariable("productUserId") Integer productUserId,@PathVariable("isOrIsNot") Integer isOrIsNot) {
        List<HzProduct> list = productService.selectProductList(productUserId,isOrIsNot);
        return new CommonResult().success(list);
    }
    @ApiOperation("根据商品小类查询商品列表")
    @RequestMapping(value = "/select/productBySmallLei/{productSmallCategoryId}", method = RequestMethod.GET)
    @ResponseBody
    public Object selectProductBySmallLei(@PathVariable("productSmallCategoryId") Integer productSmallCategoryId) {
        List<HzProduct> list = productService.selectProductBySmallLei(productSmallCategoryId);
        return new CommonResult().success(list);
    }
    @ApiOperation("根据商品大类查询商品列表")
    @RequestMapping(value = "/select/productByBigLei/{productBigCategoryId}", method = RequestMethod.GET)
    @ResponseBody
    public Object selectProductByBigLei(@PathVariable("productBigCategoryId") Integer productBigCategoryId) {
        List<HzProduct> list = productService.selectProductByBigLei(productBigCategoryId);
        return new CommonResult().success(list);
    }
    @ApiOperation("根据商品小类查询商品列表")
    @RequestMapping(value = "/select/productBySmallLeiUser/{productSmallCategoryId}/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Object selectProductBySmallLeiUser(@PathVariable("productSmallCategoryId") Integer productSmallCategoryId,@PathVariable("userId") Integer userId) {
        List<HzProduct> list = productService.selectProductBySmallLeiUser(productSmallCategoryId,userId);
        return new CommonResult().success(list);
    }
    @ApiOperation("根据商品小类查询商品列表分页")
    @RequestMapping(value = "/select/productBySmallLeiPage/{productSmallCategoryId}", method = RequestMethod.GET)
    @ResponseBody
    public Object selectProductBySmallLeiPage(@PathVariable("productSmallCategoryId") Integer productSmallCategoryId,
                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<HzProduct> list = productService.selectProductBySmallLeiPage(productSmallCategoryId,pageSize,pageNum);
        return new CommonResult().pageSuccess(list);
    }

    @ApiOperation("根据商品name模糊查询商品列表")
    @RequestMapping(value = "/select/selectByMoHu/{productName}", method = RequestMethod.GET)
    @ResponseBody
    public Object selectByMoHu(@PathVariable("productName") String productName) {
        List<HzProduct> list = productService.selectByMoHu(productName);
        return new CommonResult().success(list);
    }
    @ApiOperation("根据商品name模糊查询商品列表")
    @RequestMapping(value = "/select/selectByMoHuUser/{productName}/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Object selectByMoHuUser(@PathVariable("productName") String productName,@PathVariable("userId") Integer userId) {
        List<HzProduct> list = productService.selectByMoHuUser(productName,userId);
        return new CommonResult().success(list);
    }

    @ApiOperation("根据物品id删除物品")
    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteProduct(@PathVariable("productId") Integer productId) {
        int count = productService.deleteProduct(productId);
        return new CommonResult().success(count);
    }

    @ApiOperation("根据商品id查询商品详情")
    @RequestMapping(value = "/select/productDetail/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public Object selectProductDetail(@PathVariable("productId") Integer productUserId) {
        HzProduct hzProduct = productService.selectProductDetail(productUserId);
        return new CommonResult().success(hzProduct);
    }
    @ApiOperation("批量上下架")
    @RequestMapping(value = "/update/publishStatus", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:update')")
    public Object updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                      @RequestParam("publishStatus") Integer publishStatus) {
        int count = productService.updatePublishStatus(ids, publishStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("商品上下架")
    @RequestMapping(value = "/update/productStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateProductStatus(@RequestParam("productId") Integer productId,
                                      @RequestParam("productStatus") Integer productStatus) {
        int count = productService.updateProductStatus(productId, productStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("商品改变分类")
    @RequestMapping(value = "/update/productCate", method = RequestMethod.POST)
    @ResponseBody
    public Object updateProductCate(@RequestParam("productId") Integer productId,
                                      @RequestParam("productSmallCate") Integer productSmallCate) {
        int count = productService.updateProductCate(productId, productSmallCate);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量推荐商品")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:update')")
    public Object updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("recommendStatus") Integer recommendStatus) {
        int count = productService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量设为新品")
    @RequestMapping(value = "/update/newStatus", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:update')")
    public Object updateNewStatus(@RequestParam("ids") List<Long> ids,
                                  @RequestParam("newStatus") Integer newStatus) {
        int count = productService.updateNewStatus(ids, newStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量修改删除状态")
    @RequestMapping(value = "/update/deleteStatus", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:delete')")
    public Object updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("deleteStatus") Integer deleteStatus) {
        int count = productService.updateDeleteStatus(ids, deleteStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }
}
