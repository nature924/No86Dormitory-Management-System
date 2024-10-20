package com.dao;

import com.entity.WeishengxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeishengxinxiVO;
import com.entity.view.WeishengxinxiView;


/**
 * 卫生信息
 * 
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
public interface WeishengxinxiDao extends BaseMapper<WeishengxinxiEntity> {
	
	List<WeishengxinxiVO> selectListVO(@Param("ew") Wrapper<WeishengxinxiEntity> wrapper);
	
	WeishengxinxiVO selectVO(@Param("ew") Wrapper<WeishengxinxiEntity> wrapper);
	
	List<WeishengxinxiView> selectListView(@Param("ew") Wrapper<WeishengxinxiEntity> wrapper);

	List<WeishengxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<WeishengxinxiEntity> wrapper);
	
	WeishengxinxiView selectView(@Param("ew") Wrapper<WeishengxinxiEntity> wrapper);
	

}
