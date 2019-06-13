<%@ page contentType="text/html; charset=UTF-8" errorPage="/common/error/error500.jsp" %>

<!-- %@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<!-- %@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> -->
<!-- %@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> -->
<!-- %@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> -->
<!-- %@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %> -->

<%@ include file="/WEB-INF/jsp/include/common.jsp" %>

    <h3>팝업 관리</h3>
    
    <!-- 
    <form name="f" method="post">
    <input type="hidden" name="currentPage" id="currentPage" value="<c:out value='${searchVO.currentPage }'/>" /> 
    <input type="hidden" name="rowsPerPage" id="rowsPerPage" value="<c:out value='${searchVO.rowsPerPage }'/>" />
    <input type="hidden" name="eventType" id="eventType" value="<c:out value='${searchVO.searchType }'/>" />
    <input type="hidden" name="master_cd" id="master_cd" />
     -->
    
    <div class="search01">
    <fieldset>
        <legend>검색 폼</legend>
        <div>
            <ul>
                <li class="tit1"><strong>검색어</strong>&nbsp;&nbsp;&nbsp;</li>
                <li>
                    <select style="width:100px" name="searchDisplayYn" id="searchDisplayYn">
                        <option value="">전체</option>
                        <option value="Y">공개</option>
                        <option value="N">비공개</option>
                    </select>
                </li>
                <li>&nbsp;<input type="text" name="searchValue" id="searchValue" value='${searchVO.currentPage }'  style="width:200px;" class="box2" /></li>
                <li>&nbsp;<button class="btn2" value="검색" onclick="return doSearch();" >검색</button></li>
                            
            
            
            
            
            
                <li class="tit1"><strong>게시</strong>&nbsp;&nbsp;</li>
                <li>
                    <c:choose>
                        <c:when test="${searchVO.searchKind eq  'Y'}">
                            <input type="radio" name="searchKind" id="searchKind" value="" />전체
                            <input type="radio" name="searchKind" id="searchKind" value="Y" checked="checked" />공개
                            <input type="radio" name="searchKind" id="searchKind" value="N" />비공개
                        </c:when>
                        <c:when test="${searchVO.searchKind eq  'N'}">
                            <input type="radio" name="searchKind" id="searchKind" value=""  />전체
                            <input type="radio" name="searchKind" id="searchKind" value="Y"  />공개
                            <input type="radio" name="searchKind" id="searchKind" value="N" checked="checked" />비공개
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="searchKind" id="searchKind" value="" checked="checked" />전체
                            <input type="radio" name="searchKind" id="searchKind" value="Y" />공개
                            <input type="radio" name="searchKind" id="searchKind" value="N" />비공개
                        </c:otherwise>
                    </c:choose>
                    
                    &nbsp;&nbsp;
                </li>
                </br>
                </br>
                
                <li class="tit1"><strong>기간</strong>&nbsp;&nbsp;</li>
                <li>
                    <select id="searchDayType" name="searchDayType">
                        <option value="1" <c:if test="${searchVO.searchDayType eq '1'}">selected</c:if> >시작일</option>
                        <option value="2" <c:if test="${searchVO.searchDayType eq '2'}">selected</c:if> >종료일</option>
                    </select>
                    &nbsp;
                </li>
                <li><input type="text" name="sdate" id="sdate" $NAME="응모기간 시작일" REQUIRED style="width:100px;" class="cal required" readonly value="<c:out value='${searchVO.sdate }'/>"/></li>
                <li style="padding-left:5px;"><img src="${CDN_HTTP_URL}/images/bu02.gif" alt="" name="sdate_trigger" id="sdate_trigger" style="cursor:pointer;" class="trigger" /></li>
                <li style="padding:0 10px;">~</li>
                <li><input type="text" name="edate" id="edate" $NAME="응모기간 종료일" REQUIRED style="width:100px;"  class="cal required" readonly value="<c:out value='${searchVO.edate }'/>"/></li>
                <li style="padding-left:5px;"><img src="${CDN_HTTP_URL}/images/bu02.gif" alt="" id="edate_trigger" style="cursor:pointer;" class="trigger" />&nbsp;&nbsp;&nbsp;&nbsp;</li>
                <li class="tit1"><strong>검색</strong>&nbsp;</li>         
                <li>
                    <select style="width:90px" name="searchType" id="searchType" class="required" $NAME="이벤트 유형" >
                        <option value="" selected="selected">전체</option>
                        <option value="10">일반공지</option>
                        <option value="20">응모</option>
                        <option value="30">즉시당첨</option>
                        <option value="40">점포증정</option>
                        <option value="50">추첨후발표</option>
                        <option value="60">후기형</option>
                        <option value="70">카드행사형</option>
                    </select>
                    &nbsp;
                </li>
                <li><input type="text" name="searchValue" id="searchValue" style="width:120px;" class="box2 required" $NAME="검색어" value="<c:out value='${searchVO.searchValue}'/>"/></li>
                <li>&nbsp;<button class="btn2" value="검색" onclick="return doSearch();" >검색</button></li>
                
            </ul>
        </div>
    </fieldset>             
    </div>
    </form>
    
    <p class="total1">전체건수 : <span>${paginationInfo.totalRecordCount }</span> 건</p>
    
    <table class="List1">
    <colgroup>
        <col width="4%" />
        <col width="10%" />
        <col width="10%" />
        <col width="" />
        <col width="13%" />
        <col width="13%" />
        <col width="10%" />
        <col width="13%" />
        <col width="10%" />
    </colgroup>
    <thead>
        <tr>
            <th>No.</th>
            <th>이벤트NO.</th>
            <th>이벤트유형</th>
            <th>이벤트명</th>
            <th>시작일</th>
            <th>종료일</th>
            <th>공개여부</th>
            <th>우선순위</th>
            <th>지점정보</th>
        </tr>
    </thead> 
    <tbody>
    
        <c:choose>
        
            <c:when test="${resultList ne null && paginationInfo.totalRecordCount > 0}">
                
                <c:forEach var="result" items="${resultList }" varStatus="i">
                
                    <tr>
                        <td>${paginationInfo.totalRecordCount - (result.rnum -1 )}</td>
                        <td>${result.master_cd}</td>
                        <td  style="text-align:center;">
                            
                            <c:choose>
                                <c:when test="${result.event_type eq '10'}">
                                일반공지형
                                </c:when>
                                <c:when test="${result.event_type eq '20'}">
                                응모형
                                </c:when>
                                <c:when test="${result.event_type eq '30'}">
                                즉시당첨형
                                </c:when>
                                <c:when test="${result.event_type eq '40'}">
                                점포증정형
                                </c:when>
                                <c:when test="${result.event_type eq '50'}">
                                추첨발표형
                                </c:when>
                                <c:when test="${result.event_type eq '60'}">
                                후기형
                                </c:when>
                                <c:when test="${result.event_type eq '70'}">
                                카드행사형
                                </c:when>
                            </c:choose>
                        </td>
                        <td  style="text-align:left;">
                            <a href="javascript:fn_eventView(${result.master_cd }, ${result.event_type});">${result.event_nm_d }</a>
                        </td>
                        <td>
                            <fmt:formatDate value="${result.start_dt}" pattern="yy-MM-dd"/>
                            <c:if test="${result.start_hh24 ne null}">
                            &nbsp;&nbsp;${result.start_hh24}:${result.start_mi}
                            </c:if>
                        </td>
                        <td><fmt:formatDate value="${result.end_dt }" pattern="yy-MM-dd"/>
                        <c:if test="${result.end_hh24 ne null}">
                        &nbsp;&nbsp;${result.end_hh24}:${result.end_mi}
                        </c:if>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${result.display_yn eq 'Y' }">
                                    <font color=blue><b>공개</b><font>
                                </c:when>
                                <c:otherwise>
                                    비공개
                                </c:otherwise>
                            </c:choose>
                            
                        </td>
                        <td>
                            <input type="text" style="width: 30px;" class="box2 only_number" name="sortno" id="sortno${result.master_cd}" value="${result.sortno}" />
                            <button class="btn1 visible" type="button"  onclick="fn_sortNoSwitch(${result.master_cd},$('#sortno${result.master_cd}').val());">수정</button>
                        </td>
                        <td>
                        <c:choose>
                        <c:when test="${result.gubun eq '30'&& result.jijum_open eq 'B' }">
                            <button class="btn1 visible" type="button" onclick="fn_jijumSelect(${result.master_cd});">점포</button>
                        </c:when>
                        <c:when test="${result.gubun eq '30'&& result.jijum_open eq 'A' }">
                            <button type="button" onclick="fn_jijumSelect(${result.master_cd});">전점</button>
                        </c:when>                       
                        <c:otherwise> - </c:otherwise>
                        </c:choose>
                        </td>
                        <%-- 
                        <td>
                            
                            <c:if test="${paginationInfo.totalRecordCount eq 1}">
                            -
                            </c:if>
                                
                            <c:if test="${paginationInfo.totalRecordCount ne 1}">
                                <c:choose>  
                                    <c:when test="${(paginationInfo.totalRecordCount - (result.rnum -1 )) eq paginationInfo.totalRecordCount }">
                                        <button class="btn1 visible" type="button" onclick="javascript:fn_sortNoSwitch('${result.master_cd}' , '${result.sortno}' , '<'); return false;">▼</button>
                                    </c:when>
                                    <c:when test="${result.rnum eq paginationInfo.totalRecordCount}">
                                        <button class="btn1 visible" type="button" onclick="javascript:fn_sortNoSwitch('${result.master_cd}' , '${result.sortno}', '>'); return false;">▲</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn1 visible" type="button" onclick="javascript:fn_sortNoSwitch('${result.master_cd}' , '${result.sortno}', '>'); return false;">▲</button>
                                        <button class="btn1 visible" type="button" onclick="javascript:fn_sortNoSwitch('${result.master_cd}' , '${result.sortno}', '<'); return false;">▼</button>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                            
                        </td>
                        --%>
                    </tr>
                
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="9"><span class="no1">검색된 게시물이 없습니다.</span></td>
                </tr>       
            </c:otherwise>
            
        </c:choose>
        
        
    </tbody>
    </table>
    
    <div class="btnR">
        <c:if test="${((searchVO.searchKind ne null) or (searchVO.searchKind ne '')) && ((searchVO.searchValue ne null) or (searchVO.searchValue ne ''))}">
            <button class="btn1" value="전체목록" onclick="doAllList();">전체목록</button>&nbsp;
        </c:if>
    </div>
    
    <%-- 페이지 --%>
    
    <tiles:insertDefinition name="unit.board.page">
        <tiles:putAttribute name="boardPage" value="${paginationInfo}" />
    </tiles:insertDefinition>
    <%-- //페이지 --%> 
    <!-- //contents -->
    
    <script type="text/javascript">
                
        //달력 컨트롤 일괄 초기화
        function fn_initCalendar()
        {   
            $(".cal").each(function(index){
                
                $(this).datepicker({dateFormat:'yy-mm-dd', changeYear: true });
                
                var obj = $(this);
                var trigger = $(this)[0].id + '_trigger';
                
                $($('#' + trigger)).click(function() 
                { 
                    $(obj).datepicker("show");
                });
            });
        }
        
        function paging(page) { 
            var f = document.f;
            f.currentPage.value = page;
            f.action = "<c:url value='/event/progress_list.do'/>";
            f.submit();
        }
        
        
        function doAllList() { 
            $(":radio[name='searchKind']:first").attr("checked", true);
            
            $('#sdate').val('');
            $('#edate').val('');
            $('#searchType').val('');
            $('#searchValue').val('');
            
            doSearch();
        }
        
        function doErrorMessage($obj, message)
        {
            alert(message);
            $obj.focus();
            
            return false;
        }
        
        function doSearch() { 
            
            if($('#sdate').val()!='' && $('#edate').val() =='')
            {
                return doErrorMessage($('#edate'), '응모기간 종료일을 입력 해주세요.');
            }
            
            $("#currentPage").val('1');

            var f = document.f;
            f.action = '/event/progress_list.do';
            f.submit();
            
            return false;
        }
        
        function initSearchParam()
        {
            if($('#eventType').val()!=null && $('#eventType').val()!='')
            {
                $('#searchType').val($('#eventType').val());
            }
        }
        
        function fn_sortNoSwitch(master_cd, sortno)
        {   
            if(sortno.trim() =='')
            {
                alert('우선 순위를 입력해주세요.');
                $('#sortno' + sortno).focus();
                
                return false;
            }
            
            $.ajax({
                type        : "POST",
                url         : '/event/modifySortNo.do',
                dataType    : 'json',
                data :  { master_cd     : master_cd
                        , sortno        : sortno
                        }, 
                success : function(data) { 
                    
                    paging($('#currentPage').val());
                    
                },
                error   : function(result, status)
                {   
                    alert('오류가 발생 하였습니다.');
                }
            });
            
        }
        
        function fn_buttonHidden()
        {   
            $.each($('.required'),function(index)
            {
                if($(this).val() !='' )
                {
                    $('.visible').hide();
                    return false;
                }
            });
        }
        
        function fn_eventView(master_cd, event_type)
        {
            $('#master_cd').val(master_cd);
            
            var url;
            
            if(event_type =='10')
                url='/event/notice/getNoticeEventInfo.do';
                
            if(event_type =='20')
                url='/event/join/getJoinEventInfo.do';
            
            if(event_type =='30')
                url='/event/immdt/getImmdtEventInfo.do';
                
            if(event_type =='40')
                url='/event/present/getPresentEventInfo.do';
            
            if(event_type =='50')
                url='/event/later/getLaterEventInfo.do';
                
            if(event_type =='60')
                url='/event/review/getReviewEventInfo.do';  
            
            if(event_type =='70')
                url='/event/card/getCardEventInfo.do';  
            
            var f = document.f;
            f.action = url;
            f.submit();
            
            return false;
        }
        
        $(document).ready(function() 
        {   
            fn_initCalendar();
            
            initSearchParam();
            
            fn_buttonHidden();
            
            $('.only_number').keypress(function(event){ 
                if (event.which && (event.which > 47 && event.which < 58 || event.which == 8)) { 
                } else { 
                    event.preventDefault(); 
                } 
            });
        });
        
        function fn_jijumSelect(seq){
            var contgubun = 'EL';

            var status = "toolbar=no,directories=no,scrollbars=yes,resizable=no,status=no,menubar=no,width=850, height=750, top=0,left=0"; 
            var url='/site/jijumOpenList.do?contgubun='+contgubun+"&seq="+seq;
            window.open(url , "지점정보" , status);
            
            return false;       
        }
    </script>