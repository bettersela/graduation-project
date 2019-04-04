// pages/user/user.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    var userName = wx.getStorageSync('userName') || [];

    wx.request({
      url: 'http://localhost:8080/javaweb_war_exploded/user/findUser.html',
      data: {
        userName: userName,//参数
      },
      method: 'GET',//方法为get
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
        //'content-type': 'application/json' //默认值
      },
      success: function (res) {//成功
        console.log("收到的数据：" + res.data.userName);//打印收到的结果res里的内容
        console.log("收到的数据：" + res.data.password);

        _this.setData({   //设置数据
          returnname: res.data.name,
          returnage: res.data.age,
          returnbirthday: res.data.birthday,
          returnsex: res.data.sex,
        });

      },
      fail: function (res) {
        console.log(".....fail.....");
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})