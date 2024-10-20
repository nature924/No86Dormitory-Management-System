package com.dao;

import com.entity.JinrususheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JinrususheVO;
import com.entity.view.JinrususheView;


/**
 * 进入宿舍
 * 
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
public interface JinrususheDao extends BaseMapper<JinrususheEntity> {
	
	List<JinrususheVO> selectListVO(@Param("ew") Wrapper<JinrususheEntity> wrapper);
	
	JinrususheVO selectVO(@Param("ew") Wrapper<JinrususheEntity> wrapper);
	
	List<JinrususheView> selectListView(@Param("ew") Wrapper<JinrususheEntity> wrapper);

	List<JinrususheView> selectListView(Pagination page,@Param("ew") Wrapper<JinrususheEntity> wrapper);
	
	JinrususheView selectView(@Param("ew") Wrapper<JinrususheEntity> wrapper);
	

}
