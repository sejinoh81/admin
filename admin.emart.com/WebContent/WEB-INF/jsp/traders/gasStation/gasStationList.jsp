<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<style type="text/css">

</style>

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
                    <li><input type="text" name="searchValue" id="searchValue" style="width:120px;" class="box2 required" $NAME="검색어" value="<c:out value='${searchVO.searchValue}'/>"/></li>
                    <li>&nbsp;<button class="btn2" value="검색" onclick="return doSearch();" >검색</button></li>
                </ul>
            </div>
        </fieldset>             
    </div>
    
    <p class="total1">전체건수 : <span></span> 건</p>
                            
    <table class="List1">
    <colgroup>
        <col width="10%" />
        <col width="" />
        <col width="30%" />
    </colgroup>
    <thead>
        <tr>
            <th>번호</th>
            <th>매장명</th>
            <th>대표전화</th>
        </tr>
    </thead> 
    <tbody>
        <c:choose>
            <c:when test="${resultList ne null}">
                <c:forEach var="result" items="${resultList }" varStatus="i">
                
                    <tr>
                        <td><div class="l">123</div></td>
                        <td>${result.NAME_DEC }</td>
                        <td>(${result.TEL1 })${result.TEL2 }-${result.TEL3 }</td>
                    </tr>
                
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="3"><span class="no1">검색된 게시물이 없습니다.</span></td>
                </tr>       
            </c:otherwise>
        </c:choose>
        
    </tbody>
    </table>
    
    <%-- 
    <div class="btnR">
        <c:if test="${((searchVO.searchKind ne null) or (searchVO.searchKind ne '')) && ((searchVO.searchValue ne null) or (searchVO.searchValue ne ''))}">
            <button class="btn1" value="전체목록" onclick="doAllList();">전체목록</button>&nbsp;
        </c:if>
    </div>
     --%>
    
    <%-- 페이지 --%>
    
    <%-- 
    <tiles:insertDefinition name="unit.board.page">
        <tiles:putAttribute name="boardPage" value="${paginationInfo}" />
    </tiles:insertDefinition>
     --%>
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