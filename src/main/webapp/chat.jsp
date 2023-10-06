<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="main.AccountsManager"%>
<%@ page import="main.MessageManager"%>
<%@ page import="dao.Account"%>
<%@ page import="dao.Message"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chatting page</title>

<script>
  // JavaScript code to scroll to the bottom of the message list
  var messageList = document.getElementById('message-list');
  messageList.scrollTop = messageList.scrollHeight;
</script>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="icon" href="chat-room-image.png">

</head>
<body>
  <div class="container">
    <h1>Welcome, ${name} <p title="last connect time">(${last_connect})</p></h1>
    
    <img src="chat-room-image.png" alt="Chat Room" class="chat-room-image">
    
    <div id="message-list">
      <c:if test="${not empty message}">
        <% 
	       Date date = new Date();
		   DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		   String strDate = dateFormat.format(date);
           AccountsManager managA = new AccountsManager();
           MessageManager managM = new MessageManager();
           for (Message m : managM.listMessages()) {
        	 
             request.setAttribute("content", m.getContent());
             Account acc = managA.AccountById(1L);
             request.setAttribute("nom", m.getusername());
             request.setAttribute("timetamp", m.getTimetamp());
        %>
        <div class="message-item">
          <span class="username">${nom}:</span>
          <span class="content" title="${timetamp}">${content} </span>
        </div>
        <% } %>
      </c:if>
    </div>
    
    <form action="chat" method="post">
      <div>
        <input type="text" name="msg" id="msg" placeholder="Enter message here" autocomplete="off" required/>
        <input type="hidden" name="username" value="${username}" />
        <input type="hidden" name="last_connect" value="${last_connect}" />
        <input type="hidden" name="idaccount" value="${idaccount}" />
        <input type="hidden" name="name" value="${name}" />
        <input type="hidden" name="timetamp" value="${timetamp}" />
        <input type="hidden" name="banned" value="${banned}" />
      </div>
      <input type="submit" value="Send" id="send-button" required>
    </form>
  </div>
</body>

</html>