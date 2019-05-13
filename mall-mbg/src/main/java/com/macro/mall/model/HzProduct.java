package com.macro.mall.model;

public class HzProduct {
    private Integer productId;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand == null ? null : productBrand.trim();
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
        this.productAddress = productAddress == null ? null : productAddress.trim();
    }

    public String getProductText() {
        return productText;
    }

    public void setProductText(String productText) {
        this.productText = productText == null ? null : productText.trim();
    }

    public String getProductSrcOne() {
        return productSrcOne;
    }

    public void setProductSrcOne(String productSrcOne) {
        this.productSrcOne = productSrcOne == null ? null : productSrcOne.trim();
    }

    public String getProductSrcTwo() {
        return productSrcTwo;
    }

    public void setProductSrcTwo(String productSrcTwo) {
        this.productSrcTwo = productSrcTwo == null ? null : productSrcTwo.trim();
    }

    public String getProductSrcThree() {
        return productSrcThree;
    }

    public void setProductSrcThree(String productSrcThree) {
        this.productSrcThree = productSrcThree == null ? null : productSrcThree.trim();
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus == null ? null : productStatus.trim();
    }

    public Integer getProductUserId() {
        return productUserId;
    }

    public void setProductUserId(Integer productUserId) {
        this.productUserId = productUserId;
    }

    public String getProductRecommend() {
        return productRecommend;
    }

    public void setProductRecommend(String productRecommend) {
        this.productRecommend = productRecommend == null ? null : productRecommend.trim();
    }
}