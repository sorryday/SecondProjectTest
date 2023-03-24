<%--
  Created by IntelliJ IDEA.
  User: psh32
  Date: 2023-03-24
  Time: 오후 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
  <nav class="navbar navbar-expand-lg bg-info bg-opacity-75" data-bs-theme="dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="index.jsp">
        <h3 class="text-white fw-bold">EnjoyTrip</h3>
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link text-white" href="tourlist.jsp">지역별관광지</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="tourplan.jsp">나의여행계획</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="hotplace.jsp">핫플레이스</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdownMenuLink"
               role="button" data-bs-theme="dark" data-bs-toggle="dropdown"
               aria-expanded="false">게시판</a>

            <ul class="dropdown-menu bg-info" aria-labelledby="navbarDropdownMenuLink">
              <li><a class="dropdown-item text-white" href="#">공지사항</a></li>
              <li><a class="dropdown-item text-white" href="#">자유게시판</a></li>
            </ul>
          </li>
        </ul>
        <a class="btn btn-info me-3 text-white" href="login.jsp">로그인</a>
        <a class="btn btn-info text-white" href="register.jsp">회원가입</a>
      </div>
    </div>
  </nav>
</header>
