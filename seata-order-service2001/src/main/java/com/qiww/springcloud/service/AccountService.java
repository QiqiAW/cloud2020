package com.qiww.springcloud.service;

import com.qiww.springcloud.entities.CommonResult;
import com.qiww.springcloud.entities.vo.StorageVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient("seata-account-service")
@RequestMapping("/t-account")
@RestController
public interface AccountService {
    @PostMapping("reduceInventory")
    public CommonResult result(@RequestBody StorageVo storageVo);
}
