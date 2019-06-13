package admin.emart.com.traders.popup.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.emart.com.traders.popup.service.PopupService;
import admin.emart.com.traders.popup.vo.PopupVO;

@Controller
public class PopupController {

	@Resource(name = "popupService")
	protected PopupService popupService;

	@RequestMapping(value = "/traders/popup/popupList.do")
	public ModelAndView popupList(HttpServletRequest request, HttpServletResponse response, PopupVO popupVO) throws Exception {

		ModelAndView mav = new ModelAndView();

		List<PopupVO> resultList = popupService.popupList();

		mav.addObject("resultList", resultList);
		mav.setViewName("/traders/popup/popupList");

		return mav;
	}

	@RequestMapping(value = "/kcp/order.do")
	public ModelAndView order(HttpServletRequest request, HttpServletResponse response, PopupVO popupVO) throws Exception {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("/kcp/order");

		return mav;
	}

}
