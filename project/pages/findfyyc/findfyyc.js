// pages/findfyyc/findfyyc.js
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

  },
  formSubmit: function (e) {
    var _this = this;
    var userName = wx.getStorageSync('userName') || [];
    console.log(e.detail.value);//发送的数据
    wx.request({
      url: 'http://localhost:8080/javaweb_war_exploded/fyyc/findfyycByName.html',
      data: {
        userName: userName,//参数
        name: e.detail.value.name,
      },
      method: 'GET',//方法为get
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
        //'content-type': 'application/json' //默认值
      },
      success: function (res) {//成功


        _this.setData({   //设置数据
          list_data: res.data,
        });

      },
      fail: function (res) {
        console.log(".....fail.....");
      }
    })
  },
})