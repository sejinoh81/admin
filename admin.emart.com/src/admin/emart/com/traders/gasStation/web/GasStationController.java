package admin.emart.com.traders.gasStation.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.emart.com.traders.gasStation.service.GasStationService;
import admin.emart.com.traders.gasStation.vo.GasStationVO;
import admin.emart.com.traders.popup.vo.PopupVO;

@Controller
public class GasStationController {

	@Resource(name = "gasStationService")
	protected GasStationService gasStationService;
	
	@RequestMapping(value="/traders/gasStation/gasStationList.do")
	public ModelAndView gasStationList(HttpServletRequest request, HttpServletResponse response, PopupVO popupVO) throws Exception {
		
		ModelAndView mav=new ModelAndView();
		
		List<GasStationVO> resultList = gasStationService.gasStationList();

		for(int i=0; i<resultList.size(); i++) {
			System.out.println(">>>>> " + resultList.get(i).getCODE());
		}
		
		mav.addObject("resultList", resultList);
		mav.setViewName("/traders/gasStation/gasStationList");
		
		return mav;
	}

}
