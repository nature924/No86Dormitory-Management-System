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

import com.entity.WeixiuxinxiEntity;
import com.entity.view.WeixiuxinxiView;

import com.service.WeixiuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 17:35:32
 */
@RestController
@RequestMapping("/weixiuxinxi")
public class WeixiuxinxiController {
    @Autowired
    private WeixiuxinxiService weixiuxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiuxinxiEntity weixiuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			weixiuxinxi.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WeixiuxinxiEntity> ew = new EntityWrapper<WeixiuxinxiEntity>();

		PageUtils page = weixiuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiuxinxiEntity weixiuxinxi, 
		HttpServletRequest request){
        EntityWrapper<WeixiuxinxiEntity> ew = new EntityWrapper<WeixiuxinxiEntity>();

		PageUtils page = weixiuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiuxinxiEntity weixiuxinxi){
       	EntityWrapper<WeixiuxinxiEntity> ew = new EntityWrapper<WeixiuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiuxinxi, "weixiuxinxi")); 
        return R.ok().put("data", weixiuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiuxinxiEntity weixiuxinxi){
        EntityWrapper< WeixiuxinxiEntity> ew = new EntityWrapper< WeixiuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiuxinxi, "weixiuxinxi")); 
		WeixiuxinxiView weixiuxinxiView =  weixiuxinxiService.selectView(ew);
		return R.ok("查询维修信息成功").put("data", weixiuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiuxinxiEntity weixiuxinxi = weixiuxinxiService.selectById(id);
        return R.ok().put("data", weixiuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiuxinxiEntity weixiuxinxi = weixiuxinxiService.selectById(id);
        return R.ok().put("data", weixiuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiuxinxiEntity weixiuxinxi, HttpServletRequest request){
    	weixiuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuxinxi);
        weixiuxinxiService.insert(weixiuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiuxinxiEntity weixiuxinxi, HttpServletRequest request){
    	weixiuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuxinxi);
        weixiuxinxiService.insert(weixiuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiuxinxiEntity weixiuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiuxinxi);
        weixiuxinxiService.updateById(weixiuxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<WeixiuxinxiEntity> list = new ArrayList<WeixiuxinxiEntity>();
        for(Long id : ids) {
            WeixiuxinxiEntity weixiuxinxi = weixiuxinxiService.selectById(id);
            weixiuxinxi.setSfsh(sfsh);
            weixiuxinxi.setShhf(shhf);
            list.add(weixiuxinxi);
        }
        weixiuxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
