package admin.emart.com.traders.popup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import admin.emart.com.traders.popup.dao.PopupDAO;
import admin.emart.com.traders.popup.service.PopupService;
import admin.emart.com.traders.popup.vo.PopupVO;

@Service("popupService")
public class PopupServiceImpl implements PopupService {

	@Resource(name = "popupDAO")  
	private PopupDAO popupDAO;
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	public List<PopupVO> popupList() throws Exception {
		return popupDAO.popupList();
	}

}
