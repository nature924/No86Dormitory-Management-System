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


import com.dao.ChurususheDao;
import com.entity.ChurususheEntity;
import com.service.ChurususheService;
import com.entity.vo.ChurususheVO;
import com.entity.view.ChurususheView;

@Service("churususheService")
public class ChurususheServiceImpl extends ServiceImpl<ChurususheDao, ChurususheEntity> implements ChurususheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChurususheEntity> page = this.selectPage(
                new Query<ChurususheEntity>(params).getPage(),
                new EntityWrapper<ChurususheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChurususheEntity> wrapper) {
		  Page<ChurususheView> page =new Query<ChurususheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChurususheVO> selectListVO(Wrapper<ChurususheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChurususheVO selectVO(Wrapper<ChurususheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChurususheView> selectListView(Wrapper<ChurususheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChurususheView selectView(Wrapper<ChurususheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
