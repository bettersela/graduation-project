// pages/deletefzjl/deletefzjl.js
const app = getApp()
//事件处理函数

Page({
  formSubmit: function (e) {
    var _this = this;
    console.log(e.detail.value);//发送的数据
    wx.request({
      url: 'http://localhost:8080/javaweb_war_exploded/fzjl/daletefzjl.html',
      data: {
        id: e.detail.value.id,//参数

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
            title: '删除成功',
            icon: 'none',
            duration: 2000
          })

          /*wx.redirectTo({
            url: '../addPage/addPage',
          })*/
        }
        else {
          wx.showToast({
            title: '删除失败',
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