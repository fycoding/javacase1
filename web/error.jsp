<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>错误提示</title>
</head>
<body>
    <h1>${error_msg}</h1>
    <button class="back">返回</button>
</body>
<script>
    document.querySelector('.back').addEventListener('click', function() {
        window.history.back();
    })
</script>
</html>