var dom = document.getElementById("annualpollution");
var box = echarts.init(dom);
var app = {};
option = null;
var avgetime = new Array()
var avgeco = new Array()
var avgeso2 = new Array()
var avgepm25 = new Array()
var avgepm10 = new Array()
var avgeno2 = new Array()
var avgeo3 = new Array()
var showavgetime = new Array()
var showavgeco = new Array()
var showavgeso2 = new Array()
var showavgepm25 = new Array()
var showavgepm10 = new Array()
var showavgeno2 = new Array()
var showavgeo3 = new Array()
showavgetime[0] = 'product';
showavgeco[0] = 'CO';
showavgeso2[0] = 'SO2';
showavgepm25[0] = 'PM2.5';
showavgepm10[0] = 'PM10';
showavgeno2[0] = 'NO2';
showavgeo3[0] = 'O3';

$.ajax({
    type:"get",
    url:"/polMonAvgeShow",
    async:false,
    data:{},
    success:function (data) {
        console.log(data)
        avgetime = data.timeArray
        avgeco = data.co1Array
        avgeso2 = data.so2Array
        avgepm25 = data.pm25Array
        avgepm10= data.pm10Array
        avgeno2 = data.no2Array
        avgeo3 = data.o3Array

    }

})

for (i=1;i<=avgetime.length;i++){
    showavgetime[i] = avgetime[i-1]
    showavgeco[i] = avgeco[i-1]
    showavgeso2[i] = avgeso2[i-1]
    showavgepm25[i] = avgepm25[i-1]
    showavgepm10[i] = avgepm10[i-1]
    showavgeno2[i] = avgeno2[i-1]
    showavgeo3[i] = avgeo3[i-1]
}

setTimeout(function () {

    option = {
        title: {
            text: '各项污染物月平均一览图',
        },
        legend: {},
        tooltip: {
            trigger: 'axis',
            showContent: false
        },
        dataset: {
            source: [
                showavgetime,
                showavgeco,
                showavgeso2,
                showavgepm25,
                showavgepm10,
                showavgeno2,
                showavgeo3,

]
        },
        xAxis: {type: 'category'},
        yAxis: {gridIndex: 0},
        grid: {top: '55%'},
        series: [
            {type: 'line', smooth: true, seriesLayoutBy: 'row'},
            {type: 'line', smooth: true, seriesLayoutBy: 'row'},
            {type: 'line', smooth: true, seriesLayoutBy: 'row'},
            {type: 'line', smooth: true, seriesLayoutBy: 'row'},
            {type: 'line', smooth: true, seriesLayoutBy: 'row'},
            {type: 'line', smooth: true, seriesLayoutBy: 'row'},
            {type: 'line', smooth: true, seriesLayoutBy: 'row'},
            {
                type: 'pie',
                id: 'pie',
                radius: '30%',
                center: ['50%', '25%'],
                label: {
                    formatter: '{b}: {@2012} ({d}%)'
                },
                encode: {
                    itemName: 'product',
                    value: '2012',
                    tooltip: '2012'
                }
            }
        ]
    };

    box.on('updateAxisPointer', function (event) {
        var xAxisInfo = event.axesInfo[0];
        if (xAxisInfo) {
            var dimension = xAxisInfo.value + 1;
            box.setOption({
                series: {
                    id: 'pie',
                    label: {
                        formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                    },
                    encode: {
                        value: dimension,
                        tooltip: dimension
                    }
                }
            });
        }
    });

    box.setOption(option);

});
if (option && typeof option === "object") {
    box.setOption(option, true);
}