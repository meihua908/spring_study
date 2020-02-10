package com.iStudy.springboot.model;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_log")
public class Log {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 用户名称
     */
    @Column(name = "create_by_name")
    private String createByName;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 请求URI
     */
    @Column(name = "request_uri")
    private String requestUri;

    /**
     * 操作方式
     */
    @Column(name = "request_method")
    private String requestMethod;
    /**
     * 操作IP地址
     */
    @Column(name = "remote_addr")
    private String remoteAddr;

    /**
     * 归属集团Code
     */
    @Column(name = "corp_code")
    private String corpCode;

    /**
     * 操作提交的数据
     */
    @Column(name = "request_params")
    private String requestParams;

    /**
     * 异常信息
     */
    @Column(name = "exception_info")
    private String exceptionInfo;

	
	@SuppressWarnings("rawtypes")
	public void setRequestParams(Map paramsMap){
		StringBuilder params = new StringBuilder();
		for (Iterator iter = paramsMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry element = (Map.Entry) iter.next();
			// key值
			Object strKey = element.getKey();
			// value,数组形式
			String[] value = (String[]) element.getValue();

			params.append(strKey.toString() + "=");
			for (int i = 0; i < value.length; i++) {
				params.append(value[i] + ",");
			}
		}
		this.requestParams = params.toString();
	}
    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取用户名称
     *
     * @return create_by_name - 用户名称
     */
    public String getCreateByName() {
        return createByName;
    }

    /**
     * 设置用户名称
     *
     * @param createByName 用户名称
     */
    public void setCreateByName(String createByName) {
        this.createByName = createByName == null ? null : createByName.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取请求URI
     *
     * @return request_uri - 请求URI
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * 设置请求URI
     *
     * @param requestUri 请求URI
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    /**
     * 获取操作方式
     *
     * @return request_method - 操作方式
     */
    public String getRequestMethod() {
        return requestMethod;
    }

    /**
     * 设置操作方式
     *
     * @param requestMethod 操作方式
     */
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod == null ? null : requestMethod.trim();
    }

    /**
     * 获取操作IP地址
     *
     * @return remote_addr - 操作IP地址
     */
    public String getRemoteAddr() {
        return remoteAddr;
    }

    /**
     * 设置操作IP地址
     *
     * @param remoteAddr 操作IP地址
     */
    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr == null ? null : remoteAddr.trim();
    }

    /**
     * 获取归属集团Code
     *
     * @return corp_code - 归属集团Code
     */
    public String getCorpCode() {
        return corpCode;
    }

    /**
     * 设置归属集团Code
     *
     * @param corpCode 归属集团Code
     */
    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    /**
     * 获取操作提交的数据
     *
     * @return request_params - 操作提交的数据
     */
    public String getRequestParams() {
        return requestParams;
    }

    /**
     * 设置操作提交的数据
     *
     * @param requestParams 操作提交的数据
     */
    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams == null ? null : requestParams.trim();
    }

    /**
     * 获取异常信息
     *
     * @return exception_info - 异常信息
     */
    public String getExceptionInfo() {
        return exceptionInfo;
    }

    /**
     * 设置异常信息
     *
     * @param exceptionInfo 异常信息
     */
    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo == null ? null : exceptionInfo.trim();
    }
}