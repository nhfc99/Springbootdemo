package com.nhfc99.template.domain;

import java.io.Serializable;
import java.util.Date;

public class SysuserDomain implements Serializable {
    /**
     * 主键编号
     */
    private String id;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 创建用户编号
     */
    private String createUserId;

    /**
     * 创建用户名称
     */
    private String createUserName;

    /**
     * 最后编辑日期
     */
    private Date lastEditDate;

    /**
     * 最后登录日期
     */
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;

    /**
     * 联系电话
     */
    private String mobilePhone;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 角色编号
     */
    private String sysRoleId;

    /**
     * 用户安全码
     */
    private String secretKey;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 用户名
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 微信登录小程序openid
     */
    private String openId;

    /**
     * 微信登录公众号openid
     */
    private String openIdByMP;

    /**
     * 微信登录unionid
     */
    private String unionId;

    /**
     * 微信登录会话session_key
     */
    private String sessionKey;

    /**
     * 单位名称
     */
    private String siteName;

    /**
     * 职务名称
     */
    private String dutyName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 性别
     */
    private String sex;

    /**
     * 所属地市
     */
    private String belongCity;

    /**
     * sysuser
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SysuserDomain(String id, Date createDate, String createUserId, String createUserName, Date lastEditDate, Date lastLoginDate, Integer loginCount, String mobilePhone, String realName, String sysRoleId, String secretKey, Integer status, String account, String password, String openId, String openIdByMP, String unionId, String sessionKey, String siteName, String dutyName, String userAvatar, String sex, String belongCity) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.lastEditDate = lastEditDate;
        this.lastLoginDate = lastLoginDate;
        this.loginCount = loginCount;
        this.mobilePhone = mobilePhone;
        this.realName = realName;
        this.sysRoleId = sysRoleId;
        this.secretKey = secretKey;
        this.status = status;
        this.account = account;
        this.password = password;
        this.openId = openId;
        this.openIdByMP = openIdByMP;
        this.unionId = unionId;
        this.sessionKey = sessionKey;
        this.siteName = siteName;
        this.dutyName = dutyName;
        this.userAvatar = userAvatar;
        this.sex = sex;
        this.belongCity = belongCity;
    }

    /**
     *
     * @mbggenerated 2020-05-27
     */
    public SysuserDomain() {
        super();
    }

    /**
     * 主键编号
     * @return Id 主键编号
     */
    public String getId() {
        return id;
    }

    /**
     * 主键编号
     * @param id 主键编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 创建日期
     * @return CreateDate 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 创建用户编号
     * @return CreateUserId 创建用户编号
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建用户编号
     * @param createUserId 创建用户编号
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    /**
     * 创建用户名称
     * @return CreateUserName 创建用户名称
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建用户名称
     * @param createUserName 创建用户名称
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 最后编辑日期
     * @return LastEditDate 最后编辑日期
     */
    public Date getLastEditDate() {
        return lastEditDate;
    }

    /**
     * 最后编辑日期
     * @param lastEditDate 最后编辑日期
     */
    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    /**
     * 最后登录日期
     * @return LastLoginDate 最后登录日期
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 最后登录日期
     * @param lastLoginDate 最后登录日期
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 登录次数
     * @return LoginCount 登录次数
     */
    public Integer getLoginCount() {
        return loginCount;
    }

    /**
     * 登录次数
     * @param loginCount 登录次数
     */
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * 联系电话
     * @return MobilePhone 联系电话
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 联系电话
     * @param mobilePhone 联系电话
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * 姓名
     * @return RealName 姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 姓名
     * @param realName 姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 角色编号
     * @return SysRoleId 角色编号
     */
    public String getSysRoleId() {
        return sysRoleId;
    }

    /**
     * 角色编号
     * @param sysRoleId 角色编号
     */
    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId == null ? null : sysRoleId.trim();
    }

    /**
     * 用户安全码
     * @return SecretKey 用户安全码
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * 用户安全码
     * @param secretKey 用户安全码
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
    }

    /**
     * 用户状态
     * @return Status 用户状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 用户状态
     * @param status 用户状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 用户名
     * @return Account 用户名
     */
    public String getAccount() {
        return account;
    }

    /**
     * 用户名
     * @param account 用户名
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 密码
     * @return Password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 微信登录小程序openid
     * @return OpenId 微信登录小程序openid
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 微信登录小程序openid
     * @param openId 微信登录小程序openid
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 微信登录公众号openid
     * @return OpenIdByMP 微信登录公众号openid
     */
    public String getOpenIdByMP() {
        return openIdByMP;
    }

    /**
     * 微信登录公众号openid
     * @param openIdByMP 微信登录公众号openid
     */
    public void setOpenIdByMP(String openIdByMP) {
        this.openIdByMP = openIdByMP == null ? null : openIdByMP.trim();
    }

    /**
     * 微信登录unionid
     * @return UnionId 微信登录unionid
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 微信登录unionid
     * @param unionId 微信登录unionid
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    /**
     * 微信登录会话session_key
     * @return SessionKey 微信登录会话session_key
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * 微信登录会话session_key
     * @param sessionKey 微信登录会话session_key
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    /**
     * 单位名称
     * @return SiteName 单位名称
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * 单位名称
     * @param siteName 单位名称
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    /**
     * 职务名称
     * @return DutyName 职务名称
     */
    public String getDutyName() {
        return dutyName;
    }

    /**
     * 职务名称
     * @param dutyName 职务名称
     */
    public void setDutyName(String dutyName) {
        this.dutyName = dutyName == null ? null : dutyName.trim();
    }

    /**
     * 用户头像
     * @return UserAvatar 用户头像
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * 用户头像
     * @param userAvatar 用户头像
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    /**
     * 性别
     * @return Sex 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 所属地市
     * @return BelongCity 所属地市
     */
    public String getBelongCity() {
        return belongCity;
    }

    /**
     * 所属地市
     * @param belongCity 所属地市
     */
    public void setBelongCity(String belongCity) {
        this.belongCity = belongCity == null ? null : belongCity.trim();
    }
}