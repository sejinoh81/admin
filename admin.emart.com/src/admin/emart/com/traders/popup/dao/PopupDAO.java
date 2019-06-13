package admin.emart.com.traders.popup.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import admin.emart.com.traders.popup.vo.PopupVO;

@Repository
public class PopupDAO {
	protected Log log = LogFactory.getLog(PopupDAO.class);
	
	@Autowired
	private SqlSessionTemplate tradersSqlSessionTemplate;
	
	public List<PopupVO> popupList() {
		return tradersSqlSessionTemplate.selectList("popup.popupList");
	}
	
}
