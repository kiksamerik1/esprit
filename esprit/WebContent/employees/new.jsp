<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<META http-equiv="Content-type" content="text/html; charset=UTF-8">
<f:view>
    <html>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/application.css"/>
    
    <head>
        <title>new</title>
    </head>	
    <body>
	<div id="container">
    <div id="topbar">
		<%@ include file="/common/header.jspf" %>
    </div>
    
    <div id="identity">
		<%@ include file="/common/identity.jspf" %>
    </div>
    <div id="search">
		<%@ include file="/common/search.jspf" %>
    </div>
    
    <div id="main">
    <h1>New Employee</h1>
     <h:form>
     	<h:panelGrid columns="2">
     		<h:outputText value="Firstname"/>
     		<h:inputText value="#{epctr.employee.firstname}"/>
     		
     		<h:outputText value="Lastname"/>
     		<h:inputText value="#{epctr.employee.lastname}"/>
     		<h:outputText value="email"/>
     		<h:inputText value="#{epctr.employee.email}"/>
     		
     	</h:panelGrid >
     		
     	<h:panelGrid columns="1">
     		<h:commandButton value="save" action="#{epctr.createEmployee}" />
	      	<h:commandLink value="employees list" action="#{epctr.listEmployees}" />
     	</h:panelGrid>
     </h:form>
    	
    </div>
    <div id="navbar"> 
       	<%@ include file="/common/navigation.jspf" %>
    </div>
     
    <div class="footer">
    	<div>
         <%@ include file="/common/footer.jspf" %>
        </div> 
    </div>
	</div>
	</body>
    </html>
</f:view>