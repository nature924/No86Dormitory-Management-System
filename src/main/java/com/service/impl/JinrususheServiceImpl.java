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


import com.dao.JinrususheDao;
import com.entity.JinrususheEntity;
import com.service.JinrususheService;
import com.entity.vo.JinrususheVO;
import com.entity.view.JinrususheView;

@Service("jinrususheService")
public class JinrususheServiceImpl extends ServiceImpl<JinrususheDao, JinrususheEntity> implements JinrususheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JinrususheEntity> page = this.selectPage(
                new Query<JinrususheEntity>(params).getPage(),
                new EntityWrapper<JinrususheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JinrususheEntity> wrapper) {
		  Page<JinrususheView> page =new Query<JinrususheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JinrususheVO> selectListVO(Wrapper<JinrususheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JinrususheVO selectVO(Wrapper<JinrususheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JinrususheView> selectListView(Wrapper<JinrususheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JinrususheView selectView(Wrapper<JinrususheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
