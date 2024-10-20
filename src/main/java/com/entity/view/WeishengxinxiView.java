package com.entity.view;

import com.entity.WeishengxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 卫生信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
@TableName("weishengxinxi")
public class WeishengxinxiView  extends WeishengxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeishengxinxiView(){
	}
 
 	public WeishengxinxiView(WeishengxinxiEntity weishengxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, weishengxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
