// pages/insertfzjl1/insertfzjl1.js
const app = getApp()
//事件处理函数
var util = require('../../utils/util.js')
Page({
  data: {
    date: util.formatDate(new Date()),
  },
  formSubmit: function (e) {
    var _this = this;
    console.log(e.detail.value);//发送的数据
    var datearray = e.detail.value.date.split("-");

    wx.request({
      url: 'http://localhost:8080/javaweb_war_exploded/fzjl/insertfzjl.html',
      data: {
        year: datearray[0],//参数
        month: datearray[1],//参数
        day: datearray[2],//参数
        shichang: "1分钟",//参数
        leixing: "",//参数
        zhuangtai:"",//参数
        userName: wx.getStorageSync('userName'),

      },
      method: 'GET',//方法为get
      header: {
        //"Content-Type": "application/x-www-form-urlencoded"
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8'
        //'content-type': 'application/json' //默认值
      },
      success: function (res) {//成功

        if (res.data == "ok") {
          wx.showToast({
            title: '添加成功',
            icon: 'none',
            duration: 2000
          })

          /*wx.redirectTo({
            url: '../addPage/addPage',
          })*/
        }
        else {
          wx.showToast({
            title: '添加失败',
            icon: 'none',
            duration: 2000
          })
        }
      },
      fail: function (res) {
        console.log(".....fail.....");
      }
    })
  },

  bindDateChange: function (e) {
    console.log(e)
    this.setData({
      date: e.detail.value
    })
  },
})