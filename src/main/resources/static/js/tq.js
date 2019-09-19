function initCharts(){
    var dom = document.getElementById("tq");



    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        title: {
            text: 'AQI指数',
        },
        tooltip : {
            trigger: 'axis'
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataZoom : {show: true},
                dataView : {show: true},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        dataZoom : {
            show : true,
            realtime : true,
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
            start : 0,
            end : 30
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : dateArray
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        visualMap: {//区间内控制显示颜色
            show: false,
            dimension: 1,
            pieces: [
                {gte: 0, lte: 50, color: '#43ce17'},
                {gte: 50, lte: 100, color: '#e2d22b'},
                {gte: 101, lte: 150, color: '#e8a022'},
                {gte: 151, lte: 200, color: '#EE4000'},
                {gte: 201, lte: 300, color: '#8B1C62'}
            ],
        },
        series : [
            {
                name:'     aqi指数',
                type:'line',
                data:aqiArray,
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
        calculable:false
    };

    if (option && typeof option === "object") {
        myChart.setOption(option, true);
//  mychar.setOption(option, true);
    }
}
