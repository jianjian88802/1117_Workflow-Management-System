package com.entity.view;

import com.entity.XiangmujinduEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目进度
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiangmujindu")
public class XiangmujinduView extends XiangmujinduEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 xiangmu
			/**
			* 项目名称
			*/
			private String xiangmuName;
			/**
			* 项目封面
			*/
			private String xiangmuPhoto;
			/**
			* 项目类型
			*/
			private Integer xiangmuTypes;
				/**
				* 项目类型的值
				*/
				private String xiangmuValue;
			/**
			* 所属地点
			*/
			private String xiangmuAddress;
			/**
			* 项目信息 的 项目负责人
			*/
			private Integer xiangmuYonghuId;
			/**
			* 项目简介
			*/
			private String xiangmuContent;
			/**
			* 项目审核
			*/
			private Integer xiangmuYesnoTypes;
				/**
				* 项目审核的值
				*/
				private String xiangmuYesnoValue;
			/**
			* 审核结果
			*/
			private String xiangmuYesnoText;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public XiangmujinduView() {

	}

	public XiangmujinduView(XiangmujinduEntity xiangmujinduEntity) {
		try {
			BeanUtils.copyProperties(this, xiangmujinduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set xiangmu

					/**
					* 获取： 项目名称
					*/
					public String getXiangmuName() {
						return xiangmuName;
					}
					/**
					* 设置： 项目名称
					*/
					public void setXiangmuName(String xiangmuName) {
						this.xiangmuName = xiangmuName;
					}

					/**
					* 获取： 项目封面
					*/
					public String getXiangmuPhoto() {
						return xiangmuPhoto;
					}
					/**
					* 设置： 项目封面
					*/
					public void setXiangmuPhoto(String xiangmuPhoto) {
						this.xiangmuPhoto = xiangmuPhoto;
					}

					/**
					* 获取： 项目类型
					*/
					public Integer getXiangmuTypes() {
						return xiangmuTypes;
					}
					/**
					* 设置： 项目类型
					*/
					public void setXiangmuTypes(Integer xiangmuTypes) {
						this.xiangmuTypes = xiangmuTypes;
					}


						/**
						* 获取： 项目类型的值
						*/
						public String getXiangmuValue() {
							return xiangmuValue;
						}
						/**
						* 设置： 项目类型的值
						*/
						public void setXiangmuValue(String xiangmuValue) {
							this.xiangmuValue = xiangmuValue;
						}

					/**
					* 获取： 所属地点
					*/
					public String getXiangmuAddress() {
						return xiangmuAddress;
					}
					/**
					* 设置： 所属地点
					*/
					public void setXiangmuAddress(String xiangmuAddress) {
						this.xiangmuAddress = xiangmuAddress;
					}

					/**
					* 获取：项目信息 的 项目负责人
					*/
					public Integer getXiangmuYonghuId() {
						return xiangmuYonghuId;
					}
					/**
					* 设置：项目信息 的 项目负责人
					*/
					public void setXiangmuYonghuId(Integer xiangmuYonghuId) {
						this.xiangmuYonghuId = xiangmuYonghuId;
					}


					/**
					* 获取： 项目简介
					*/
					public String getXiangmuContent() {
						return xiangmuContent;
					}
					/**
					* 设置： 项目简介
					*/
					public void setXiangmuContent(String xiangmuContent) {
						this.xiangmuContent = xiangmuContent;
					}

					/**
					* 获取： 项目审核
					*/
					public Integer getXiangmuYesnoTypes() {
						return xiangmuYesnoTypes;
					}
					/**
					* 设置： 项目审核
					*/
					public void setXiangmuYesnoTypes(Integer xiangmuYesnoTypes) {
						this.xiangmuYesnoTypes = xiangmuYesnoTypes;
					}


						/**
						* 获取： 项目审核的值
						*/
						public String getXiangmuYesnoValue() {
							return xiangmuYesnoValue;
						}
						/**
						* 设置： 项目审核的值
						*/
						public void setXiangmuYesnoValue(String xiangmuYesnoValue) {
							this.xiangmuYesnoValue = xiangmuYesnoValue;
						}

					/**
					* 获取： 审核结果
					*/
					public String getXiangmuYesnoText() {
						return xiangmuYesnoText;
					}
					/**
					* 设置： 审核结果
					*/
					public void setXiangmuYesnoText(String xiangmuYesnoText) {
						this.xiangmuYesnoText = xiangmuYesnoText;
					}





				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}




}
