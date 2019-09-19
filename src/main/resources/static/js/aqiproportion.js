var dom = document.getElementById("apiproportion");
var myChart = echarts.init(dom);
var app = {};

var you = 0
var liang = 0
var zhong = 0
var qing = 0
var zd = 0


$.ajax({
    type:"get",
    url:"/polDaysSelect",
    async:false,
    data:{},
    success:function (data) {
        // console.log(data)
        you = data.you
        liang = data.liang
        zhong = data.zhong
        qing = data.qd
        zd = data.zd
    }
})

option = null;
option = {
    title: {
        text: '污染分布占比',
        left: 'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        bottom: 10,
        left: 'center',
    },
    series : [
        {
            type: 'pie',
            radius : '65%',
            center: ['50%', '50%'],
            selectedMode: 'single',
            data:[
                {value:you, name: '优',itemStyle:{
                    color:'#43ce17'
                }},
                {value:liang, name: '良',itemStyle:{
                        color:'#e2d22b'
                    }},

                {value:qing, name: '轻度污染',itemStyle:{
                        color:'#e8a022'
                    }},
                {
                    value:zhong,
                    name: '中度污染',
                    itemStyle:{
                        color:'#EE4000'
                    }
                },
                {value:zd, name: '重度污染',itemStyle:{
                        color:'#8B1C62'
                    }},



                
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}