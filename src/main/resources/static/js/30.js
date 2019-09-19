var dom = document.getElementById("30");
var myChart = echarts.init(dom);
var app = {};
option = null;
app.title = '折柱混合';


// $.ajax({
//     type:"get",
//     url:"/showfuturewather",
//     async: false,
//     data:{},
//     success:function (data) {
//         console.log(data)
//         var weathers = new Array();
//         weathers = data;
//         for (var i = 0;i < weathers.length;i++) {
//             datefutureArray[i] = weathers[i].weatherTime
//             maxfuture30tem[i] = weathers[i].tem.substring(3,5)
//             minfuture30tem[i] = weathers[i].tem.substring(0,2)
//         }
//     },
//
// })

option = {
    title: {
        subtext: '未来一月气温变化图'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['最高气温','最低气温']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataZoom : {show: true},
            dataView : {show: true},
            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    dataZoom : {
        show : true,
        realtime : true,
        start : 20,
        end : 80
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data :datefutureArray
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'最高',
            type:'line',
            data:maxfuturemontem,
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        },
        {
            name:'最低',
            type:'line',
            data:minfuturemontem,
            markPoint: {
                data: [
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        }
    ]
};
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}