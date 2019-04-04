//index.js   事件处理函数如下
const app = getApp()
//事件处理函数

Page({
formSubmit: function(e) {
  var _this = this;
  console.log(e.detail.value);//发送的数据
  wx.request({
    url: 'http://localhost:8080/javaweb_war_exploded/user/checkLogin.html',
    data: {
      userName: e.detail.value.username,//参数
      password: e.detail.value.password,//参数
     
    },
    method: 'GET',//方法为get
    header: {
      "Content-Type": "application/x-www-form-urlencoded"
      //'content-type': 'application/json' //默认值
    },
    success: function (res) {//成功
      console.log("收到的数据：" + res.data.userName);//打印收到的结果res里的内容
      console.log("收到的数据：" + res.data.password);

      if(res.data!="null"){
        wx.showToast({
          title: '成功',
          icon: 'none',
          duration: 2000
        })
        wx.setStorageSync('userName', res.data.userName)
        // console.log("1111");
        wx.navigateTo({
          url: '../addPage/addPage?',
        })
        // console.log("2222");
      }
    },
    fail: function (res) {
      console.log(".....fail.....");
    }
  })
},
go:function(){
  wx.navigateTo({
    url: '../register/register',
  })
},

})