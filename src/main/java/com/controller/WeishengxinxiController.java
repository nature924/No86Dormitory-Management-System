package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.WeishengxinxiEntity;
import com.entity.view.WeishengxinxiView;

import com.service.WeishengxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 卫生信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
@RestController
@RequestMapping("/weishengxinxi")
public class WeishengxinxiController {
    @Autowired
    private WeishengxinxiService weishengxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeishengxinxiEntity weishengxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			weishengxinxi.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WeishengxinxiEntity> ew = new EntityWrapper<WeishengxinxiEntity>();

		PageUtils page = weishengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weishengxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeishengxinxiEntity weishengxinxi, 
		HttpServletRequest request){
        EntityWrapper<WeishengxinxiEntity> ew = new EntityWrapper<WeishengxinxiEntity>();

		PageUtils page = weishengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weishengxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeishengxinxiEntity weishengxinxi){
       	EntityWrapper<WeishengxinxiEntity> ew = new EntityWrapper<WeishengxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weishengxinxi, "weishengxinxi")); 
        return R.ok().put("data", weishengxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeishengxinxiEntity weishengxinxi){
        EntityWrapper< WeishengxinxiEntity> ew = new EntityWrapper< WeishengxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weishengxinxi, "weishengxinxi")); 
		WeishengxinxiView weishengxinxiView =  weishengxinxiService.selectView(ew);
		return R.ok("查询卫生信息成功").put("data", weishengxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeishengxinxiEntity weishengxinxi = weishengxinxiService.selectById(id);
        return R.ok().put("data", weishengxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeishengxinxiEntity weishengxinxi = weishengxinxiService.selectById(id);
        return R.ok().put("data", weishengxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeishengxinxiEntity weishengxinxi, HttpServletRequest request){
    	weishengxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weishengxinxi);
        weishengxinxiService.insert(weishengxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeishengxinxiEntity weishengxinxi, HttpServletRequest request){
    	weishengxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weishengxinxi);
        weishengxinxiService.insert(weishengxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeishengxinxiEntity weishengxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weishengxinxi);
        weishengxinxiService.updateById(weishengxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<WeishengxinxiEntity> list = new ArrayList<WeishengxinxiEntity>();
        for(Long id : ids) {
            WeishengxinxiEntity weishengxinxi = weishengxinxiService.selectById(id);
            weishengxinxi.setSfsh(sfsh);
            weishengxinxi.setShhf(shhf);
            list.add(weishengxinxi);
        }
        weishengxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weishengxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
