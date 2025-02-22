<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.company-records.form.label.companyName" path="companyName"/>
	
	<acme:form-textbox code="authenticated.company-records.form.label.workSector" path="workSector"/>
	
	<acme:form-textbox code="authenticated.company-records.form.label.ceoName" path="ceoName"/>
	
	<acme:form-textarea code="authenticated.company-records.form.label.activityDesc" path="activityDesc"/>
	
	<acme:form-url code="authenticated.company-records.form.label.webSite" path="webSite"/>
	
	<acme:form-textbox code="authenticated.company-records.form.label.contactPhone" path="contactPhone"/>
	
	<acme:form-textbox code="authenticated.company-records.form.label.contactEmail" path="contactEmail"/>
	
	<acme:form-checkbox code="authenticated.company-records.form.label.incorporated" path="incorporated"/>

	<acme:form-textbox code="authenticated.company-records.form.label.rating" path="rating"/>
		
  	<acme:form-return code="authenticated.company-records.form.button.return"/>
</acme:form>
