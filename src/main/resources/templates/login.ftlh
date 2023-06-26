<#import "parts/common.ftlh" as c>
<@c.page>
    <div style="text-align: center">
        <form action="/login" method="post">
            <div class="form-group">
                <label for="email">Электронная почта</label>
                <input type="email" class="form-control <#if RequestParameters.error??>is-invalid</#if>" id="email" name="username">
                <div id="email" class="invalid-feedback">
                    Неверная электронная почта
                </div>
            </div>
            <div class="form-group">
                <label for="password">Пароль</label>
                <input type="password" class="form-control <#if RequestParameters.error??>is-invalid</#if>" id="password" name="password">
                <div id="password" class="invalid-feedback">
                    Неверный пароль
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" style="width: 100%" class="btn btn-dark">Войти</button>
        </form>
    </div>
    <h2>Нет аккаунта BUYCAR? <a href="/registration">Зарегистрируйся!</a></h2>

</@c.page>