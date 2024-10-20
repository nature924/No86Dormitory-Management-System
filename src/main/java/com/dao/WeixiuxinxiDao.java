package com.dao;

import com.entity.WeixiuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeixiuxinxiVO;
import com.entity.view.WeixiuxinxiView;


/**
 * 维修信息
 * 
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
public interface WeixiuxinxiDao extends BaseMapper<WeixiuxinxiEntity> {
	
	List<WeixiuxinxiVO> selectListVO(@Param("ew") Wrapper<WeixiuxinxiEntity> wrapper);
	
	WeixiuxinxiVO selectVO(@Param("ew") Wrapper<WeixiuxinxiEntity> wrapper);
	
	List<WeixiuxinxiView> selectListView(@Param("ew") Wrapper<WeixiuxinxiEntity> wrapper);

	List<WeixiuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiuxinxiEntity> wrapper);
	
	WeixiuxinxiView selectView(@Param("ew") Wrapper<WeixiuxinxiEntity> wrapper);
	

}
