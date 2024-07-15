
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 项目进度
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiangmujindu")
public class XiangmujinduController {
    private static final Logger logger = LoggerFactory.getLogger(XiangmujinduController.class);

    @Autowired
    private XiangmujinduService xiangmujinduService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XiangmuService xiangmuService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private JiarudexiangmuService jiarudexiangmuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));

        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role)){
            ArrayList<Integer> ids = new ArrayList<>();
            List<XiangmuEntity> xiangmuEntities = xiangmuService.selectList(new EntityWrapper<XiangmuEntity>()
                    .eq("yonghu_id", request.getSession().getAttribute("userId")));
            for (XiangmuEntity xiangmu:xiangmuEntities) {
                ids.add(xiangmu.getId());
            }
            List<JiarudexiangmuEntity> jiarudexiangmuEntities = jiarudexiangmuService.selectList(new EntityWrapper<JiarudexiangmuEntity>()
                    .eq("yonghu_id", request.getSession().getAttribute("userId"))
                    .eq("jiarudexiangmu_yesno_types", 2));
            for (JiarudexiangmuEntity j:jiarudexiangmuEntities) {
                ids.add(j.getXiangmuId());
            }
            params.put("ids",ids);
        }
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xiangmujinduService.queryPage(params);

        //字典表数据转换
        List<XiangmujinduView> list =(List<XiangmujinduView>)page.getList();
        for(XiangmujinduView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiangmujinduEntity xiangmujindu = xiangmujinduService.selectById(id);
        if(xiangmujindu !=null){
            //entity转view
            XiangmujinduView view = new XiangmujinduView();
            BeanUtils.copyProperties( xiangmujindu , view );//把实体数据重构到view中

                //级联表
                XiangmuEntity xiangmu = xiangmuService.selectById(xiangmujindu.getXiangmuId());
                if(xiangmu != null){
                    BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiangmuId(xiangmu.getId());
                    view.setXiangmuYonghuId(xiangmu.getYonghuId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xiangmujindu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmujinduEntity xiangmujindu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiangmujindu:{}",this.getClass().getName(),xiangmujindu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            xiangmujindu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XiangmujinduEntity> queryWrapper = new EntityWrapper<XiangmujinduEntity>()
            .eq("yonghu_id", xiangmujindu.getYonghuId())
            .eq("xiangmu_id", xiangmujindu.getXiangmuId())
            .eq("xiangmujindu_text", xiangmujindu.getXiangmujinduText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmujinduEntity xiangmujinduEntity = xiangmujinduService.selectOne(queryWrapper);
        if(xiangmujinduEntity==null){
            xiangmujindu.setInsertTime(new Date());
            xiangmujindu.setCreateTime(new Date());
            xiangmujinduService.insert(xiangmujindu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiangmujinduEntity xiangmujindu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiangmujindu:{}",this.getClass().getName(),xiangmujindu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            xiangmujindu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XiangmujinduEntity> queryWrapper = new EntityWrapper<XiangmujinduEntity>()
            .notIn("id",xiangmujindu.getId())
            .andNew()
            .eq("yonghu_id", xiangmujindu.getYonghuId())
            .eq("xiangmu_id", xiangmujindu.getXiangmuId())
            .eq("xiangmujindu_text", xiangmujindu.getXiangmujinduText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmujinduEntity xiangmujinduEntity = xiangmujinduService.selectOne(queryWrapper);
        if(xiangmujinduEntity==null){
            xiangmujinduService.updateById(xiangmujindu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xiangmujinduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XiangmujinduEntity> xiangmujinduList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XiangmujinduEntity xiangmujinduEntity = new XiangmujinduEntity();
//                            xiangmujinduEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xiangmujinduEntity.setXiangmuId(Integer.valueOf(data.get(0)));   //项目信息 要改的
//                            xiangmujinduEntity.setXiangmujinduText(data.get(0));                    //项目进度 要改的
//                            xiangmujinduEntity.setInsertTime(date);//时间
//                            xiangmujinduEntity.setCreateTime(date);//时间
                            xiangmujinduList.add(xiangmujinduEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xiangmujinduService.insertBatch(xiangmujinduList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
