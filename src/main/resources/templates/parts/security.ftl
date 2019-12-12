<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
<#assign
user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
usr = user.isUser()
name = user.getUsername()
isAdmin = user.isAdmin()
>
<#else>
<#assign
usr = false
name = "unknown"
isAdmin = false
>
</#if>