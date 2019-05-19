package com.macro.mall.dto;

import java.util.Date;

public class OrderProductResult {
    private Integer orderId;

    private Integer userId;

    private Integer productId;

    private Date createTime;

    private String productName;

    private String productBrand;

    private Long productPrice;

    private Integer productBigCategoryId;

    private Integer productSmallCategoryId;

    private String productAddress;

    private String productText;

    private String productSrcOne;

    private String productSrcTwo;

    private String productSrcThree;

    private String productStatus;

    private Integer productUserId;

    private String productRecommend;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductBigCategoryId() {
        return productBigCategoryId;
    }

    public void setProductBigCategoryId(Integer productBigCategoryId) {
        this.productBigCategoryId = productBigCategoryId;
    }

    public Integer getProductSmallCategoryId() {
        return productSmallCategoryId;
    }

    public void setProductSmallCategoryId(Integer productSmallCategoryId) {
        this.productSmallCategoryId = productSmallCategoryId;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }

    public String getProductText() {
        return productText;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }

    public String getProductSrcOne() {
        return productSrcOne;
    }

    public void setProductSrcOne(String productSrcOne) {
        this.productSrcOne = productSrcOne;
    }

    public String getProductSrcTwo() {
        return productSrcTwo;
    }

    public void setProductSrcTwo(String productSrcTwo) {
        this.productSrcTwo = productSrcTwo;
    }

    public String getProductSrcThree() {
        return productSrcThree;
    }

    public void setProductSrcThree(String productSrcThree) {
        this.productSrcThree = productSrcThree;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductRecommend() {
        return productRecommend;
    }

    public void setProductRecommend(String productRecommend) {
        this.productRecommend = productRecommend;
    }

    public Integer getProductUserId() {
        return productUserId;
    }

    public void setProductUserId(Integer productUserId) {
        this.productUserId = productUserId;
    }
}