Page({
  ToDisease() {//健康管理跳转到病程记录
    wx.navigateTo({
      url: '/HealthManager/Management/Disease/disease',
    })
  },
  
  ToMedicine() {//健康管理跳转到服药记录
    wx.navigateTo({
      url: '/HealthManager/Management/Medicine/medicine',
    })
  
  }


})