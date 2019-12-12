<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/user" method="post" class="ml-5 mt-5">
        <h5>User editor</h5>
        <div class="form-group row ">
            <label class="col-sm-2 col-form-label">User name:</label>
            <div class="col-sm-6">
                <input type="text" name="username" value="${user.username}">
            </div>
        </div>
            <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
        </div>
            </#list>
<input type="hidden" value="${user.id}" name="userId">
<input type="hidden" value="${_csrf.token}" name="_csrf">
<button class="btn btn-primary mt-3" type="submit">Save changes</button>
</form>
</@c.page>