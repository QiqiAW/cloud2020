package com.qiww.springcloud.service.impl;

import com.qiww.springcloud.service.ITOrderService;
import com.qiww.springcloud.pojo.TOrder;
import com.qiww.springcloud.mapper.TOrderMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

}
