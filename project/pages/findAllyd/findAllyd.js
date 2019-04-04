// pages/findAllyd/findAllyd.js
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
    var _this = this
    wx.request({
      url: 'http://localhost:8080/javaweb_war_exploded/yd/findAllyd.html',
      data: {
        userName: wx.getStorageSync('userName'),
      },
      method: 'GET',//方法为get
      header: {
        //"Content-Type": "application/x-www-form-urlencoded"
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8'
        //'content-type': 'application/json' //默认值
      },
      success: function (res) {
        //console.log(res.data.imgListData)
        //console.log(res.data.imgListData[0].tag)
        //将获取到的json数据，存在名字叫list_data的这个数组中

        _this.setData({
          list_data: res.data,
        })
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

  },
  go1: function (event) {
    var that=this;
    console.log(event.currentTarget.id);
    wx.request({
      url: 'http://localhost:8080/javaweb_war_exploded/yd/deleteyd.html',
      data: {
        id: event.currentTarget.id,//参数

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
          }),
          setTimeout(function () {
            that.onLoad();
          }, 2000)/*延时刷新当前页面*/
          
          
         
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
  },
   go2: function () {
    wx.navigateTo({
      url: '../insertyd/insertyd',
    })
  },
  go3: function () {
    wx.navigateTo({
      url: '../findyd/findyd',
    })
  }
})