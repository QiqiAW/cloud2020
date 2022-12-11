package com.qiww.springcloud.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qiww.springcloud.entities.CommonResult;
import com.qiww.springcloud.entities.vo.OrderVo;
import com.qiww.springcloud.entities.vo.StorageVo;
import com.qiww.springcloud.pojo.TOrder;
import com.qiww.springcloud.service.AccountService;
import com.qiww.springcloud.service.ITOrderService;
import com.qiww.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 */
@RequestMapping("/t-order")
@RestController
public class TOrderController {
    @Autowired
    ITOrderService itOrderService;
    @Autowired
    AccountService accountService;
    @Autowired
    StorageService storageService;
    @PostMapping("create")
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public CommonResult create(@RequestBody OrderVo orderVo) {
        TOrder tOrder = covers(orderVo);
        //添加订单
        int insert = itOrderService.getBaseMapper().insert(tOrder);
        if (insert == 0)
            return new CommonResult(444, "订单异常,可能是参数原因导致!");
        //扣除商品数量
        StorageVo storageVo = new StorageVo();
        storageVo.setId(orderVo.getProductId());
        storageVo.setNumber(orderVo.getCount());
        if(orderVo.getSuccess()==1){
            throw  new RuntimeException();
        }
//        如果只导入seata-spring-boot-starter包不导入spring-cloud-starter-alibaba-seata 则需要手动传递xid
//        String xid = GlobalTransactionContext.getCurrent().getXid();
//        storageVo.setXid(xid);
//        System.out.println("--订单服务的xid: "+xid);
        CommonResult ri = storageService.ri(storageVo);
        System.out.println("扣除商品数量返回:"+ri);
        //扣除金额
        storageVo.setId(orderVo.getUserId());
        storageVo.setNumber(orderVo.getCount()* orderVo.getMoney());
        if(orderVo.getSuccess()==2){
            throw  new RuntimeException();
        }
        CommonResult result = null;
         result = accountService.result(storageVo);
        System.out.println("扣除金额返回:"+result);
        //修改订单状态
        if (tOrder.getStatus() == 0)
            tOrder.setStatus(1);
        else
            return new CommonResult(444, "订单状态异常,请debug查看");
        if(orderVo.getSuccess()==3){
            throw  new RuntimeException();
        }
            int  id = itOrderService.getBaseMapper().update(tOrder, new UpdateWrapper<TOrder>().eq("id", tOrder.getId()));
        if (id == 1)
            return new CommonResult(200, "订单完成");
        return new CommonResult(400, "订单未完成");

    }

    private TOrder covers(OrderVo orderVo) {
        TOrder tOrder = new TOrder();
        tOrder.setCount(orderVo.getCount());
        tOrder.setMoney(orderVo.getMoney());
        tOrder.setProductId(orderVo.getProductId());
        tOrder.setUserId(orderVo.getUserId());
        tOrder.setStatus(0);
        return tOrder;
    }
}
