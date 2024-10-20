package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChurususheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChurususheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChurususheView;


/**
 * 出入宿舍
 *
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
public interface ChurususheService extends IService<ChurususheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChurususheVO> selectListVO(Wrapper<ChurususheEntity> wrapper);
   	
   	ChurususheVO selectVO(@Param("ew") Wrapper<ChurususheEntity> wrapper);
   	
   	List<ChurususheView> selectListView(Wrapper<ChurususheEntity> wrapper);
   	
   	ChurususheView selectView(@Param("ew") Wrapper<ChurususheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChurususheEntity> wrapper);
   	

}

