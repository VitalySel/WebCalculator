<#import "parts/common.ftl" as c>
<@c.page>
<h5 class="mt-5">List of users</h5>
<table class="table mt-5">
    <thead class="thead-inverse">
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/user/${user.id}">Edit</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>