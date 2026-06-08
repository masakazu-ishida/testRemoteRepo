<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTLのコアタグライブラリを使用するための宣言 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
    <%-- 
    <style>
        .login-container { width: 300px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; }
        .form-group input { width: 100%; padding: 8px; box-sizing: border-box; }
        .error-message { color: red; margin-bottom: 15px; }
        .submit-btn { width: 100%; padding: 10px; background-color: #007BFF; color: white; border: none; cursor: pointer; }
    </style>
    --%>
</head>
<body>


    <h2>ログイン</h2>

    <%-- EL式とJSTLを使い、errorMessageが「空ではない（値が存在する）」場合のみ表示 --%>
    <c:if test="${not empty errorMessage}">
        <div class="error-message">
            <c:out value="${errorMessage}" />
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
       
            <label for="userId">ユーザーID</label>
            <input type="text" id="userId" name="userId" required>
       		<br>
        
        
            <label for="password">パスワード</label>
            <input type="password" id="password" name="password" required>
     
        
        <button type="submit">ログイン</button>
    </form>
</div>

</body>
</html>
