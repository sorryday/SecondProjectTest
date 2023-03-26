<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:import url="header.jsp"></c:import>
<c:set var="root" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <title>EnjoyTrip</title>
</head>

<body>
<!--  여기서 부터 시작 -->
		<section>
		    <div class="d-flex flex-column align-items-center">
		        <h1 class="fw-bold mt-5 mb-3">나만의 핫플 자랑하기</h1>
		        <div class="container mb-5">
		            <div class="row">
		                <div class="col-6">
		                    <div id="map" style="width: 100%; height: 600px"></div>
		                </div>
		                <div class="col-6">
		                
		                    <form action="" method="POST" name="hotplaceViewForm">
		                        
		                        <div class="mb-3">
		                            <label for="place-name" class="form-label">핫플 이름</label>
		                            <input type="text" class="form-control" id="title" name="title" value= "${selectedHotPlace.title}" size="15" readonly/>
		                        </div>
		                        <div class="mb-3">
		                            <label for="date" class="form-label">다녀온 날짜</label>
		                            <input type="date" class="form-control" id="date" name="date" value="${selectedHotPlace.date}" readonly/>
		                        </div>
		                        <div class="mb-3">
		                            <label for="type-select" class="form-label">장소 유형</label>
		                            <select class="form-select" id="type" name="type"  disabled="disabled">
		                                <option selected disabled>관광지 유형</option>
		                                <option value="12" ${selectedHotPlace.placetype == 12 ? 'selected="selected"' : '' }>관광지</option>
		                                <option value="14" ${selectedHotPlace.placetype == 14 ? 'selected="selected"' : '' }>문화시설</option>
		                                <option value="15" ${selectedHotPlace.placetype == 15 ? 'selected="selected"' : '' }>행사/공연/축제</option>
		                                <option value="25" ${selectedHotPlace.placetype == 25 ? 'selected="selected"' : '' }>여행코스</option>
		                                <option  value="28" ${selectedHotPlace.placetype == 28 ? 'selected="selected"' : '' }>레포츠</option>
		                                <option  value="32" ${selectedHotPlace.placetype == 32 ? 'selected="selected"' : '' }>숙박</option>
		                                <option  value="38" ${selectedHotPlace.placetype == 38 ? 'selected="selected"' : '' }>쇼핑</option>
		                                <option  value="39" ${selectedHotPlace.placetype == 39 ? 'selected="selected"' : '' }>음식점</option>
		                            </select>
		                        </div>
		                        
		                        <input type="hidden" id = "latitude" name="latitude" value="${selectedHotPlace.latitude}">
		                        <input type="hidden" id = "longitude" name="longitude" value="${selectedHotPlace.longitude}">
		                        
		                        
		                        <div class="mb-3">
		                            <label for="content" class="form-label">상세설명</label>
		                            <textarea id="content" name="content" class="form-control" readonly>${selectedHotPlace.content}</textarea>
		                        </div>
		                        
		                        <input type="hidden" id="selectedHotPlace-id" name="selectedHotPlace-id" value="${selectedHotPlace.id}">
		                        <div>
		                        	<button type="submit" id="register-button" class="btn btn-success container-fluid"  
		                        	formaction="${root}/hotplace?action=mvmodify&pgno=1&key=&word=">
		                        		수정
		                        	</button>
		                        	
		                        	<button type="submit" id="register-button" class="btn btn-danger container-fluid" style="margin-top: 20px"
		                        	formaction="${root}/hotplace?action=delete&pgno=1&key=&word=" onclick = "return confirm('정말 삭제할까요?')" >
		                        			삭제
		                        	</button>
		                        	
		                        	<button type="submit" id="register-button" class="btn btn-info text-white container-fluid" style="margin-top: 20px"
		                        	formaction="${root}/hotplace?action=list&pgno=1&key=&word=" >
		                        			목록
		                        	</button>
		                        </div>
		                    </form>
		                </div>
		            </div>
		        </div>
		    </div>
		</section>

<!--  여기서끝 -->


<c:import url="footer.jsp"></c:import>

<script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d07dd8988b0ead77351bbfd00f03228f"></script>
<script src="https://cdn.jsdelivr.net/npm/exif-js"></script>

<script>
	var lat = ${selectedHotPlace.latitude};
	var lot = ${selectedHotPlace.longitude};
	
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(lat, lot), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);
    
    const markerPosition = new kakao.maps.LatLng(lat, lot);
    const marker = new kakao.maps.Marker({
        position: markerPosition
    });
    marker.setMap(map);
    map.setCenter(markerPosition);
    
</script>
</body>
</html>