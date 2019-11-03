import Vue from 'vue'
import axios from 'axios'
import Qs from 'qs'
export default {
    //登录接口
    login: function (data) {
    return axios({
       headers: {
           'deviceCode': ' '
       },
       method: 'post',
       url: '/api/user/login',
       data: Qs.stringify(data)
     });
   },
   //注册接口
   register: function (data) {
   return axios({
      headers: {
          'deviceCode': ' '
      },
      method: 'post',
      url: '/api/register',
      data: Qs.stringify(data)
    });
  },

 //修改密码
 pwdChange: function (data) {
 return axios({
    headers: {
        'deviceCode': ' '
    },
    method: 'post',
    url: '/api/pwdChange',
    data: Qs.stringify(data)
  });
}
}
