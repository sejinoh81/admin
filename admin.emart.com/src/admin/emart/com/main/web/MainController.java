package admin.emart.com.main.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.emart.com.common.service.CommonService;

@Controller
public class MainController {

	@Resource(name = "commonService")
	protected CommonService commonService;

    /**
	 * bootstrap test page
     * @throws Exception
	 */
	@RequestMapping(value="/egovframework/Dashboard/indexes.do")
	public ModelAndView Bootstrap(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		ModelAndView mav=new ModelAndView();

//		mav.setViewName("/egovframework/Dashboard/index");
		mav.setViewName("/egovframework/Dashboard/indexes");

		return mav;
	}

    /**
	 * 메인페이지 조회
     * @throws Exception
	 */
	@RequestMapping(value="/traders/main/main.do")
	public ModelAndView Login(HttpServletRequest request, ModelMap model) throws Exception {

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		ModelAndView mav=new ModelAndView();
//		List<HashMap<String, String>> resultCouponList = new ArrayList<HashMap<String, String>>();
//		HashMap<String, Object> resultCurrCnt = new HashMap<String, Object>();
//		HttpSession session = request.getSession();
//		SessionVO adminprofile = (SessionVO) session.getAttribute("adminprofile");
//
//		if("C".equals(adminprofile.getKind()) || "W".equals(adminprofile.getKind())) { //C : 본사, W : 협력사
//			resultCouponList = mmsService.selectCouponDownloadErrList();
//			resultCurrCnt = statisticsService.selectCurrentCnt();
//		}
//
//		AdminPropertyService adminPropertyService = new AdminPropertyService(request);
//		String jijumId = adminPropertyService.getJijumId();
//
//		if (!CommonStringUtil.isEmpty(jijumId)) {
//			JijumVO tmpVO = new JijumVO();
//			tmpVO.setId(jijumId);
//
//			JijumVO jijumVO = jijumService.select(tmpVO);	// 지점정보 조회
//			FavoriteJijumVO favoriteJijumVO = jijumService.selectJijumFavoriteCnt(jijumId);
//
//			mav.addObject("jijumVO", jijumVO);
//			mav.addObject("favoriteJijumVO", favoriteJijumVO);
//		}
//
//		mav.addObject("kind", adminprofile.getKind());
//		mav.addObject("resultCouponList", StringUtil.getHashMapListByDecode(resultCouponList));
//		mav.addObject("event_cnt", resultCurrCnt!=null?resultCurrCnt.get("EVENT_CNT"):0);
//		mav.addObject("cpnBook_cnt", resultCurrCnt!=null?resultCurrCnt.get("CPNBOOK_CNT"):0);
//		mav.addObject("event_cnt_tom", resultCurrCnt!=null?resultCurrCnt.get("EVENT_CNT_TOM"):0);
//		mav.addObject("cpnBook_cnt_tom", resultCurrCnt!=null?resultCurrCnt.get("CPNBOOK_CNT_TOM"):0);
//		mav.addObject("toDay",StringUtil.getFormatTodayK("yyyy-MM-dd E요일"));
////		mav.addObject("resultEventList", StringUtil.getHashMapListByDecode(resultEventList));
		mav.setViewName("/traders/main/main");

		return mav;
	}

//    /**
//	 * redis 기동
//     * @throws Exception
//	 */
//	@RequestMapping(value="a/common/redisStart.do")
//	public void redisStart(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		String username = "emartweb";
//        String host = "174.100.29.31";
//        int port = 22;
//        String password = "emrtdevJan!1";
//
//        System.out.println("==> Connecting to" + host);
//        Session session = null;
//        Channel channel = null;
//
//        // 2. 세션 객체를 생성한다 (사용자 이름, 접속할 호스트, 포트를 인자로 준다.)
//        try {
//            // 1. JSch 객체를 생성한다.
//            JSch jsch = new JSch();
//            session = jsch.getSession(username, host, port);
//
//            // 3. 패스워드를 설정한다.
//            session.setPassword(password);
//
//            // 4. 세션과 관련된 정보를 설정한다.
//            java.util.Properties config = new java.util.Properties();
//            // 4-1. 호스트 정보를 검사하지 않는다.
//            config.put("StrictHostKeyChecking", "no");
//            session.setConfig(config);
//
//            // 5. 접속한다.
//            session.connect();
//
//            // 6. sftp 채널을 연다.
//            channel = session.openChannel("exec");
//
//            // 8. 채널을 SSH용 채널 객체로 캐스팅한다
//            ChannelExec channelExec = (ChannelExec) channel;
//
//            System.out.println("==> Connected to" + host);
//
//            channelExec.setCommand("touch /emartweb/redis/jschTest.txt");
//            channelExec.connect();
//
//            System.out.println("==> Connected to" + host);
//
//        } catch (JSchException e) {
//            e.printStackTrace();
//        } finally {
//            if (channel != null) {
//                channel.disconnect();
//            }
//            if (session != null) {
//                session.disconnect();
//            }
//        }
//	}
//
//
//    /**
//	 * 메인페이지 조회
//     * @throws Exception
//	 */
//	@RequestMapping(value="a/common/pdfReader.do")
//	public void pdfReader(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
////		PDDocument document = null;
//
//
//	}

}
