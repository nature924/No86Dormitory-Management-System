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


import com.dao.WeixiuxinxiDao;
import com.entity.WeixiuxinxiEntity;
import com.service.WeixiuxinxiService;
import com.entity.vo.WeixiuxinxiVO;
import com.entity.view.WeixiuxinxiView;

@Service("weixiuxinxiService")
public class WeixiuxinxiServiceImpl extends ServiceImpl<WeixiuxinxiDao, WeixiuxinxiEntity> implements WeixiuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiuxinxiEntity> page = this.selectPage(
                new Query<WeixiuxinxiEntity>(params).getPage(),
                new EntityWrapper<WeixiuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiuxinxiEntity> wrapper) {
		  Page<WeixiuxinxiView> page =new Query<WeixiuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeixiuxinxiVO> selectListVO(Wrapper<WeixiuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiuxinxiVO selectVO(Wrapper<WeixiuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiuxinxiView> selectListView(Wrapper<WeixiuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiuxinxiView selectView(Wrapper<WeixiuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
