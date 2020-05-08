package com.zyw.bean;

import java.io.Serializable;

public class Project implements Serializable{
	
	private static final long serialVersionUID = 5851461905357375550L;
	private int	id;
	private String	name;	//项目名称
	private String	scale;  //项目规模
	private double	rate;	//日化利率
	private Integer	duration;  //项目期限
	private String	repaymethod;//还款方式：一次性还本付息
	private String	repaytimetype;//结息时间：到期还本，到期付息
	private String	guarantee;//担保机构：如中诚信担保有限公司
	private double	projectrate;//项目完成进度
	private String	jl_tuijian;//推荐奖励
	private String	jl_chongzhi;//充值奖励
	private String	jl_futou;//复投奖励
	private double	start_money;//起投金额
	private String	calculation;//收益计算
	private String	huankuanfangshi;//还款方式
	private String	jiesuanshijian;//结算时间
	private String	ketoujine;//可投金额
	private String	zijinyongtu;//资金用途
	private String	juqingjianjie;//剧情简介
	private String	anquanbaozhen;//安全保证
	private String	xiangmugaishu;//项目概述
	private Integer	project_type;//项目类型 
	private Integer	topstart;//top推荐星级
	private String	picture;//封面图片
	private int 	status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getRepaymethod() {
		return repaymethod;
	}
	public void setRepaymethod(String repaymethod) {
		this.repaymethod = repaymethod;
	}
	public String getRepaytimetype() {
		return repaytimetype;
	}
	public void setRepaytimetype(String repaytimetype) {
		this.repaytimetype = repaytimetype;
	}
	public String getGuarantee() {
		return guarantee;
	}
	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}
	public double getProjectrate() {
		return projectrate;
	}
	public void setProjectrate(double projectrate) {
		this.projectrate = projectrate;
	}
	public String getJl_tuijian() {
		return jl_tuijian;
	}
	public void setJl_tuijian(String jl_tuijian) {
		this.jl_tuijian = jl_tuijian;
	}
	public String getJl_chongzhi() {
		return jl_chongzhi;
	}
	public void setJl_chongzhi(String jl_chongzhi) {
		this.jl_chongzhi = jl_chongzhi;
	}
	public String getJl_futou() {
		return jl_futou;
	}
	public void setJl_futou(String jl_futou) {
		this.jl_futou = jl_futou;
	}
	public double getStart_money() {
		return start_money;
	}
	public void setStart_money(double start_money) {
		this.start_money = start_money;
	}
	public String getCalculation() {
		return calculation;
	}
	public void setCalculation(String calculation) {
		this.calculation = calculation;
	}
	public String getHuankuanfangshi() {
		return huankuanfangshi;
	}
	public void setHuankuanfangshi(String huankuanfangshi) {
		this.huankuanfangshi = huankuanfangshi;
	}
	public String getJiesuanshijian() {
		return jiesuanshijian;
	}
	public void setJiesuanshijian(String jiesuanshijian) {
		this.jiesuanshijian = jiesuanshijian;
	}
	public String getKetoujine() {
		return ketoujine;
	}
	public void setKetoujine(String ketoujine) {
		this.ketoujine = ketoujine;
	}
	public String getZijinyongtu() {
		return zijinyongtu;
	}
	public void setZijinyongtu(String zijinyongtu) {
		this.zijinyongtu = zijinyongtu;
	}
	public String getJuqingjianjie() {
		return juqingjianjie;
	}
	public void setJuqingjianjie(String juqingjianjie) {
		this.juqingjianjie = juqingjianjie;
	}
	public String getAnquanbaozhen() {
		return anquanbaozhen;
	}
	public void setAnquanbaozhen(String anquanbaozhen) {
		this.anquanbaozhen = anquanbaozhen;
	}
	public String getXiangmugaishu() {
		return xiangmugaishu;
	}
	public void setXiangmugaishu(String xiangmugaishu) {
		this.xiangmugaishu = xiangmugaishu;
	}
	public Integer getProject_type() {
		return project_type;
	}
	public void setProject_type(Integer project_type) {
		this.project_type = project_type;
	}
	public Integer getTopstart() {
		return topstart;
	}
	public void setTopstart(Integer topstart) {
		this.topstart = topstart;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", scale=" + scale + ", rate=" + rate + ", duration=" + duration
				+ ", repaymethod=" + repaymethod + ", repaytimetype=" + repaytimetype + ", guarantee=" + guarantee
				+ ", projectrate=" + projectrate + ", jl_tuijian=" + jl_tuijian + ", jl_chongzhi=" + jl_chongzhi
				+ ", jl_futou=" + jl_futou + ", start_money=" + start_money + ", calculation=" + calculation
				+ ", huankuanfangshi=" + huankuanfangshi + ", jiesuanshijian=" + jiesuanshijian + ", ketoujine="
				+ ketoujine + ", zijinyongtu=" + zijinyongtu + ", juqingjianjie=" + juqingjianjie + ", anquanbaozhen="
				+ anquanbaozhen + ", xiangmugaishu=" + xiangmugaishu + ", project_type=" + project_type + ", topstart="
				+ topstart + ", picture=" + picture + "]";
	}
	
}
