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

import com.entity.ChurususheEntity;
import com.entity.view.ChurususheView;

import com.service.ChurususheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 出入宿舍
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
@RestController
@RequestMapping("/churusushe")
public class ChurususheController {
    @Autowired
    private ChurususheService churususheService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChurususheEntity churusushe,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			churusushe.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChurususheEntity> ew = new EntityWrapper<ChurususheEntity>();

		PageUtils page = churususheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, churusushe), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChurususheEntity churusushe, 
		HttpServletRequest request){
        EntityWrapper<ChurususheEntity> ew = new EntityWrapper<ChurususheEntity>();

		PageUtils page = churususheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, churusushe), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChurususheEntity churusushe){
       	EntityWrapper<ChurususheEntity> ew = new EntityWrapper<ChurususheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( churusushe, "churusushe")); 
        return R.ok().put("data", churususheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChurususheEntity churusushe){
        EntityWrapper< ChurususheEntity> ew = new EntityWrapper< ChurususheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( churusushe, "churusushe")); 
		ChurususheView churususheView =  churususheService.selectView(ew);
		return R.ok("查询出入宿舍成功").put("data", churususheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChurususheEntity churusushe = churususheService.selectById(id);
        return R.ok().put("data", churusushe);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChurususheEntity churusushe = churususheService.selectById(id);
        return R.ok().put("data", churusushe);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChurususheEntity churusushe, HttpServletRequest request){
    	churusushe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(churusushe);
        churususheService.insert(churusushe);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChurususheEntity churusushe, HttpServletRequest request){
    	churusushe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(churusushe);
        churususheService.insert(churusushe);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChurususheEntity churusushe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(churusushe);
        churususheService.updateById(churusushe);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        churususheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
