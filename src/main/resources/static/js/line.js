var dom = document.getElementById("line");
var myChart = echarts.init(dom);
var app = {};
option = null;
option = {
    title: {
        subtext: '未来一周气温变化图',
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['最高气温','最低气温']
    },
    toolbox: {
        show: true,
        feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            dataView: {readOnly: false},
            magicType: {type: ['line', 'bar']},
            restore: {},
            saveAsImage: {}
        }
    },
    
    xAxis:  {
        type: 'category',
        boundaryGap: false,
        data: daysfutureArray
    },
    yAxis: {
        type: 'value',
        axisLabel: {
            formatter: '{value} °C'
        }
    },
    series: [
        {
            name:'最高气温',
            type:'line',
            data:maxfuturedaystem,
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
            name:'最低气温',
            type:'line',
            data:minfuturedaystem,
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
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}