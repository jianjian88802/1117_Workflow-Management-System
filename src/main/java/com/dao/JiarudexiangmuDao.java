package com.dao;

import com.entity.JiarudexiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiarudexiangmuView;

/**
 * 加入的项目 Dao 接口
 *
 * @author 
 */
public interface JiarudexiangmuDao extends BaseMapper<JiarudexiangmuEntity> {

   List<JiarudexiangmuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
