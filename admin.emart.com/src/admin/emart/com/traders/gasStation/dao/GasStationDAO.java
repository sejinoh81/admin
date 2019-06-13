package admin.emart.com.traders.gasStation.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import admin.emart.com.traders.gasStation.vo.GasStationVO;

@Repository
public class GasStationDAO {
	protected Log log = LogFactory.getLog(GasStationDAO.class);
	
	@Autowired
	private SqlSessionTemplate tradersSqlSessionTemplate;
	
	public List<GasStationVO> gasStationList() {
		return tradersSqlSessionTemplate.selectList("gasStation.gasStationList");
	}
	
}
