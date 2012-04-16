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
    	<h1>All Employees</h1>
    	
    	
    	<h:dataTable value="#{epctr.employees}" 
    	             var="current" 
    	             rendered="#{not empty epctr.employees}"
    	             styleClass="appTable"
    	             >
    	           
	    	<h:column>
	    		<f:facet name="header">
	    			<h:outputText value="Employee" />
	    	    </f:facet>  
	    		<h:outputText value="#{current.firstname}, #{current.lastname}"/>
	    	</h:column>
	    	<h:column>
	    		<f:facet name="header">
	    			<h:outputText value="More Info" />
	    	    </f:facet>
	    	    	<h:commandLink value="More about #{current.firstname}" action="employees.show">
	    	    		<f:setPropertyActionListener value="#{current}" target="#{epctr.employee}"/>
	    		    </h:commandLink>
	    	</h:column>			 
    	</h:dataTable>
        <h:commandLink value="new employee" action="#{epctr.newEmployee}" />	
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