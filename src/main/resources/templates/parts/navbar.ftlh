<#include "security.ftlh"/>
<#macro navbar>
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a href="/">
                <span class="navbar-brand mb-0 h1">BUYCAR</span>
            </a>
            <#if auth>
                <form action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" style="text-align: center; width: 100%" class="btn btn-danger mb-2">
                        Выйти из аккаунта
                    </button>
                </form>
            <#else>
                <button class="btn btn-light my-2 my-sm-0" type="button"
                        onclick="window.location.href = '/login'">
                    Войти
                </button>
            </#if>
        </div>
    </nav>
</#macro>