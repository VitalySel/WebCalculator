<#import "parts/common.ftl" as c>

<@c.page>
<div class="ml-5 mt-5">
    <h5>Instruction</h5>
<ul class="mt-3">
    <li> <p>Basic mathematical operations: </p>
        <ul>
           <li>+</li>
            <li>-</li>
            <li>*</li>
            <li>/</li>
        </ul>
    </li>
    <li><p>Complex expressions with parentheses are supported</p></li>
    <li><p>Negative numbers are supported</p></li>
    <li><p>Example - 5*(2+1) + 5/2 * 3 </p></li>
</ul>
</div>
<div class="ml-5 mt-3">
    <form method="post">
        <input id="form_exp" type="exp" name="exp" placeholder="Enter an expression" value="${exp?ifExists}" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button class="btn btn-primary" id="form_submit" type="submit">Calculate</button>
    </form>
</div>

<div class="ml-5 mt-3">
    Result - <span>${res?ifExists}</span>
</div>

</@c.page>