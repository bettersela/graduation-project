const Bmob = require('../../../utils/Bmob-1.7.0.min.js');

Page({
  onLoad() {
    let Diary = Bmob.Object.extend("User"); 
    let query = new Bmob.Query(Diary);
    query.find({
      success: (results) => {
        console.log(results)
      },
      error(error) {
        console.log(`查询失败: ${error.code} ${error.message}`);
      }
    });
  },
})
