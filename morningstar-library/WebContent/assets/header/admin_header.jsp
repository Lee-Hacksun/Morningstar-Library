<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=1280">
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
    <title>샛별문고</title>
</head>
<body>
	<div id="header">
        <header>
            <div class="bg-white">
                <nav class="bg-white border-b border-gray-200 px-4 py-2.5 fixed left-0 right-0 top-0 z-50">
                    <div class="flex flex-wrap justify-between items-center">
                        <div class="flex justify-start items-center">
                            <a href="/admin_index.jsp" class="flex items-center justify-between mr-4">
                                <img class="w-10 mr-3" src="../assets/icons/morningstarlogo.png" alt="logo">
                                <span class="self-center text-2xl font-semibold whitespace-nowrap">ADMINISTRATOR</span>
                            </a>
                        </div>
                        <div class="flex items-center lg:order-2">
                            <a href="/" class="block py-2 px-4 text-sm text-slate-700 font-semibold hover:bg-gray-100">
                                로그아웃</a>
                        </div>
                    </div>
                </nav>
            </div>
        </header>
    </div>
</body>
</html>