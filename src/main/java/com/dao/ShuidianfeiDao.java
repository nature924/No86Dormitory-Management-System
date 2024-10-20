package com.dao;

import com.entity.ShuidianfeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShuidianfeiVO;
import com.entity.view.ShuidianfeiView;


/**
 * 水电费
 * 
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
public interface ShuidianfeiDao extends BaseMapper<ShuidianfeiEntity> {
	
	List<ShuidianfeiVO> selectListVO(@Param("ew") Wrapper<ShuidianfeiEntity> wrapper);
	
	ShuidianfeiVO selectVO(@Param("ew") Wrapper<ShuidianfeiEntity> wrapper);
	
	List<ShuidianfeiView> selectListView(@Param("ew") Wrapper<ShuidianfeiEntity> wrapper);

	List<ShuidianfeiView> selectListView(Pagination page,@Param("ew") Wrapper<ShuidianfeiEntity> wrapper);
	
	ShuidianfeiView selectView(@Param("ew") Wrapper<ShuidianfeiEntity> wrapper);
	

}
