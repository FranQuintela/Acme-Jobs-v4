<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.messageThread.form.label.title" path="title" />
	<acme:form-moment code="authenticated.messageThread.form.label.moment" path="moment" />
	<acme:form-textbox code="authenticated.messageThread.form.label.creator" path="creator.userAccount.username" />
 	<acme:form-submit code="authenticated.messageThread.form.button.messages" action="/authenticated/message/list?id=${id}" method="get" />	
	<acme:form-return code="authenticated.messageThread.form.button.return"/>
	
	
</acme:form>
