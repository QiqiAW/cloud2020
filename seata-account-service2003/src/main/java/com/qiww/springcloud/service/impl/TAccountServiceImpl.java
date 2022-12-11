package com.qiww.springcloud.service.impl;

import com.qiww.springcloud.mapper.TAccountMapper;
import com.qiww.springcloud.service.ITAccountService;
import com.qiww.springcloud.pojo.TAccount;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements ITAccountService {

}
