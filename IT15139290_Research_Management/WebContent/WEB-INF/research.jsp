<% page import = "com.Research.AddResearch" %>
<% page import ="javax.sql. *" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
    Research research = new Research();
	String researchesGrid = "";
	String rudFeedBack = "";
	
	if(request.getParameter(hidMode) != null & request.getParameter("hidMode"). equalsIgnoreCase("save"))
	{
		rudFeedback = research.saveAResearch(request.getParameter("txtResearchName"), request.getParameter("txtAuthor1"),request.getParameter("txtAuthor2"),request.getParameter("txtAuthor3"),request.getParameter("txtField"),request.getParameter("txtPublisher"),request.getParameter("txtPublishYear"),request.getParameter("txtBudget"));
	}
	
	if(request.getParameter(hidMode) != null && request.getParameter("hidMode"). equalsIgnoreCase("update"))
	{
		rudFeedback = research.updateAResearch(request.getParameter("hidID"), request.getParameter("txtIResearchName"),
		 request.getParameter("txtAuthor1"),
		 request.getParameter("txtAuthor2"),
		 request.getParameter("txtAuthor3"),
		 request.getParameter("txtField"),
		 request.getParameter("txtPublisher"),
		 request.getParameter("txtPublishYear"),
		 request.getParameter("txtBudget"));
		
	}
	
	if(request.getParameter(hidMode) != null && request.getParameter("hidMode"). equalsIgnoreCase("remove"))
	{
		rudFeedback = research.deleteAResearch(request.getParameter("hidID"));

	}h
	
	researchesGrid = research.getResearches();
%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form id="formItems" action="research.jsp" method="post">
		<input id="hidMode" name="hidMode" type="hidden" value="save">
		<input id="hidID" name="hidID" type="hidden" value="0">
		Research Name <input id="txtResearchName" type="text" name="txtResearchName"> <br>
		Author1 <input id="txtAuthor1" type="text" name="txtAuthor1" > <br>
		Author2 <input id="txtAuthor2" type="text" name="txtAuthor2" > <br>
		Author3 <input id="txtAuthor3" type="text" name="txtAuthor3" > <br>
		Research Field <input id="txtField" type="text" name="txtField" > <br>
		Publisher <input id="txtPublisher" type="text" name="txtPublisher" > <br>
		PublishYear <input id="txtPublishYear" type="text" name="txtPublishYear" > <br>
		Budget <input id="txtBudget" type="text" name="txtBudget" > <br>
		<input id="btnSave" type="button" name="btnSave"  value="Save"> <br> <br>
		<div id="divStsMsgResearch"><% out.println(rudFeedback); %> </div>
		<% out.println(researchesGrid); %> 
	</form> <br>
	

</body>
</html> 