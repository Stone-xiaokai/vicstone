package com.macro.mall.oms.controller;

import com.macro.mall.dto.*;
import com.macro.mall.model.HzCollect;
import com.macro.mall.model.HzOrder;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.oms.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 订单管理Controller
 * https://gitee.com/zscat-platform/mall on 2018/10/11.
 */
@Controller
@Api(tags = "OmsOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService orderService;


    @ApiOperation("新增订单")
    @RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object insertOrder(@RequestBody HzOrder hzOrder) {
        System.out.println(hzOrder.getProductId()+" : "+hzOrder.getUserId());
        hzOrder.setCreateTime(new Date());
        int orderList = orderService.inserOrder(hzOrder);
        return new CommonResult().success(orderList);
    }

    @ApiOperation("新增收藏")
    @RequestMapping(value = "/insertCollect", method = RequestMethod.POST)
    @ResponseBody
    public Object insertCollect(@RequestBody HzCollect hzCollect) {
        hzCollect.setCollectCreateTime(new Date());
        int collectList = orderService.insertCollect(hzCollect);
        return new CommonResult().success(collectList);
    }

    @ApiOperation("根据用户id查询订单详情列表")
    @RequestMapping(value = "/getOrderDetailList/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getOrderDetailList(@PathVariable Integer userId) {
        List<OrderProductResult> orderList = orderService.getOrderDetailList(userId);
        return new CommonResult().pageSuccess(orderList);
    }

    @ApiOperation("查询订单列表")
    @RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
    @ResponseBody
    public Object getOrderList(@RequestBody OrderProductListResult orderProductListResult) {
        List<OrderProductListResult> orderList = orderService.getOrderList(orderProductListResult);
        return new CommonResult().pageSuccess(orderList);
    }

    @ApiOperation("根据用户id查询收藏详情列表")
    @RequestMapping(value = "/getCollectDetailList/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getCollectDetailList(@PathVariable Integer userId) {
        List<CollectProductResult> orderList = orderService.getCollectDetailList(userId);
        return new CommonResult().pageSuccess(orderList);
    }

    @ApiOperation(value = "根据商品id和用户id删除收藏")
    @RequestMapping(value = "/deleteCollect", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteCollect(@RequestBody HzCollect hzCollect) {
        System.out.println("productID:"+hzCollect.getCollectProductId());
        System.out.println("userID:"+hzCollect.getCollectUserId());
        Integer umsMember1 = orderService.deleteCollect(hzCollect.getCollectProductId(),hzCollect.getCollectUserId());
        if (umsMember1 !=0) {
            return new CommonResult().success(umsMember1);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("查询订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(OmsOrderQueryParam queryParam,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = orderService.list(queryParam, pageSize, pageNum);
        return new CommonResult().pageSuccess(orderList);
    }

    @ApiOperation("批量发货")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    @ResponseBody
    public Object delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList) {
        int count = orderService.delivery(deliveryParamList);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量关闭订单")
    @RequestMapping(value = "/update/close", method = RequestMethod.POST)
    @ResponseBody
    public Object close(@RequestParam("ids") List<Long> ids, @RequestParam String note) {
        int count = orderService.close(ids, note);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam("ids") List<Long> ids) {
        int count = orderService.delete(ids);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object detail(@PathVariable Long id) {
        OmsOrderDetail orderDetailResult = orderService.detail(id);
        return new CommonResult().success(orderDetailResult);
    }

    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateReceiverInfo(@RequestBody OmsReceiverInfoParam receiverInfoParam) {
        int count = orderService.updateReceiverInfo(receiverInfoParam);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateReceiverInfo(@RequestBody OmsMoneyInfoParam moneyInfoParam) {
        int count = orderService.updateMoneyInfo(moneyInfoParam);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note", method = RequestMethod.POST)
    @ResponseBody
    public Object updateNote(@RequestParam("id") Long id,
                             @RequestParam("note") String note,
                             @RequestParam("status") Integer status) {
        int count = orderService.updateNote(id, note, status);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}
