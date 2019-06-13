package admin.emart.com.traders.gasStation.service;

import java.util.List;

import admin.emart.com.traders.gasStation.vo.GasStationVO;

public interface GasStationService {
	public List<GasStationVO> gasStationList() throws Exception;

}
