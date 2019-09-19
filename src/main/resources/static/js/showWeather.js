//显示历史天的js
$(function () {
    $.ajax({
        type: "get",
        url: "/showWeather",
        async: false,
        data: {},
        success: function (data) {

            weathers = data;
        }
    })
})



