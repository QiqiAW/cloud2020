package com.qiww.springcloud.service;

import com.qiww.springcloud.entities.CommonResult;
import com.qiww.springcloud.entities.vo.StorageVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("seata-storage-service")
@RequestMapping("/t-storage")
@RestController
public interface StorageService {
    @PostMapping("reduceInventory")
    public CommonResult ri(@RequestBody StorageVo storageVo);
}
