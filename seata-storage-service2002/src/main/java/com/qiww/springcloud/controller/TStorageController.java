package com.qiww.springcloud.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import com.qiww.springcloud.entities.CommonResult;
import com.qiww.springcloud.entities.vo.StorageVo;
import com.qiww.springcloud.service.ITStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qiww.springcloud.pojo.TStorage;


@RequestMapping("/t-storage")
@RestController
public class TStorageController {
    @Autowired
    ITStorageService itStorageService;
    @PostMapping("reduceInventory")
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)

    public CommonResult ri(@RequestBody StorageVo storageVo){
//        RootContext.bind(storageVo.getXid()); 设置xid
        TStorage tStorage1 = itStorageService.getBaseMapper().selectById(storageVo.getId());
        if(tStorage1==null){
            return new CommonResult(400,"未找到哦");
        }
        tStorage1.setUsed(tStorage1.getUsed()+storageVo.getNumber());
        tStorage1.setResidue(tStorage1.getResidue()-storageVo.getNumber());
        UpdateWrapper<TStorage> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",storageVo.getId());
        int update = itStorageService.getBaseMapper().update(tStorage1, updateWrapper);
        System.out.println("--商品服务的xid: "+ GlobalTransactionContext.getCurrent().getXid());
        if(update==1){
            return new CommonResult(200,"修改成功");
        }
        return new CommonResult(4444,"修改失败");
    }

}
