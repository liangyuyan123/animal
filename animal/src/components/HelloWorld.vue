<style scoped>
    .layout{
        border: 1px solid #d7dde4;
        background: #f5f7f9;
        height: 550px;
    }
    .layout-logo{
        width: 100px;
        height: 30px;
        background: #5b6270;
        border-radius: 3px;
        float: left;
        position: relative;
        top: 15px;
        left: 20px;
    }
    .layout-nav{
        width: 420px;
        margin: 0 auto;
    }
    .layout-assistant{
        width: 300px;
        margin: 0 auto;
        height: inherit;
    }
    .layout-breadcrumb{
        padding: 10px 15px 0;
    }
    .layout-content{
        /* min-height: 200px; */
        /* margin: 15px; */
        overflow: hidden;
        background: #fff;
        border-radius: 4px;
        height:100%;
        width:100%;
		font-size:15px
    }
    .layout-content-main{
        padding: 10px;
    }
    .layout-copy{
        text-align: center;
        padding: 10px 0 20px;
        color: #9ea7b4;

    }

	.pet{
		overflow:hidden;
	}


	dl {
	    float: left;
	    width: 180px;
	    margin: 10px 10px 0 0;
	    transition: all .2s linear;
	}
	 dt {
	     display: block;
	 }

	 .hot_pet_cont dl dd {
	     background: #efefef;
	     border-top: none;
	     text-align: center;
	     height: 34px;
	     font: 14px/34px "Microsoft YaHei";
	     overflow: hidden;
	     text-overflow: ellipsis;
	     white-space: nowrap;
	     padding: 0 5px;
	 }

    .layout-ceiling{
           background: #464c5b;
           padding: 10px 0;
           overflow: hidden;
       }
       .layout-ceiling-main{
           float: right;
           margin-right: 15px;
       }
       .layout-ceiling-main a{
           color: #9ba7b5;
       }

</style>

<template>



 

    <div class="layout">
          <div class="layout-ceiling">
                      <div class="layout-ceiling-main">
                          <a href="#" @click="showLogin">登录</a> |
                          <a href="#" @click="showRegister">注册</a> |
                          <a href="#">安全中心</a> |
                          <a href="#">服务大厅</a>
                      </div>
            </div>


    		   <i-input v-model="findtext" placeholder="请输入..." style="width: 300px"></i-input>
    	     <i-button type="primary" shape="circle" icon="ios-search" @click="search"></i-button>


            <div class="layout-content">

    						<dl class="pet" v-for="dog in dogList">
    							<dt>
    							<img :src="dog.url" width="245px" height="245px">
    							</dt>
    							<dd>
    							<p>{{dog.name}}</p>
    							</dd>
    							<dd>
    							<p>{{dog.price}}RMB</p>
    							</dd>
    						</dl>

            </div>


            <div class="layout-copy">
                2019-2020 &copy; 我的宠物世界
            </div>

         <Modal v-model="visibleRegister" title="注册">
           <i-form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
                  <Form-item label="姓名" prop="userName">
                      <i-input v-model="formValidate.userName" placeholder="请输入姓名"></i-input>
                  </Form-item>

                  <Form-item label="密码" prop="password">
                      <i-input type="password" v-model="formValidate.password" placeholder="请输入密码"></i-input>
                  </Form-item>

                  <Form-item label="密码" prop="resetpassword">
                      <i-input type="password" v-model="formValidate.resetpassword" placeholder="再次确认密码"></i-input>
                  </Form-item>

                  <Form-item label="电话" prop="telphone">
                      <i-input v-model="formValidate.telphone" placeholder="请输入电话号码"></i-input>
                  </Form-item>

                  <Form-item label="邮箱" prop="email">
                      <i-input v-model="formValidate.email" placeholder="请输入邮箱"></i-input>
                  </Form-item>
                  <Form-item label="地址" prop="address">
                      <i-select v-model="formValidate.address" placeholder="请输入地址">
                          <i-option value="贺州">贺州市</i-option>
                          <i-option value="玉林">玉林市</i-option>
                          <i-option value="桂林">桂林市</i-option>
                      </i-select>
                  </Form-item>

                  <Form-item label="性别" prop="sex">

                      <input type="radio" id="female" value="女" v-model="formValidate.sex">
                      <label for="female">女</label>
                      <input type="radio" id="male" value="男" v-model="formValidate.sex">
                      <label for="male">男</label><br>
                  </Form-item>


                  <Form-item>
                      <i-button type="primary" @click="handleSubmit('formValidate')">提交</i-button>
                      <i-button type="primary" @click="handleReset('formValidate')" style="margin-left: 8px">重置</i-button>
                  </Form-item>
              </i-form>
              <div slot="footer"></div>
         </Modal>

         <Modal v-model="visibleLogin" title="登录">
           <Form ref="formInline2" :model="formInline2" :rules="ruleInline2"  >
               <FormItem prop="user" >
                   登录名：
                   <Input type="text"  v-model="formInline2.user" placeholder="Username" style="width: 200px" clearable>
                       <Icon type="ios-person-outline" slot="center"></Icon>
                   </Input>

               </FormItem>

               <FormItem prop="password">
                 密  码：
                   <Input type="password" v-model="formInline2.password" placeholder="Password" style="width: 200px" clearable>
                       <Icon type="ios-lock-outline" slot="center"></Icon>
                   </Input>

               </FormItem>

               <FormItem>
                   <Button type="primary" @click="handleSubmit2('formInline2')">登录</Button>
               </FormItem>
           </Form>
           <div slot="footer"></div>
         </Modal>
        </div>


