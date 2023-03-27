<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<c:import url="./header.jsp"></c:import>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <title>EnjoyTrip</title>
    
    <style>
    	.row {
    		margin: 0 auto;
    	}
    	
    	.col {
    		margin : 20px 0px 20px 0px; 
    	}
    
    </style>
</head>
<body>

<div class="main">
	<div class="container">
	  <div class="row">
		  <h2 style="font-weight: bold;">
	      	핫플레이스
	      </h2>
	      
	      <div style="margin-bottom: 100px">
	            <div class="col-md-7 offset-3">
	              <form class="d-flex" id="form-search" name="form-search" action="">
	                <input type="hidden" name="action" value="list"/>
	                <input type="hidden" name="pgno" value="1"/>
	                <select
	                  name="key"
	                  id="key"
	                  class="form-select form-select-sm ms-5 me-1 w-50"
	                  aria-label="검색조건"
	                >
	                  <option selected disabled>검색조건</option>
	                  <option value="id">글번호</option>
	                  <option value="title">제목</option>
	                  <option value="user_id">작성자</option>
	                </select>
	                <div class="input-group input-group-sm">
	                  <input type="text" name="word" id="word" class="form-control" value="${word}" placeholder="검색어..." />
	                  <button id="btn-search" class="btn btn-dark" type="button">검색</button>
	                </div>
	              </form>
	            </div>
	            
	      </div>
		  
	<c:forEach var="hotplace" items="${hotplaces}">

	    <div class="col-auto mb-3 hotplacePage">
	    
	      <div class="card" style="width: 18rem;">
			  <img src="./img/test11.jpg" class="card-img-top" alt="">
			  <div class="card-body d-flex justify-content-between m-1 ">
			    <h5 class="card-title align-self-center">${hotplace.title}</h5>
			    
			    <form id="formparam" name="formparam" method="POST" action="${root}/hotplace?action=view&pgno=${navigation.currentPage}&key=${key}&word=${word}">
			      <input type="hidden" id="hotplace-id" name="hotplace-id" value="${hotplace.id}">
			      <button type="submit" class="boardbtn btn btn-primary align-self-center">
			      <i class="bi bi-three-dots"></i></button>
			  	</form>
			    
			    
			  </div>
			</div>
			
	    </div>
	    
	  </c:forEach>
	  
	  </div>
	  
	  <div class="row" style="margin-top:50px">
      	  ${navigation.navigator}
      </div>
      
      <form id="form-page" method="get" action="">
	      <input type="hidden" id="p-action" name="action" value="">
	      <input type="hidden" id="p-pgno" name="pgno" value="">
	      <input type="hidden" id="p-key" name="key" value="">
	      <input type="hidden" id="p-word" name="word" value="">
      </form>
      
      <!--핫플추가하기 버튼-->
       <div>
      	<span style="float:right; margin-bottom:20px"><button type="button" class="btn btn-primary" onclick="location.href='${root}/hotplace.jsp'">핫플 자랑하기</button></span><br>
      </div>
	</div>
</div>

<script>
// 페이징 처리 

var pageNum = 0;

let pages = document.querySelectorAll(".page-link");
pages.forEach(function (page) {
  page.addEventListener("click", function () {
    document.querySelector("#p-action").value = "list";
 	document.querySelector("#p-pgno").value = this.parentNode.getAttribute("data-pg");
 	document.querySelector("#p-key").value = "${param.key}";
 	document.querySelector("#p-word").value = "${param.word}";
    document.querySelector("#form-page").submit();
  });
});

// 검색 
document.querySelector("#btn-search").addEventListener("click", function () {
 	let form = document.querySelector("#form-search");
    form.setAttribute("action", "${root}/hotplace");
    form.submit();
});

</script>
<c:import url="./footer.jsp"></c:import>
</body>
