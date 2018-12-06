package com.ssm.pojo;

public class Base {

	/**
	 * 主键ID
	 */
	private Integer id;

	/**
	 * 当前页
	 */
	private Integer currentPage;

	/**
	 * 每页显示的条数
	 */
	private Integer pageSize;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * (当前页 - 1) * 每页显示的条数
	 * @return
	 */
	public void setCurrentPage(Integer currentPage) {
		if (this.pageSize != null) {
			this.currentPage = (currentPage - 1) * this.pageSize;
		} else {
			this.currentPage = currentPage;
		}
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
