package com.dao;

import com.entity.ChurususheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChurususheVO;
import com.entity.view.ChurususheView;


/**
 * 出入宿舍
 * 
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
public interface ChurususheDao extends BaseMapper<ChurususheEntity> {
	
	List<ChurususheVO> selectListVO(@Param("ew") Wrapper<ChurususheEntity> wrapper);
	
	ChurususheVO selectVO(@Param("ew") Wrapper<ChurususheEntity> wrapper);
	
	List<ChurususheView> selectListView(@Param("ew") Wrapper<ChurususheEntity> wrapper);

	List<ChurususheView> selectListView(Pagination page,@Param("ew") Wrapper<ChurususheEntity> wrapper);
	
	ChurususheView selectView(@Param("ew") Wrapper<ChurususheEntity> wrapper);
	

}
