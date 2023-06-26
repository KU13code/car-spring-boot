<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--    <title>BuyCar</title>-->
<#--</head>-->
<#--<body>-->
<#--<h1>BuyCar</h1><hr>-->
<#--<form method="get" action="/">-->
<#--    Поиск: <input type="text" name="search_request" value="${search_request?if_exists}">-->
<#--    <button type="submit">Поиск</button>-->

<#--</form>-->
<#--<#list cars as car>-->
<#--    <p><a href="/${car.id}"><b> ${car.brand}</b></a> | ${car.model} | ${car.ls} | ${car.toplivo} | ${car.price} ₽ </p>-->
<#--</#list>-->
<#--<hr>-->
<#--<h3>Добовление нового Авто:</h3>-->
<#--<form action="/" method="post" enctype="multipart/form-data">-->
<#--    Бренд: <input type="text" name="brand">-->
<#--    <br><br>-->
<#--    Модель: <input type="text" name="model">-->
<#--    <br><br>-->
<#--    ЛС: <input type="text" name="ls">-->
<#--    <br><br>-->
<#--    Топливо: <input type="text" name="toplivo">-->
<#--    <br><br>-->
<#--    Цена: <input type="text" name="price">-->
<#--    <br><br>-->
<#--    Фото: <input type="file" name="file">-->
<#--    <br><br>-->
<#--    <button type="submit">Добавить</button>-->
<#--</form>-->
<#--</body>-->
<#--</html>-->



<#import "parts/common.ftlh" as c>
<@c.page>
    <form method="get" action="/">
        <div class="form-row">
            <div class="form-group col-md-2">
                <label for="searchCity">Город</label>
                <select id="searchCity" name="" class="form-control">
                    <option value="">Город не выбран</option>
                    <#--                    <#list towns as t>-->
                    <#--                        <option <#if searchCity == t>selected</#if> value="${t}">${t}</option>-->
                    <#--                    </#list>-->
                </select>
            </div>
            <div class="form-group col-md-10">
                <label for="search_request">Поиск по объявлениям</label>
                <input type="text" name="search_request" <#if search_request??>value="${search_request}"</#if> class="form-control" id="search_request">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
        </div>
    </form>
    <div class="card-columns">
        <#list cars as car>
            <a href="/${car.id}" class="car-link">
                <div class="card text-white bg-dark my-3 product">
                    <img src="/image/${car.image.id}"
                         class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title">${car.brand}</h5>
                        <p class="card-text">${car.model}</p>
                    </div>
                    <#--                    <div class="card-footer">-->
                    <#--                        ${product.city}-->
                    <#--                    </div>-->
                    <div class="card-footer">
                        <#--                        ${product.author}-->
                    </div>
                </div>
            </a>
        <#else>
            <h1 style="text-align: center">Не найдено</h1>
        </#list>
    </div>
    <hr>
    <h3>Создание нового товара:</h3>
    <form action="/" method="post" enctype="multipart/form-data">
        Бренд: <input type="text" name="brand">
        <br><br>
        Модель: <input type="text" name="model">
        <br><br>
        ЛС: <input type="text" name="ls">
        <br><br>
        Топливо: <input type="text" name="toplivo">:
        <br><br>
        Цена: <input type="text" name="price">
        <br><br>
        Фотография: <input type="file" name="file"><br><br>
        <button type="submit">Создать</button>
    </form>
</@c.page>