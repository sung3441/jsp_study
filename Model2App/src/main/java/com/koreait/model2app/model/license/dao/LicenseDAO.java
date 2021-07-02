package com.koreait.model2app.model.license.dao;

import java.sql.Connection;
import java.util.List;

import com.koreait.model2app.model.domain.License;

public interface LicenseDAO {
	public int insert(License license);
	public List selectAll();
	public License select(int license_id);
	public int update(License license);
	public int delete(int license_id);
}
