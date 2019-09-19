function initCharts4() {
    var dom = document.getElementById("tq4");
//var dom1 = document.getElementById("con");


//var mychar = echecharts.init(dom1);
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        title: {
            text: 'SO2（二氧化硫）指数一览',
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
            //orient: 'vertical',   // 'horizontal'
            //x: 0,
            y: 36,
            //width: 400,
            height: 20,
            //backgroundColor: 'rgba(221,160,221,0.5)',
            //dataBackgroundColor: 'rgba(138,43,226,0.5)',
            //fillerColor: 'rgba(38,143,26,0.6)',
            //handleColor: 'rgba(128,43,16,0.8)',
            //xAxisIndex:[],
            //yAxisIndex:[],
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
                name: '    SO2指数',
                type: 'line',
                data: so2Array,
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