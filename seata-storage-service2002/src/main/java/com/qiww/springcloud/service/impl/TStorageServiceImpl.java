package com.qiww.springcloud.service.impl;

import com.qiww.springcloud.pojo.TStorage;
import com.qiww.springcloud.mapper.TStorageMapper;
import com.qiww.springcloud.service.ITStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TStorageServiceImpl extends ServiceImpl<TStorageMapper, TStorage> implements ITStorageService {

}