</template>
<script>
 import axios from 'axios'
 import {Modal} from 'iview'
 import Qs from 'qs'
 import api from '@/api/global'
    export default {
            components:{
                        Modal
                    },

            data () {
                return {
                   formValidate: {
                                      userName: '',
                                      userId:'',
                                      email: '',
                                      address: '',
                                      sex: '',
                                      password:'',
                                      repassword:'',
                                      telphone:'',
                                      dataState:'',
                                      userType:''
                                  },
                                  ruleValidate: {
                                      userName: [
                                          { required: true, message: '姓名不能为空', trigger: 'blur' }
                                      ],
                                      email: [
                                          { required: true, message: '邮箱不能为空', trigger: 'blur' },
                                          { type: 'email', message: '邮箱格式不正确', trigger: 'blur' }
                                      ],
                                      address: [
                                          { required: true, message: '请选择城市', trigger: 'change' }
                                      ],
                                      sex: [
                                          { required: true, message: '请选择性别', trigger: 'change' }
                                      ],


                                  },

                                  formInline2: {
                                      userName: '',
                                      password: ''

                                  },
                                  ruleInline2: {
                                      userName: [
                                          { required: true, message: ' ', trigger: 'blur' }
                                      ],
                                      password: [
                                          { required: true, message: ' ', trigger: 'blur' }
                                      ]
                                  },
                  visibleRegister: false,
                  visibleLogin:false,
                  sex: 'man',
					        findtext:"",
                    dogList: [
                        {
                            name: '哈士奇',
                            url: 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1795859307,2340469476&fm=26&gp=0.jpg',
                            price:1800
                        },
                        {
                            name: '阿拉斯加',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569044774440&di=c737a0973784ef540d452528e29ae012&imgtype=0&src=http%3A%2F%2Fpic2.58cdn.com.cn%2Fzhuanzh%2Fn_v292baf9a21b9341939e55f57ef4015622.jpg%3Fw%3D750%26h%3D0',
                            price:2000,

                        },
                        {
                            name: '柴犬',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569044929092&di=19ea3e118797f4177b56e30fccf38795&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201806%2F22%2F20180622161630_XKRBk.jpeg',
                            price:500,

                        },
                        {
                            name: '中华田园犬',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569044866651&di=827209505c80a7b8151f21724d1db72c&imgtype=0&src=http%3A%2F%2Fgss0.baidu.com%2F-vo3dSag_xI4khGko9WTAnF6hhy%2Fzhidao%2Fpic%2Fitem%2Fdc54564e9258d109fef8ca52d358ccbf6c814d32.jpg',
                            price:250
                        },
                        {
                            name: '萨摩耶',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569045004618&di=3f529c9a3df965214fe1d85b3d9aae71&imgtype=0&src=http%3A%2F%2Fpic1.58cdn.com.cn%2Fzhuanzh%2Fn_v2a86d733a4b27464cb4ec612d179cb4bf.jpg%3Fw%3D750%26h%3D0',
                             price:2600
                        },
                        {
                            name: '八哥犬',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569045057294&di=9e6e971343ab4eb4068e9aad69a9ac38&imgtype=0&src=http%3A%2F%2Fwww.goupuzi.com%2Fimages%2Fbreed%2F16%2FHeadDesc.jpg',
                           price:880
                        },

                        {
                            name: '腊肠犬',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569045354642&di=85f1029e6804014484d9a24ea9f8a8be&imgtype=0&src=http%3A%2F%2Fwww.cndog.net%2Fdog_photo_big%2F2011-11%2F12%2F1293633-624.jpg',
                         price:999
                        }
                    ]
                }
            },

			 methods:{
         showRegister: function () {
                         this.visibleRegister = true;
                     },
         showLogin: function () {
                          this.visibleLogin = true;
                      },

				 search:function(){
					 this.dogList.map((item)=>{
						  if(this.findtext===item.name){
							 var arry2=[];
							 arry2.push(item);
							 this.dogList=arry2;
						  }

					 })



			 },
         handleSubmit (name) {

                       this.$refs[name].validate((valid) => {
                           if (valid) {
                             const axios = require('axios');

                             axios({
                                 headers: {
                                     'Content-Type': 'application/json',
                                 },
                                 method: 'post',
                                 url: '/api/user/register',
                                 data: this.formValidate
                             })

                           } else {
                               
                           }
                       })
         },
         handleReset (name) {
                       this.$refs[name].resetFields();
         },
         handleSubmit2 (name) {
             this.$refs[name].validate((valid) => {
                if (valid) {
                  const axios = require('axios');

                  axios.get('/api/user/login', {
                   	    params: {
                   	      "un": this.formInline2.user,
                   	      "pwd":this.formInline2.password,
                   	      "ut":1
                   	    }
                  })
                  .then(function (response) {
                   	    console.log(response);
                  })
                  .catch(function (error) {
                   	    console.log(error);
                  });

                } else {
                  this.$Message.error('表单数据不能为空!');
                }
              })
           }
        }
       }
</script>
