package admin.emart.com.traders.gasStation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import admin.emart.com.traders.gasStation.dao.GasStationDAO;
import admin.emart.com.traders.gasStation.service.GasStationService;
import admin.emart.com.traders.gasStation.vo.GasStationVO;

@Service("gasStationService")
public class GasStationServiceImpl implements GasStationService {

	@Resource(name = "gasStationDAO")  
	private GasStationDAO gasStationDAO;
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	public List<GasStationVO> gasStationList() throws Exception {
		return gasStationDAO.gasStationList();
	}

}
