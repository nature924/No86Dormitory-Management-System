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

import com.entity.JinrususheEntity;
import com.entity.view.JinrususheView;

import com.service.JinrususheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 进入宿舍
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
@RestController
@RequestMapping("/jinrusushe")
public class JinrususheController {
    @Autowired
    private JinrususheService jinrususheService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JinrususheEntity jinrusushe,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			jinrusushe.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JinrususheEntity> ew = new EntityWrapper<JinrususheEntity>();

		PageUtils page = jinrususheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinrusushe), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JinrususheEntity jinrusushe, 
		HttpServletRequest request){
        EntityWrapper<JinrususheEntity> ew = new EntityWrapper<JinrususheEntity>();

		PageUtils page = jinrususheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinrusushe), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JinrususheEntity jinrusushe){
       	EntityWrapper<JinrususheEntity> ew = new EntityWrapper<JinrususheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jinrusushe, "jinrusushe")); 
        return R.ok().put("data", jinrususheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JinrususheEntity jinrusushe){
        EntityWrapper< JinrususheEntity> ew = new EntityWrapper< JinrususheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jinrusushe, "jinrusushe")); 
		JinrususheView jinrususheView =  jinrususheService.selectView(ew);
		return R.ok("查询进入宿舍成功").put("data", jinrususheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JinrususheEntity jinrusushe = jinrususheService.selectById(id);
        return R.ok().put("data", jinrusushe);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JinrususheEntity jinrusushe = jinrususheService.selectById(id);
        return R.ok().put("data", jinrusushe);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JinrususheEntity jinrusushe, HttpServletRequest request){
    	jinrusushe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinrusushe);
        jinrususheService.insert(jinrusushe);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JinrususheEntity jinrusushe, HttpServletRequest request){
    	jinrusushe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinrusushe);
        jinrususheService.insert(jinrusushe);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JinrususheEntity jinrusushe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jinrusushe);
        jinrususheService.updateById(jinrusushe);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jinrususheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
