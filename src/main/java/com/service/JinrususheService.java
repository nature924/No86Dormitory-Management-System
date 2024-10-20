package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JinrususheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JinrususheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JinrususheView;


/**
 * 进入宿舍
 *
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
public interface JinrususheService extends IService<JinrususheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JinrususheVO> selectListVO(Wrapper<JinrususheEntity> wrapper);
   	
   	JinrususheVO selectVO(@Param("ew") Wrapper<JinrususheEntity> wrapper);
   	
   	List<JinrususheView> selectListView(Wrapper<JinrususheEntity> wrapper);
   	
   	JinrususheView selectView(@Param("ew") Wrapper<JinrususheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JinrususheEntity> wrapper);
   	

}

