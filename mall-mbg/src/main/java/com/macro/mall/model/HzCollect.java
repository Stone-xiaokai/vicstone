package com.macro.mall.model;

import java.util.Date;

public class HzCollect {
    private Integer collectId;

    private Integer collectUserId;

    private Integer collectProductId;

    private Date collectCreateTime;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getCollectUserId() {
        return collectUserId;
    }

    public void setCollectUserId(Integer collectUserId) {
        this.collectUserId = collectUserId;
    }

    public Integer getCollectProductId() {
        return collectProductId;
    }

    public void setCollectProductId(Integer collectProductId) {
        this.collectProductId = collectProductId;
    }

    public Date getCollectCreateTime() {
        return collectCreateTime;
    }

    public void setCollectCreateTime(Date collectCreateTime) {
        this.collectCreateTime = collectCreateTime;
    }
}