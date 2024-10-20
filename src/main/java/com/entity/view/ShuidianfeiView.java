package com.entity.view;

import com.entity.ShuidianfeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 水电费
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
@TableName("shuidianfei")
public class ShuidianfeiView  extends ShuidianfeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShuidianfeiView(){
	}
 
 	public ShuidianfeiView(ShuidianfeiEntity shuidianfeiEntity){
 	try {
			BeanUtils.copyProperties(this, shuidianfeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
