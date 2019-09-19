function initCharts7() {
    var dom = document.getElementById("allpollution");
    var Chart = echarts.init(dom);
    var app = {};
    option = null;

    console.log(dateArray)

    option = {
        title: {
            text: '近年来各个污染物含量与AQI关系',
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['AQI', 'CO', 'PM10', 'PM2.5', 'SO2', 'NO2', 'O3']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {readOnly: false},
                magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        dataZoom: {
            show: true,
            realtime: true,
            start: 0,
            end: 30
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: true,
                data: dateArray
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '       CO',
                type: 'line',
                data: coArray
            },
            {
                name: 'PM10',
                type: 'line',
                data: pm10Array
            },
            {
                name: 'PM2.5',
                type: 'line',
                data: pm25Array
            },
            {
                name: 'SO2',
                type: 'line',
                data: so2Array
            },
            {
                name: 'NO2',
                type: 'line',
                data: no2Array
            },
            {
                name: 'O3',
                type: 'line',
                data: o3Array
            },
            {
                name: 'AQI',
                type: 'bar',
                data: aqiArray
            }
        ]
    };
    if (option && typeof option === "object") {
        Chart.setOption(option, true);
    }
}