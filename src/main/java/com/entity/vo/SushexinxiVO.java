package com.entity.vo;

import com.entity.SushexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 宿舍信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-08 17:35:31
 */
public class SushexinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 宿舍类型
	 */
	
	private String susheleixing;
		
	/**
	 * 宿舍楼栋
	 */
	
	private String susheloudong;
		
	/**
	 * 房间号
	 */
	
	private String fangjianhao;
		
	/**
	 * 可住人数
	 */
	
	private String kezhurenshu;
		
	/**
	 * 已住人数
	 */
	
	private String yizhurenshu;
		
	/**
	 * 有床位
	 */
	
	private String youchuangwei;
		
	/**
	 * 更新时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date gengxinshijian;
		
	/**
	 * 详情
	 */
	
	private String xiangqing;
				
	
	/**
	 * 设置：宿舍类型
	 */
	 
	public void setSusheleixing(String susheleixing) {
		this.susheleixing = susheleixing;
	}
	
	/**
	 * 获取：宿舍类型
	 */
	public String getSusheleixing() {
		return susheleixing;
	}
				
	
	/**
	 * 设置：宿舍楼栋
	 */
	 
	public void setSusheloudong(String susheloudong) {
		this.susheloudong = susheloudong;
	}
	
	/**
	 * 获取：宿舍楼栋
	 */
	public String getSusheloudong() {
		return susheloudong;
	}
				
	
	/**
	 * 设置：房间号
	 */
	 
	public void setFangjianhao(String fangjianhao) {
		this.fangjianhao = fangjianhao;
	}
	
	/**
	 * 获取：房间号
	 */
	public String getFangjianhao() {
		return fangjianhao;
	}
				
	
	/**
	 * 设置：可住人数
	 */
	 
	public void setKezhurenshu(String kezhurenshu) {
		this.kezhurenshu = kezhurenshu;
	}
	
	/**
	 * 获取：可住人数
	 */
	public String getKezhurenshu() {
		return kezhurenshu;
	}
				
	
	/**
	 * 设置：已住人数
	 */
	 
	public void setYizhurenshu(String yizhurenshu) {
		this.yizhurenshu = yizhurenshu;
	}
	
	/**
	 * 获取：已住人数
	 */
	public String getYizhurenshu() {
		return yizhurenshu;
	}
				
	
	/**
	 * 设置：有床位
	 */
	 
	public void setYouchuangwei(String youchuangwei) {
		this.youchuangwei = youchuangwei;
	}
	
	/**
	 * 获取：有床位
	 */
	public String getYouchuangwei() {
		return youchuangwei;
	}
				
	
	/**
	 * 设置：更新时间
	 */
	 
	public void setGengxinshijian(Date gengxinshijian) {
		this.gengxinshijian = gengxinshijian;
	}
	
	/**
	 * 获取：更新时间
	 */
	public Date getGengxinshijian() {
		return gengxinshijian;
	}
				
	
	/**
	 * 设置：详情
	 */
	 
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}
			
}
