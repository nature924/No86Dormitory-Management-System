package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShuidianfeiDao;
import com.entity.ShuidianfeiEntity;
import com.service.ShuidianfeiService;
import com.entity.vo.ShuidianfeiVO;
import com.entity.view.ShuidianfeiView;

@Service("shuidianfeiService")
public class ShuidianfeiServiceImpl extends ServiceImpl<ShuidianfeiDao, ShuidianfeiEntity> implements ShuidianfeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShuidianfeiEntity> page = this.selectPage(
                new Query<ShuidianfeiEntity>(params).getPage(),
                new EntityWrapper<ShuidianfeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShuidianfeiEntity> wrapper) {
		  Page<ShuidianfeiView> page =new Query<ShuidianfeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShuidianfeiVO> selectListVO(Wrapper<ShuidianfeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShuidianfeiVO selectVO(Wrapper<ShuidianfeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShuidianfeiView> selectListView(Wrapper<ShuidianfeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShuidianfeiView selectView(Wrapper<ShuidianfeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
