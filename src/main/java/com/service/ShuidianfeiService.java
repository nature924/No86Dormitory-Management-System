package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShuidianfeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShuidianfeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShuidianfeiView;


/**
 * 水电费
 *
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
public interface ShuidianfeiService extends IService<ShuidianfeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShuidianfeiVO> selectListVO(Wrapper<ShuidianfeiEntity> wrapper);
   	
   	ShuidianfeiVO selectVO(@Param("ew") Wrapper<ShuidianfeiEntity> wrapper);
   	
   	List<ShuidianfeiView> selectListView(Wrapper<ShuidianfeiEntity> wrapper);
   	
   	ShuidianfeiView selectView(@Param("ew") Wrapper<ShuidianfeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShuidianfeiEntity> wrapper);
   	

}

