<#import "parts/common.ftlh" as c>
<@c.page>
    <h1 style="">Личный кабинет</h1>
    <hr><br>
    <div style="text-align: center">
        <h2>${user.username}</h2>
        <br>
        Имя: <b> ${user.name} ${user.surname}</b>
        <br>
        Электронная почта: <b>${user.email}</b>
        <br>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" style="text-align: center; width: 100%" class="btn btn-danger mb-2">
                Выйти из акаунта
            </button>
        </form>
        <br>
        <h2>Мои товары</h2>
        <div class="card-columns">
            <#list user.cars as car>
                <a href="/${car.id}" class="car-link">
                    <div class="card text-white bg-dark my-3 product">
                        <img src="/image/${car.image.id}"
                             class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">${car.brand}</h5>
                            <p class="card-text">${car.model}</p>
                        </div>
                        <div class="card-footer">
                            <form action="/car/delete/${car.id}" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-danger">Удалить</button>
                            </form>
                        </div>
                    </div>
                </a>
            <#else>
                <h1 style="text-align: center">Не найдено</h1>
            </#list>
        </div>
    </div>
</@c.page>