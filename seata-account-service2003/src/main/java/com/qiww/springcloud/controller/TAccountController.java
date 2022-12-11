package com.qiww.springcloud.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qiww.springcloud.entities.CommonResult;
import com.qiww.springcloud.entities.vo.StorageVo;
import io.seata.tm.api.GlobalTransactionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.qiww.springcloud.pojo.TAccount;
import com.qiww.springcloud.service.ITAccountService;

/**
 * <p>
 *  前端控制器
 * </p>
 */

@RequestMapping("/t-account")
@RestController
public class TAccountController {
    @Autowired
    ITAccountService itAccountService;
    @PostMapping("reduceInventory")
    public CommonResult result(@RequestBody StorageVo storageVo){
//        RootContext.bind(storageVo.getXid());  设置xid
        TAccount account = itAccountService.getBaseMapper().selectOne(new QueryWrapper<TAccount>().eq("user_id", storageVo.getId()));
        if(account==null){
            return new CommonResult(400,"未找到哦");
        }
        account.setUsed(account.getUsed()+storageVo.getNumber());
        account.setResidue(account.getResidue()-storageVo.getNumber());
        UpdateWrapper<TAccount> tAccountUpdateWrapper = new UpdateWrapper<>();
        tAccountUpdateWrapper.eq("id",storageVo.getId());
        int update = itAccountService.getBaseMapper().update(account, tAccountUpdateWrapper);
        System.out.println("--金额服务的xid: "+ GlobalTransactionContext.getCurrent().getXid());
        if(true){
            throw new RuntimeException();
        }
        if(update==1){
            return new CommonResult(200,"修改成功");
        }
        return new CommonResult(4444,"修改失败");
    }

}
