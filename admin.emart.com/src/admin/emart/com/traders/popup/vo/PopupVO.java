package admin.emart.com.traders.popup.vo;

import admin.emart.com.util.StringUtil;

public class PopupVO {

	private String seq;
	private String display_start_dt;
	private String display_end_dt;
	private String display_yn;
	private String title;
	private String content;
	private String width;
	private String height;
	private String top_pixel;
	private String left_pixel;
	private String top_center_yn;
	private String left_center_yn;
	private String scrollbars;
	private String check_oneday;
	private String delete_yn;
	private String regist_admin_id;
	private String regist_dt;
	private String modify_admin_id;
	private String modify_dt;

	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getDisplayStartDt() {
		return display_start_dt;
	}
	public void setDisplayStartDt(String display_start_dt) {
		this.display_start_dt = display_start_dt;
	}
	public String getDisplayEndDt() {
		return display_end_dt;
	}
	public void setDisplayEndDt(String display_end_dt) {
		this.display_end_dt = display_end_dt;
	}
	public String getDisplayYn() {
		return display_yn;
	}
	public void setDisplayYn(String display_yn) {
		this.display_yn = display_yn;
	}
	public String getTitle() {
		return title;
	}
	public String getTitleDec() {
		return StringUtil.decode(title);
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public String getContentDec() {
		return StringUtil.decode(content);
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getTopPixel() {
		return top_pixel;
	}
	public void setTopPixel(String top_pixel) {
		this.top_pixel = top_pixel;
	}
	public String getLeftPixel() {
		return left_pixel;
	}
	public void setLeftPixel(String left_pixel) {
		this.left_pixel = left_pixel;
	}
	public String getTopCenterYn() {
		return top_center_yn;
	}
	public void setTopCenterYn(String top_center_yn) {
		this.top_center_yn = top_center_yn;
	}
	public String getLeftCenterYn() {
		return left_center_yn;
	}
	public void setLeftCenterYn(String left_center_yn) {
		this.left_center_yn = left_center_yn;
	}
	public String getScrollbars() {
		return scrollbars;
	}
	public void setScrollbars(String scrollbars) {
		this.scrollbars = scrollbars;
	}
	public String getCheckOneday() {
		return check_oneday;
	}
	public void setCheckOneday(String check_oneday) {
		this.check_oneday = check_oneday;
	}
	public String getDeleteYn() {
		return delete_yn;
	}
	public void setDeleteYn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	public String getRegistAdminId() {
		return regist_admin_id;
	}
	public void setRegistAdminId(String regist_admin_id) {
		this.regist_admin_id = regist_admin_id;
	}
	public String getRegistDt() {
		return regist_dt;
	}
	public void setRegistDt(String regist_dt) {
		this.regist_dt = regist_dt;
	}
	public String getModifyAdminId() {
		return modify_admin_id;
	}
	public void setModifyAdminId(String modify_admin_id) {
		this.modify_admin_id = modify_admin_id;
	}
	public String getModifyDt() {
		return modify_dt;
	}
	public void setModifyDt(String modify_dt) {
		this.modify_dt = modify_dt;
	}

}
