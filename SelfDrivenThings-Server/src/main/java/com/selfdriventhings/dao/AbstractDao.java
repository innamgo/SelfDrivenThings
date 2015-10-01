package com.selfdriventhings.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class AbstractDao extends SqlSessionDaoSupport {

	protected AbstractDao() {
        // PMD abstract Rule - If the class is intended to be used as a base class only (not to be instantiated directly)
        // a protected constructor can be provided prevent direct instantiation
	}

	@Resource(name = "sqlSessionFactory_asr")
	public void setSuperSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
    
    public Object insert(String queryId, Object parameterObject) {
        return getSqlSession().insert(queryId, parameterObject);
    }

    public int update(String queryId, Object parameterObject) {
        return getSqlSession().update(queryId, parameterObject);
    }

    public int delete(String queryId, Object parameterObject) {
        return getSqlSession().delete(queryId, parameterObject);
    }
    
	public Object selectByPk(String queryId, Object parameterObject) {
        return getSqlSession().selectOne(queryId, parameterObject);
    }

    @SuppressWarnings("rawtypes")
	public List list(String queryId, Object parameterObject) {
        return getSqlSession().selectList(queryId, parameterObject);
    }
	
    @SuppressWarnings("rawtypes")
	public List listWithPaging(String queryId, Object parameterObject, int pageIndex, int pageSize) {
        int skipResults = pageIndex * pageSize;
        int maxResults = (pageIndex * pageSize) + pageSize;
        
        RowBounds rowBounds = new RowBounds(maxResults, skipResults);
        
        return getSqlSession().selectList(queryId, parameterObject, rowBounds);
    }
}