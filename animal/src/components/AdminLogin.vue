<template>

  <div class="userLogin">
      <div class="text" style="color:black">
         <Avatar style="color:#f56a00;background-color: #fde3cf">U</Avatar>
          管理员登录界面
      </div>
    <div class="inwar" style="color:black">
            <Form ref="formInline" :model="formInline" :rules="ruleInline"  >
                <FormItem prop="user" >
                    登录名：
                    <Input type="text"  v-model="formInline.user" placeholder="Username" style="width: 200px" clearable>
                        <Icon type="ios-person-outline" slot="center"></Icon>
                    </Input>

                </FormItem>

                <FormItem prop="password">
                  密  码：
                    <Input type="password" v-model="formInline.password" placeholder="Password" style="width: 200px" clearable>
                        <Icon type="ios-lock-outline" slot="center"></Icon>
                    </Input>

                </FormItem>


                    <FormItem>
                        <Button type="primary" @click="handleSubmit('formInline')">登录</Button>

                    </FormItem>
            </Form>
            </div>
          <div class="corp">
            <p>2019-2020&copy;我的宠物世界</p>
        </div>
  </div>

</template>

<script>
import router from '@/router/index'
import { Message } from 'iview'
import axios from 'axios';
import api from '@/api/global'
export default {

        data () {
            return {
                formInline: {
                    user: '',
                    password: ''

                },
                ruleInline: {
                    user: [
                        { required: true, message: ' ', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: ' ', trigger: 'blur' }
                    ]
                }
            }
        },



        created() {
          console.log("login created");
          localStorage.setItem("login_message",0)
        },
        methods: {

          handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {

                        const axios = require('axios');


						axios.get('/api/user/login', {
						    params: {
						      "un": this.formInline.user,
						      "pwd":this.formInline.password,
						      "ut":1
						    }
						  })
						  .then(function (response) {
                console.log(response);
						    console.log(response.data);
                if(response.data===null||response.data===""){
                  Message.error('请检查你的账户名和密码是否正确!');
                }
                else{
                  Message.success("登录成功");
                  router.push({ path: '/AdminIndex' }) ;
                }
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.userLogin{
    text-align: center;
    line-height: 250px;
    background: url('~@/assets/test1.jpg') no-repeat 100%;
    background-size: cover;
     }
     .text{
              text-align:center;
              font-size: 18px;
              color: #ffffff;
          }
      .corp{
        text-align:center;
        font-size: 18px;
      }
      .inwar{
          text-align: center;
          color: #ffffff;
      }


</style>
