var dom = document.getElementById("todayweather");
var myChart = echarts.init(dom);
var app = {};

var daysfutureArrayDao = new Array()
var maxfuturedaystemDao = new Array()
var minfuturedaystemDao = new Array()
var monfutureArrayDao = new Array()
var maxfuturemontemDao = new Array()
var minfuturemontemDao = new Array()



$.ajax({
    type:"get",
    url:"/showtodayweather",
    async: false,
    data:{
        "cityname":$("#s_city").val()
    },
    success:function (data) {
        // console.log(data)
        //实时显示
        nowtemp = data.todayWeather.nowtemp
        nowstatus = data.todayWeather.nowstatus
        nowwind =data.todayWeather.nowwind + data.todayWeather.nowwindnum
        nowRH = data.todayWeather.nowhumidity
        $("#nowtemp").text(nowtemp+"℃")
        $("#nowstatus").text(nowstatus)
        $("#nowwindandrh").text(nowwind+'\t'+'\t'+'相对湿度：'+nowRH+"%")
        //预测
        var todayForecast = new Array()
        todayForecast = data.todayForrcast
        console.log(todayForecast)
        for (var i = 0;i< todayForecast.length; i++){
            var dateStr = new Date(todayForecast[i].nowtime).Format("yyyy/MM/dd hh:mm:ss");
            todayForecastDate[i] = dateStr
            todayForecastTemp[i] = todayForecast[i].nowtemp
            todayForecastRh[i] = todayForecast[i].nowsd
            todayForecastYq[i] = todayForecast[i].nowyq
            todayForecastWind[i] = todayForecast[i].nowfs
        }
        //未来7天
        var daysforeacst = new Array()
        daysforeacst = data.daysForecast
        for (var i = 0; i < daysforeacst.length;i++){
            daysfutureArrayDao[i] = daysforeacst[i].weatherTime
            maxfuturedaystemDao[i] = daysforeacst[i].tem.substring(3,5)
            minfuturedaystemDao[i] = daysforeacst[i].tem.substring(0,2)
        }
        for (i=6,j=0;j<7;i--,j++){
            daysfutureArray[j] = daysfutureArrayDao[i]
            maxfuturedaystem[j] = maxfuturedaystemDao[i]
            minfuturedaystem[j] = minfuturedaystemDao[i]
        }


        //30天预测
        var monForecast = new Array()
        monForecast = data.monForecast
        for (var i =0 ;i<monForecast.length;i++){
            monfutureArrayDao[i] = monForecast[i].weatherTime
            maxfuturemontemDao[i] = monForecast[i].tem.substring(3,5)
            minfuturemontemDao[i] = monForecast[i].tem.substring(0,2)
        }

        for (i = 29,j=0;j<30;j++,i--){
            datefutureArray[j] = monfutureArrayDao[i]
            maxfuturemontem[j] = maxfuturemontemDao[i]
            minfuturemontem[j] = minfuturemontemDao[i]

        }

    }
})
option = null;
option = {
    title: {
        subtext: '按小时分布',
        subtext: '\n'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['温度','相对湿度','压强']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: todayForecastDate
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name:'温度',
            type:'line',
            stack: '总量',
            data:todayForecastTemp
        },
        {
            name:'相对湿度',
            type:'line',
            stack: '总量',
            data:todayForecastRh
        },
        {
            name:'压强',
            type:'line',
            stack: '总量',
            data:todayForecastYq
        }
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}