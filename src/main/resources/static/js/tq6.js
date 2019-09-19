function initCharts6() {
    var dom = document.getElementById("tq6");
//var dom1 = document.getElementById("con");

//var mychar = echecharts.init(dom1);
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        title: {
            text: 'O3（臭氧）指数一览',
        },
        tooltip: {
            trigger: 'axis'
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataZoom: {show: true},
                dataView: {show: true},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        dataZoom: {
            show: true,
            realtime: true,
            y: 36,
            height: 20,
            start: 0,
            end: 30
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
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
                name: '    03指数',
                type: 'line',
                data: o3Array,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: 'ave'}
                    ]
                }
            }
        ],
        calculable: false
    };

    if (option && typeof option === "object") {
        myChart.setOption(option, true);
//  mychar.setOption(option, true);
    }
}