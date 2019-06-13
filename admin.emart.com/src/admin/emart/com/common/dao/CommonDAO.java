package admin.emart.com.common.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import admin.emart.com.common.vo.CommonVO;

@Repository
public class CommonDAO {
	protected Log log = LogFactory.getLog(CommonDAO.class);
	
	@Autowired
	private SqlSessionTemplate commonSqlSessionTemplate;
	
	public List<CommonVO> boardListMain() {
		return commonSqlSessionTemplate.selectList("Query.listAll");
	}
	
}
