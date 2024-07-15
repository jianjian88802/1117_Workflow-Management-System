package com.entity.vo;

import com.entity.JiarudexiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 加入的项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiarudexiangmu")
public class JiarudexiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 项目
     */

    @TableField(value = "xiangmu_id")
    private Integer xiangmuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 加入审核
     */

    @TableField(value = "jiarudexiangmu_yesno_types")
    private Integer jiarudexiangmuYesnoTypes;


    /**
     * 审核结果
     */

    @TableField(value = "jiarudexiangmu_yesno_text")
    private String jiarudexiangmuYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 获取：项目
	 */

    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：加入审核
	 */
    public Integer getJiarudexiangmuYesnoTypes() {
        return jiarudexiangmuYesnoTypes;
    }


    /**
	 * 获取：加入审核
	 */

    public void setJiarudexiangmuYesnoTypes(Integer jiarudexiangmuYesnoTypes) {
        this.jiarudexiangmuYesnoTypes = jiarudexiangmuYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getJiarudexiangmuYesnoText() {
        return jiarudexiangmuYesnoText;
    }


    /**
	 * 获取：审核结果
	 */

    public void setJiarudexiangmuYesnoText(String jiarudexiangmuYesnoText) {
        this.jiarudexiangmuYesnoText = jiarudexiangmuYesnoText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
