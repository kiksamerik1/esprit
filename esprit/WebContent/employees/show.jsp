<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<META http-equiv="Content-type" content="text/html; charset=UTF-8">
<f:view>
    <html>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/application.css"/>
    
    <head>
        <title>edit</title>
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
     	<h1><h:outputLabel value=" Details about #{epctr.employee.firstname}"/></h1>
     	<ul>
     		<li>
	     		<h:outputLabel value="Firstname: "/>
	     		<h:outputLabel value="#{epctr.employee.firstname}"/>
     		</li>
     		<li>
	     		<h:outputLabel value="Lastname: "/>
	     		<h:outputLabel value="#{epctr.employee.lastname}"/>
     		</li>
     		<li>
	     		<h:outputLabel value="email: "/>
	     		<h:outputLabel value="#{epctr.employee.email}"/>
     		</li>
     	</ul>
     <h:form>
     	<h:panelGrid columns="5">
     		<h:commandLink value="edit" action="employees.edit" />|
	      	<h:commandLink value="delete" action="#{epctr.destroyEmployee}" />|
	      	<h:commandLink value="employees list" action="#{epctr.listEmployees}"  />
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