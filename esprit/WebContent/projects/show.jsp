<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<META http-equiv="Content-type" content="text/html; charset=UTF-8">
<f:view>
    <html>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/application.css"/>
    
    <head>
        <title>show</title>
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
     	<h1><h:outputLabel value=" Details about #{epctr.project.name}"/></h1>
     	<ul>
     		<li>
	     		<h:outputLabel value="Name: "/>
	     		<h:outputLabel value="#{epctr.project.name}"/>
     		</li>
     	</ul>
     <h:form>
     	<h:panelGrid columns="5">
     		<h:commandLink value="edit" action="projects.edit" />|
	      	<h:commandLink value="delete" action="#{epctr.destroyProject}" />|
	      	<h:commandLink value="projects list" action="#{epctr.listProjects}"  />
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