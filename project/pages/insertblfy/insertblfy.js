// pages/insertblfy/insertblfy.js
const app = getApp()
//事件处理函数

Page({
  formSubmit: function (e) {
    var _this = this;
    console.log(e.detail.value);//发送的数据
    wx.request({
      url: 'http://localhost:8080/javaweb_war_exploded/blfy/insertblfy.html',
      data: {
        name: e.detail.value.name,//参数
        shijian: e.detail.value.shijian,//参数
        fanying: e.detail.value.fanying,//参数
        chixushijian: e.detail.value.chixushijian,//参数
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

          setTimeout(function () {
            wx.navigateTo({
              url: '../findAllblfy/findAllblfy',
            })
          }, 2000)/*延时跳转至查看不良反应界面*/
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
  }
})