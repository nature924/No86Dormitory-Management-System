package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeishengxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeishengxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeishengxinxiView;


/**
 * 卫生信息
 *
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
public interface WeishengxinxiService extends IService<WeishengxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeishengxinxiVO> selectListVO(Wrapper<WeishengxinxiEntity> wrapper);
   	
   	WeishengxinxiVO selectVO(@Param("ew") Wrapper<WeishengxinxiEntity> wrapper);
   	
   	List<WeishengxinxiView> selectListView(Wrapper<WeishengxinxiEntity> wrapper);
   	
   	WeishengxinxiView selectView(@Param("ew") Wrapper<WeishengxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeishengxinxiEntity> wrapper);
   	

}

