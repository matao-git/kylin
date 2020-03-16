package com.matao.pervue.service.impl;

import com.matao.pervue.entity.Nation;
import com.matao.pervue.entity.NationVo;
import com.matao.pervue.mapper.NationMapper;
import com.matao.pervue.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 城市字典表 服务实现类
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {
    @Autowired
    private NationMapper nationMapper;

    @Override
    public List<NationVo> findAll() {
        return nationMapper.findAll();
    }
}
