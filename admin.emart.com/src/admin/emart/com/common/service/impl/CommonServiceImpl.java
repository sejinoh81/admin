package admin.emart.com.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import admin.emart.com.common.dao.CommonDAO;
import admin.emart.com.common.service.CommonService;
import admin.emart.com.common.vo.CommonVO;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
  
	@Resource(name = "commonDAO")  
	private CommonDAO commonDAO;
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	public List<CommonVO> main() throws Exception {
		return commonDAO.boardListMain();
	}
}
