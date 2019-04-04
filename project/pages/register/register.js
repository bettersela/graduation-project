// pages/register/register.js
const app = getApp()
//事件处理函数

Page({
  formSubmit: function (e) {
    var _this = this;
    console.log(e.detail.value);//发送的数据
    wx.request({
      url: 'http://localhost:8080/javaweb_war_exploded/user/insertUser.html',
      data: {
        userName: e.detail.value.username,//参数
        password: e.detail.value.password,//参数
        name: e.detail.value.name,//参数
        age: e.detail.value.age,//参数
        birthday: e.detail.value.birthday,//参数
        sex: e.detail.value.sex,//参数
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
            title: '注册成功',
            icon: 'none',
            duration: 2000
          })
          setTimeout(function () { 
            wx.navigateTo({ 
              url: '../index/index', 
            }) 
          }, 2000)/*延时跳转*/
        }
        else{
          wx.showToast({
            title: '注册失败',
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