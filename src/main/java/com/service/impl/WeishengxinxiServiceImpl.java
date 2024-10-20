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


import com.dao.WeishengxinxiDao;
import com.entity.WeishengxinxiEntity;
import com.service.WeishengxinxiService;
import com.entity.vo.WeishengxinxiVO;
import com.entity.view.WeishengxinxiView;

@Service("weishengxinxiService")
public class WeishengxinxiServiceImpl extends ServiceImpl<WeishengxinxiDao, WeishengxinxiEntity> implements WeishengxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeishengxinxiEntity> page = this.selectPage(
                new Query<WeishengxinxiEntity>(params).getPage(),
                new EntityWrapper<WeishengxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeishengxinxiEntity> wrapper) {
		  Page<WeishengxinxiView> page =new Query<WeishengxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeishengxinxiVO> selectListVO(Wrapper<WeishengxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeishengxinxiVO selectVO(Wrapper<WeishengxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeishengxinxiView> selectListView(Wrapper<WeishengxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeishengxinxiView selectView(Wrapper<WeishengxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
