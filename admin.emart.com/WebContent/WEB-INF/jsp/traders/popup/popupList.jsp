<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/head.jsp" %>

<body>
    <article>
        <div class="container">
            <div class="card-body">
                <h2>팝업 관리</h2>
                
                <!-- 검색영역 -->
                <form>
                    <div><button class="btn btn-sm btn-primary" value="주문" onclick="return doOrder();">주문</button></div>
                    <!-- 
                    <div class="col-md-9">
                        <span class="help-block">게시</span>
                        <span>
                            <input class="form-control" style="width:20%" id="date-input-start" type="date" name="date-input-start" placeholder="date" value="20190501"> ~ 
                            <input class="form-control" style="width:20%" id="date-input-end" type="date" name="date-input-end" placeholder="date">
                        </span>    
                    </div>
                     -->
                    
                    <!-- <div class="well">
                        <div id="datetimepicker4" class="input-append">
                            <input data-format="yyyy-MM-dd" type="text"></input>
                            <span class="add-on">
                                <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                            </span>
                        </div>
                    </div> -->
                    
                <!-- 
                <div class="input-group mb-3">검색어
                    <div class="input-group-prepend">
                        <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <a class="dropdown-item" href="#">Something else here</a>
                            <div role="separator" class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Separated link</a>
                        </div>
                    </div>
                    <input type="text" class="form-control" aria-label="Text input with dropdown button">
                </div>
                 -->
                
                </form>
                
                
                <table class="table table-striped table-sm table-hover">
                    <colgroup>
                        <col style="width:10%;" />
                        <col style="width:auto;" />
                        <col style="width:10%" />
                        <col style="width:20%" />
                        <col style="width:10%" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>배너제목</th>
                            <th>공개여부</th>
                            <th>기간</th>
                            <th>삭제</th>
                        </tr>
                    </thead>
                     
                    <tbody>
                        <c:choose>
                            <c:when test="${resultList ne null}">
                                <c:forEach var="result" items="${resultList }" varStatus="i">
                                    <tr>
                                        <td><div>123</div></td>
                                        <td><div>${result.titleDec }</div></td>
                                        <td>${result.displayYn }</td>
                                        <td>${result.displayStartDt }~${result.displayEndDt }</td>
                                        <td><button class="btn btn-sm btn-primary" value="삭제" onclick="return doDelete();">삭제</button></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="5"><span>검색된 게시물이 없습니다.</span></td>
                                </tr>       
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
    </article>
</body>

    
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
$(document).ready(function () {
$('.navbar-light .dmenu').hover(function () {
        $(this).find('.sm-menu').first().stop(true, true).slideDown(150);
    }, function () {
        $(this).find('.sm-menu').first().stop(true, true).slideUp(105)
    });
});
</script>
    
    
<script type="text/javascript">

function doOrder() {
	
}

                
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