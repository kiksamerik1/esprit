<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<META http-equiv="Content-type" content="text/html; charset=UTF-8">
<f:view>
    <html>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/application.css"/>
    
    <head>
        <title>list</title>
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
    <h:form>	
    	<h1>All Projects</h1>
    	
    	
    	<h:dataTable value="#{epctr.projects}" 
    	             var="current" 
    	             rendered="#{not empty epctr.projects}"
    	             styleClass="appTable"
    	             >
    	           
	    	<h:column>
	    		<f:facet name="header">
	    			<h:outputText value="Project" />
	    	    </f:facet>  
	    		<h:outputText value="#{current.name}"/>
	    	</h:column>
	    	<h:column>
	    		<f:facet name="header">
	    			<h:outputText value="More Info" />
	    	    </f:facet>
	    	    	<h:commandLink value="More about #{current.name}" action="projects.show">
	    	    		<f:setPropertyActionListener value="#{current}" target="#{epctr.project}"/>
	    		    </h:commandLink>
	    	</h:column>			 
    	</h:dataTable>
        <h:commandLink value="new project" action="#{epctr.newProject}" />	
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