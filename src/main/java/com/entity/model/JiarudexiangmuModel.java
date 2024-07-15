package com.entity.model;

import com.entity.JiarudexiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 加入的项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiarudexiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目
     */
    private Integer xiangmuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 加入审核
     */
    private Integer jiarudexiangmuYesnoTypes;


    /**
     * 审核结果
     */
    private String jiarudexiangmuYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 设置：项目
	 */
    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：加入审核
	 */
    public Integer getJiarudexiangmuYesnoTypes() {
        return jiarudexiangmuYesnoTypes;
    }


    /**
	 * 设置：加入审核
	 */
    public void setJiarudexiangmuYesnoTypes(Integer jiarudexiangmuYesnoTypes) {
        this.jiarudexiangmuYesnoTypes = jiarudexiangmuYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getJiarudexiangmuYesnoText() {
        return jiarudexiangmuYesnoText;
    }


    /**
	 * 设置：审核结果
	 */
    public void setJiarudexiangmuYesnoText(String jiarudexiangmuYesnoText) {
        this.jiarudexiangmuYesnoText = jiarudexiangmuYesnoText;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
