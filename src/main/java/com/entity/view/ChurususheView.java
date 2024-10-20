package com.entity.view;

import com.entity.ChurususheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 出入宿舍
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
@TableName("churusushe")
public class ChurususheView  extends ChurususheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChurususheView(){
	}
 
 	public ChurususheView(ChurususheEntity churususheEntity){
 	try {
			BeanUtils.copyProperties(this, churususheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
